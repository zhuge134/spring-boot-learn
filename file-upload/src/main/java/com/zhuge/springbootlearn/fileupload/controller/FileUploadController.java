package com.zhuge.springbootlearn.fileupload.controller;


import com.zhuge.springbootlearn.fileupload.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

/*@RestController*/
@Controller
@RequestMapping(path = "/fileUpload")
@Api(description = "description",
        tags = {"tag1"})
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @PostMapping(path = "/")
    @ApiOperation(value = "上传文件",
            notes = "用于上传文件",
            tags = {"tag1", "tag2"})
    public String upload(@RequestParam MultipartFile file,
                         RedirectAttributes redirectAttributes) throws Exception {
        fileService.store(file);
        redirectAttributes.addFlashAttribute("message",
                String.format("Upload file: %s success!", file.getOriginalFilename()));
        return "redirect:/fileUpload/";
    }

    @GetMapping(path = "/")
    @ApiOperation(value = "所有文件", notes = "列出所有文件")
    public String listAllFiles(Model model) throws Exception {
        model.addAttribute("files",
                Arrays.stream(fileService.listAll().toArray(new Path[0]))
                        .map(path ->
                                MvcUriComponentsBuilder.fromMethodName(
                                        FileUploadController.class, "download",
                                        path.getFileName().toString())
                                        .build().toString())
                        .collect(Collectors.toList()));
        return "uploadForm.html";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    @ApiOperation(value = "下载文件", notes = "下载文件")
    public ResponseEntity<Resource> download(@PathVariable String filename) throws Exception {
        Resource resource = fileService.load(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        String.format("attachment; filename=\"%s\"", resource.getFilename()))
                .body(resource);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .build();
    }
}
