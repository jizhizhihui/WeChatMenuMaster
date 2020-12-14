package com.wxMenuProvider.project.serverImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxMenuAPI.project.entity.Dishes;
import com.wxMenuAPI.project.entity.DishesType;
import com.wxMenuAPI.project.service.IDishesTypeService;
import com.wxMenuProvider.project.mapper.DishesTypeMapper;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author com.JZhi
 * @since 2020-11-25
 */
@Service(version = "1.0.0")
public class DishesTypeServiceImpl extends ServiceImpl<DishesTypeMapper, DishesType> implements IDishesTypeService {

    @Override
    public List<Integer> getTypeDishId(int typeId) {
        List<DishesType> dishesTypeList = getBaseMapper().selectList(new QueryWrapper<DishesType>().lambda().eq(DishesType::getMenuTypeId,typeId).select(DishesType::getDishesId));
        List<Integer> typeIds = new ArrayList<>();
        dishesTypeList.forEach(d-> typeIds.add(d.getDishesId()));
        return typeIds;
    }

    @Override
    public List<Integer> getTypeDishId(String... type) {
        return null;
    }
}
