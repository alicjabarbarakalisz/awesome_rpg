package com.umusic.awesome_rpg.dao.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@Configuration
public class RpgDataConfig {

    @Bean
    @ConfigurationProperties("rpg.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "rpgDataSource")
    public DataSource rpgDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306")
                .username("rpg")
                .password("rpg")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(rpgDataSource());
    }

    @Bean
    public TransactionManager transactionManager() {
        return new DataSourceTransactionManager(rpgDataSource());
    }
}
