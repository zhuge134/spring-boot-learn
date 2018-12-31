package com.zhuge.springbootlearn.fileupload.service;

import com.zhuge.springbootlearn.fileupload.service.impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: FileServiceConfig
 * @Description:
 * @author: zhuge
 * @date: 2018/12/31 22:28
 */

@Configuration
@EnableConfigurationProperties({FileServiceProperty.class})
public class FileServiceConfig {

    @Bean
    @Qualifier("defaultFileServiceImpl")
    public FileService fileService(FileServiceProperty property) {
        return new FileServiceImpl(property);
    }
}
