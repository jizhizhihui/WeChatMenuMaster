package com.wxMenu.controller;

import com.wxMenu.result.CommonResult;
import com.wxMenu.utils.FileUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Log4j2
public class FileController {
    @Autowired
    private ResourceLoader resourceLoader;

    @Value("task.file.image-path")
    private String path;

    /**
     * @param file 文件
     * @return
     */
    @RequestMapping("image-upload")
    public CommonResult upload(@RequestParam("fileName") MultipartFile file) {

        if (FileUtils.uploadImage(file)) {
            // 上传成功，给出页面提示
            return CommonResult.success("上传成功");
        } else {
            return CommonResult.success("上传失败");
        }
    }

    /**
     * @param fileName 文件名
     * @return
     */
    @RequestMapping("image-show")
    public CommonResult show(String fileName) {
        try {
            return CommonResult.success(resourceLoader.getResource("file:" + path + fileName));
        } catch (Exception e) {
            log.error("图片上传失败：" + e);
            return CommonResult.failed("上传失败");
        }
    }
}

