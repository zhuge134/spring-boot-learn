package com.zhuge.springbootlearn.fileupload.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Title: FileServiceProperty
 * @Description:
 * @author: zhuge
 * @date: 2018/12/31 22:28
 */
@ConfigurationProperties(prefix = "file-service")
public class FileServiceProperty {

    private String rootDir;

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }
}
