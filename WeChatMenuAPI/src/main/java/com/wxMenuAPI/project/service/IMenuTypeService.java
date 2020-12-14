package com.wxMenuAPI.project.service;

import com.wxMenuAPI.project.VO.MenuTypeVO;
import com.wxMenuAPI.project.entity.MenuType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  分类服务类
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
public interface IMenuTypeService extends IService<MenuType> {

    /**
     * 返回父菜单和子菜单
     * @return List
     */
    List<MenuTypeVO> getParentChildrenMenu();

    /**
     * 通过父菜单获取子菜单
     * @param parentMenu 父菜单
     * @return List
     */
    List getsChildrenMenu(String parentMenu);
}
