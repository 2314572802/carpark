package com.xfy.carpark.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfiguration {
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    @Bean
    public DruidDataSource druidDataSource(){
        return new DruidDataSource();
    }
}
