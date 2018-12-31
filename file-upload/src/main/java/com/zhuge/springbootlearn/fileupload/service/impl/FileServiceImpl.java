package com.zhuge.springbootlearn.fileupload.service.impl;

import com.zhuge.springbootlearn.fileupload.service.FileService;
import com.zhuge.springbootlearn.fileupload.service.FileServiceProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title: FileServiceImpl
 * @Description:
 * @author: zhuge
 * @date: 2018/12/31 22:23
 */
@Service
public class FileServiceImpl implements FileService {

    private Path rootPath;

    public FileServiceImpl(FileServiceProperty property) {
        rootPath = Paths.get(property.getRootDir());
    }

    @Override
    public void store(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Can not save empty file !");
        }
        Files.copy(file.getInputStream(), rootPath.resolve(file.getOriginalFilename()));
    }

    @Override
    public List<Path> listAll() throws Exception {
        return Files.list(rootPath).collect(Collectors.toList());
    }

    @Override
    public Path getPath(String fileName) throws Exception {
        Path path = rootPath.resolve(fileName);
        if (!Files.exists(path)) {
            throw new IllegalArgumentException(String.format("File: %s does not exists !", fileName));
        }
        return path;
    }

    @Override
    public Resource load(String fileName) throws Exception {
        Path path = getPath(fileName);
        return new UrlResource(path.toUri());
    }

    @Override
    public void delete(String fileName) throws Exception {
        Path path = getPath(fileName);
        Files.delete(path);
    }
}
