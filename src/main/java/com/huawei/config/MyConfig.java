package com.huawei.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.SQLException;

/**
 * User: yi
 * ClassName: MyConfig
 * Date:     2019/06/08 12:40
 */
@Configuration
public class MyConfig {
    @Value("${my.datasource.username}")
    private String username;
    @Value("${my.datasource.password}")
    private String password;
    @Value("${my.datasource.url}")
    private String url;
    @Value("${my.datasource.driver}")
    private String driver;

    @Bean(name = "aaa")
    public DataSource getDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriver(new Driver());
        return dataSource;
    }

}
