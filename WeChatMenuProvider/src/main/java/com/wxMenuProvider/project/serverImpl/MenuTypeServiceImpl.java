package com.wxMenuProvider.project.serverImpl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxMenuAPI.project.VO.MenuTypeVO;
import com.wxMenuAPI.project.entity.MenuType;

import com.wxMenuAPI.project.service.IMenuTypeService;
import com.wxMenuProvider.project.mapper.MenuTypeMapper;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@Service(version = "1.0.0")
public class MenuTypeServiceImpl extends ServiceImpl<MenuTypeMapper, MenuType> implements IMenuTypeService {

    @Override
    public List<MenuTypeVO> getParentChildrenMenu() {
        List<MenuTypeVO> menuTypeVOS = new ArrayList<>();
        List<MenuType> parent = getBaseMapper().selectList(new QueryWrapper<MenuType>().eq("parent", 0));
        parent.forEach(m -> {
            MenuTypeVO menuTypeVO = new MenuTypeVO();
            menuTypeVO.setParent(m);
            menuTypeVO.setChildren(getBaseMapper().selectList(new QueryWrapper<MenuType>().eq("parent", m.getId())));
            menuTypeVOS.add(menuTypeVO);
        });
        return menuTypeVOS;
    }

    @Override
    public List getsChildrenMenu(String parentMenu) {
        return null;
    }
}
