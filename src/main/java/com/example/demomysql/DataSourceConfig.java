package com.example.demomysql;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@SpringBootConfiguration
public class DataSourceConfig {
    //指定当前对象作为bean
    @Bean(name = "dataSource")
    //指定dataSource来DI
    @Qualifier(value = "dataSource")
    //primary将当前数据库连接池作为默认数据库连接池
    @Primary
    //在application.properties文件中增加前缀c3p0
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
        dataSource.setMaxConnectionAge(Integer.MAX_VALUE);
        dataSource.setInitialPoolSize(10);
        dataSource.setMaxPoolSize(10);
        dataSource.setMinPoolSize(10);
        dataSource.setMaxIdleTime(Integer.MAX_VALUE);
        return dataSource;
    }

}
