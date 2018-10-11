package io.vforge.cauldron.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.HashMap;

@RequiredArgsConstructor
@PropertySource({"classpath:persistence/persistence-secondarydb.properties"})
@EnableJpaRepositories(basePackages = "io.vforge.cauldron.repository.secondary",
        entityManagerFactoryRef = "secondaryEntityManagerFactory",
        transactionManagerRef = "secondaryTransactionManager")
@Configuration
@Order(value = 2)
public class CauldronSecondaryDatasource {

    private final Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(secondaryDataSource());
        em.setPackagesToScan("io.vforge.cauldron.model.secondary");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("secondary.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("secondary.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("secondary.hibernate.show_sql"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public HikariDataSource secondaryDataSource() {
        final HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(env.getProperty("secondary.datasource.url"));
        dataSource.setUsername(env.getProperty("secondary.datasource.username"));
        dataSource.setPassword(env.getProperty("secondary.datasource.password"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager secondaryTransactionManager() {
        JpaTransactionManager transactionManager= new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                secondaryEntityManagerFactory().getObject());
        return transactionManager;
    }

}
