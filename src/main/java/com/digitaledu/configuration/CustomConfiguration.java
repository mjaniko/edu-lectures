package com.digitaledu.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:custom.properties")
public class CustomConfiguration {

    @Value("${custom.prefix}")
    private String prefix;

    public String getPrefix() {
        return this.prefix;
    }
}
