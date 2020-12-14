package com.wxMenuAPI.project.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    /**
     * 更换头像
     * @param userId 用户id
     * @param file 图片文件
     * @return boolean
     */
    boolean upLoadHeader(int userId, MultipartFile file);

    /**
     * 上传图片
     * @param file 图片
     * @return boolean
     */
    boolean uploadImage(MultipartFile file, String path);
}
