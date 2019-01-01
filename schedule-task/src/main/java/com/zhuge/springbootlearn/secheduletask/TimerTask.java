package com.zhuge.springbootlearn.secheduletask;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/*@Component*/
@ConfigurationProperties(prefix = "schedule")
public class TimerTask implements InitializingBean {

    private String dateFormatter;

    private SimpleDateFormat sdf;

    @Scheduled(fixedRate = 2000)
    public void run() {
        System.out.println(String.format("%s: run is called !",
                sdf.format(new Date())));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        sdf = new SimpleDateFormat(dateFormatter);
    }

    public String getDateFormatter() {
        return dateFormatter;
    }

    public void setDateFormatter(String dateFormatter) {
        this.dateFormatter = dateFormatter;
    }
}
