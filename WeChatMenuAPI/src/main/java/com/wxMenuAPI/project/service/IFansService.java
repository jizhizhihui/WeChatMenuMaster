package com.wxMenuAPI.project.service;

import com.wxMenuAPI.project.entity.Fans;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  粉丝服务类
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
public interface IFansService extends IService<Fans> {

    /**
     * 通过用户id查询用户粉丝数
     * @param userId 用户id
     * @return int
     */
    int getFansNum(int userId);

    /**
     * 通过用户id查询用户关注人数
     * @param userId 用户id
     * @return int
     */
    int getFollowNum(int userId);

    /**
     * 通过用户id获取用户粉丝id
     * @param userId 用户id
     * @return List
     */
    List getsFans(int userId);

    /**
     * 通过用户id获取用户关注id
     * @param userId 用户id
     * @return List
     */
    List getsFollow(int userId);
}
