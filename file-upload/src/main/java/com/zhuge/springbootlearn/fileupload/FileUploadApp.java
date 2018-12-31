package com.zhuge.springbootlearn.fileupload;

import com.zhuge.springbootlearn.fileupload.service.FileServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Title: FileUploadApp
 * @Description:
 * @author: zhuge
 * @date: 2018/12/31 20:48
 */
@SpringBootApplication
@EnableSwagger2
@Import({SwaggerConfig.class, FileServiceConfig.class})
public class FileUploadApp {
    public static void main(String[] args) {
        SpringApplication.run(FileUploadApp.class, args);
    }
}
