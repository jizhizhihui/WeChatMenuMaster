package com.wxMenuProvider.project.serverImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxMenuAPI.project.entity.DishesType;
import com.wxMenuAPI.project.service.IDishesTypeService;
import com.wxMenuProvider.project.mapper.DishesTypeMapper;
import org.apache.dubbo.config.annotation.Service;

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

}
