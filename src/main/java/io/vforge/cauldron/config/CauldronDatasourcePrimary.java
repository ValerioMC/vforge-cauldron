package io.vforge.cauldron.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;



import javax.sql.DataSource;

@EnableJpaRepositories(basePackages = "io.vforge.cauldron.repository.primary",
        entityManagerFactoryRef = "updatedEntityManagerFactory")
@EnableJpaAuditing
@Configuration
public class CauldronDatasourcePrimary extends AbstractCaluldronDatasource {

    @Primary
    @Bean(name = "updatedEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    updatedEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                @Qualifier("dataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("io.vforge.cauldron.model.primary")
                .properties(buildJpaProperties())
                .build();
    }

}
