package com.wxMenuAPI.project.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wxMenuAPI.project.entity.DishesType;

import java.util.List;

/**
 *  菜品分类服务类
 *
 * @author com.JZhi
 * @since 2020-11-25
 */
public interface IDishesTypeService extends IService<DishesType> {

    List<Integer> getTypeDishId(int typeId);
    List<Integer> getTypeDishId(String... type);
}
