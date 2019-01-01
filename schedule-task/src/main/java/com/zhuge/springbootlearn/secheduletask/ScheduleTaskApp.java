package com.zhuge.springbootlearn.secheduletask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Title: ScheduleTaskApp
 * @Description:
 * @author: zhuge
 * @date: 2019/1/1 12:44
 */
@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({TimerTask.class})
public class ScheduleTaskApp {
    public static void main(String[] args) {
        SpringApplication.run(ScheduleTaskApp.class, args);
    }
}
