package com.zhuge.springbootlearn.fileupload.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

/**
 * @Title: FileService
 * @Description:
 * @author: zhuge
 * @date: 2018/12/31 21:26
 */
public interface FileService {

    void store(MultipartFile file) throws Exception;

    List<Path> listAll() throws Exception;

    Path getPath(String fileName) throws Exception;

    Resource load(String fileName) throws Exception;

    void delete(String fileName) throws Exception;
}
