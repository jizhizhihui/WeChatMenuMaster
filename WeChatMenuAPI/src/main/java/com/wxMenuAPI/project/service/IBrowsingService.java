package com.wxMenuAPI.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxMenuAPI.project.VO.BrowsingNumVO;
import com.wxMenuAPI.project.entity.Browsing;

/**
 * 浏览收藏数据服务
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
public interface IBrowsingService extends IService<Browsing> {

    /**
     * 通过菜品id获取浏览数和收藏数
     * @param dishesId 菜品id
     * @return BrowsingNumVO
     */
    BrowsingNumVO getBrowsingById(int dishesId);

    /**
     * 通过用户id获取浏览数和收藏数
     * @param userId 用户id
     * @return BrowsingNumVO
     */
    BrowsingNumVO getBrowsingByUserId(int userId);
}
