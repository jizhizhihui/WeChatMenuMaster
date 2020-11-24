package com.wxMenuAPI.project.service;

import com.wxMenuAPI.project.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 *  用户服务类
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
public interface IUserService extends IService<User> {

    /**
     * 微信登录
     * @param code 微信code
     * @return boolean
     */
    boolean wxLogin(String code);

    /**
     * 更换头像
     * @param userId 用户id
     * @param file 图片文件
     * @return boolean
     */
    boolean upLoadHeader(int userId, MultipartFile file);

    /**
     * 通过用户id集获取用户信息
     * @param userIds 用户id集合
     * @return List<User>
     */
    List<User> getsByUserIds(List userIds);
}
