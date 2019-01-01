package com.zhuge.springbootlearn.formprocess;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Title: FormProcessApp
 * @Description:
 * @author: zhuge
 * @date: 2019/1/1 18:59
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zhuge.springbootlearn.formprocess.dao")
public class FormProcessApp {
    public static void main(String[] args) {
        SpringApplication.run(FormProcessApp.class, args);
    }
}
