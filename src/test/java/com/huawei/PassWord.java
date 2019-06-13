package com.huawei;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * User: yi
 * ClassName: PassWord
 * Date:     2019/06/08 08:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class PassWord {

    @Autowired
    private StringEncryptor stringEncryptor;
    @Autowired
    private ApplicationContext app;

    @Test
    public void fun01() {
        String str1 = stringEncryptor.encrypt("root");
        String str2 = stringEncryptor.encrypt("root");
        System.out.println("str1=" + str1 + "str2=" + str2);
    }

    @Test
    public void fun02() {
        System.out.println(stringEncryptor.decrypt("TJbVsttLZbOsIDdpq6S8ow=="));
        System.out.println(stringEncryptor.decrypt("7ImztlqP8aZHDUoyH0DOZw=="));
    }

    @Test
    public void fun03() {
        String[] names = app.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void fun04() {
        /*获取数据源配置的名称*/
//        DataSource dataSource = app.getBean(DataSource.class);
//        String name = dataSource.getClass().getSimpleName();
        DataSource aaa = (DataSource) app.getBean("aaa");
        System.out.println("-----" + aaa.getClass().getName());
    }


}
