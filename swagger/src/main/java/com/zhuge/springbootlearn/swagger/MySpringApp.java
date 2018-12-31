package com.zhuge.springbootlearn.swagger;

import com.zhuge.springbootlearn.swagger.domain.Goods;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
@Import({SwaggerConfig.class})
@MapperScan(basePackages = {"com.zhuge.springbootlearn.swagger.dao"})
public class MySpringApp {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MySpringApp.class, args);
        RestTemplate restTemplate = ctx.getBean(RestTemplate.class);
        ResponseEntity<Goods> responseEntity =
                restTemplate.getForEntity(
                        "http://localhost:8080/goodsController/query?id={id}",
                        Goods.class, 8);
        System.out.println(responseEntity.toString());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner pringtBeans(ApplicationContext ctx) {
        System.out.println("All beans loaded when application container start!");
        return args -> Arrays.stream(ctx.getBeanDefinitionNames())
                .forEach(System.out::println);
    }
}
