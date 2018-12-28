package com.zhuge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * @Title: MySpringBootApp
 * @Description:
 * @author: zhuge
 * @date: 2018/12/28 22:06
 */

@SpringBootApplication
@EnableConfigurationProperties(value = {})
@MapperScan("com.zhuge.dao")
public class MySpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApp.class, args);
    }

    @Bean
    public CommandLineRunner getCmdRunner(@Autowired final ApplicationContext ctx) {
        return args -> {
            Arrays.stream(ctx.getBeanDefinitionNames())
                    .forEach(System.out::println);
        };
    }
}
