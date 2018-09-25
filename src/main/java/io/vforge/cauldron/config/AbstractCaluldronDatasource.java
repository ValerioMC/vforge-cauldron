package io.vforge.cauldron.config;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class AbstractCaluldronDatasource {

    protected Map<String, Object> buildJpaProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        props.put("hibernate.ddl-auto", "create");

        return props;
    }
}
