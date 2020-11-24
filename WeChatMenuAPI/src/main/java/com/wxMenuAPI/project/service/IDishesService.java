package com.wxMenuAPI.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wxMenuAPI.project.entity.Dishes;

import java.util.List;


/**
 * 菜品服务类
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
public interface IDishesService extends IService<Dishes> {

    /**
     * 通过菜品名模糊获取菜品
     * @param dishesName 菜品名称
     * @return IPage
     */
    IPage getsByDishesName(String dishesName,int pageNum,int pageSize);

    /**
     * 通过菜品分类获取菜品
     * @param type 菜品分类
     * @return IPage
     */
    IPage getsByType(String[] type, int pageNum, int pageSize);

    /**
     * 通过作者分类获取菜品
     * @param userId 作者
     * @return IPage
     */
    IPage getsByAuthor(int userId,int pageNum,int pageSize);

    /**
     * 通过用料分类获取菜品
     * @param materialsName 用料
     * @return IPage
     */
    IPage getsByMaterials(String[] materialsName,int pageNum,int pageSize);
}
