package com.wxMenuProvider.project.serverImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxMenuAPI.project.entity.MenuType;

import com.wxMenuAPI.project.service.IMenuTypeService;
import com.wxMenuProvider.project.mapper.MenuTypeMapper;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@Service(version = "1.0.0")
public class MenuTypeServiceImpl extends ServiceImpl<MenuTypeMapper, MenuType> implements IMenuTypeService {

    @Override
    public List getsChildrenMenu(String parentMenu) {
        return null;
    }
}
