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
     * @param open_id 微信open_id
     * @return boolean
     */
    User getByOpenId(String open_id);

    /**
     * 获取用户名与头像
     * @param userId 用户id
     * @return User
     */
    User getUserHeaderAndName(int userId);

    /**
     * 通过用户id集获取用户信息
     * @param userIds 用户id集合
     * @return List<User>
     */
    List<User> getsByUserIds(List userIds);
}
