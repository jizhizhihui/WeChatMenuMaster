package com.wxMenuProvider.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Log4j2
public class FileUtils {

    //支持的图片类型
    private static final List<String> CONTENT_TYPE = Arrays.asList("images/gif", "images/jpeg", "images/png");

    /**
     * 上传图片
     * @param file 图片
     * @param path 路径
     * @return boolean
     */
    public static boolean uploadImage(MultipartFile file,String path) {

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

    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getFileSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }


    /**
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileName(String fileOriginName){
        return getUUID() + getFileSuffix(fileOriginName);
    }

    /**
     * 生成文件名
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
