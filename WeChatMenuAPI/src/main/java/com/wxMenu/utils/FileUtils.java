package com.wxMenu.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Log4j2
public class FileUtils {

    @Value("task.file.image-path")
    private static String path;

    //支持的图片类型
    private static final List<String> CONTENT_TYPE = Arrays.asList("image/gif", "image/jpeg", "image/png");

    public static boolean uploadImage(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();

        //建议文件类型
        if (!CONTENT_TYPE.contains(file.getContentType())) {
            log.info("文件类型不合法:{}", originalFilename);
        }

        //使用原文件名
        String realPath = path + "/" + originalFilename;
        File dest = new File(realPath);
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists())
            dest.getParentFile().mkdir();

        try {
            //检验文件内容
            BufferedImage read = ImageIO.read(file.getInputStream());
            if (read == null) {
                log.info("文件内容不合法:{}", originalFilename);
            }
            //保存文件
            file.transferTo(dest);
            return true;
        } catch (IOException e) {
            log.error("服务器内部错误->:{}", originalFilename);
            e.printStackTrace();
        }
        return false;
    }
}
