package com.m3.fzo.hy.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.m3.fzo.hy.common.DruidSourceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableConfigurationProperties(DruidSourceProperties.class)
public class DruidConfig {
    private static final Logger log = LoggerFactory.getLogger(DruidConfig.class);
    private final DruidSourceProperties properties;

    public DruidConfig(DruidSourceProperties druidSourceProperties) {
        this.properties = druidSourceProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public DataSource druidDataSource(){
        System.err.println(properties.toString());
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName(properties.getDriverClassName());
        source.setInitialSize(properties.getInitialSize());
        source.setMaxActive(properties.getMaxActive());
        source.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());
        source.setMaxWait(properties.getMaxWait());
        source.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        source.setPassword(properties.getPassword());
        source.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        source.setUrl(properties.getUrl());
        source.setUsername(properties.getUsername());
        source.setValidationQuery(properties.getValidationQuery());
        try {
            source.setFilters(properties.getFilters());
            source.init();
        } catch (SQLException e) {
            log.error(e.getMessage(),e);
        }
        return source;
    }

    @Bean
    @ConditionalOnMissingBean
    public ServletRegistrationBean<Servlet> druidServlet(){
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        servletServletRegistrationBean.addInitParameter("allow","127.0.0.1");
        servletServletRegistrationBean.addInitParameter("loginUsername","admin");
        servletServletRegistrationBean.addInitParameter("loginPassword","admin123");
        servletServletRegistrationBean.addInitParameter("resetEnable","true");
        return servletServletRegistrationBean;
    }

    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean<Filter> filterFilterRegistrationBean(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new WebStatFilter());
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterFilterRegistrationBean;
    }
}
