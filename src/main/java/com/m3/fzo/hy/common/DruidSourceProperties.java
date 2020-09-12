package com.m3.fzo.hy.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidSourceProperties {
    /**
     * jdbc
     */
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    /**
     * jdbc connection pool
     */
    private int initialSize;
    private int maxIdle;
    private int maxActive = 100;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    /**
     * filter
     */
    private String filters;
}
