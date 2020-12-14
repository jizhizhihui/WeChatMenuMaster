package com.wxMenuConsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxMenuAPI.common.result.CommonResult;
import com.wxMenuAPI.project.service.IFileService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
@Log4j2
@Api(tags = "文件")
public class FileController {
    @Autowired
    private ResourceLoader resourceLoader;
    @Reference(version = "1.0.0")
    private IFileService fileService;

    @Value("${spring.file.imagePath}")
    private String path;

     /**
     * @param file 文件
     * @return
     */
    @PostMapping("image-upload")
    public CommonResult upload(@RequestParam("fileName") MultipartFile file) {

        if (fileService.uploadImage(file,path)) {
            // 上传成功，给出页面提示
            return CommonResult.success("上传成功：" + file.getOriginalFilename());
        } else {
            return CommonResult.success("上传失败");
        }
    }

    /**
     * @param fileName 文件名
     * @return
     */
    @GetMapping(value = "image-show{fileName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public CommonResult show(@PathVariable String fileName) {
        try {
            return CommonResult.success(resourceLoader.getResource("file:" + path + fileName));
        } catch (Exception e) {
            log.error("图片上传失败：" + e);
            return CommonResult.failed("上传失败");
        }
    }
}

