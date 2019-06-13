package com.huawei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * User: yi
 * ClassName: MyApplication
 * Date:     2019/05/31 21:47
 */
@SpringBootApplication
@MapperScan(value = "com.huawei.mapper")
public class MyApplication{

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}
