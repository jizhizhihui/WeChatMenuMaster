package com.wxMenuProvider.project.serverImpl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxMenuAPI.project.VO.DishesCardsVO;
import com.wxMenuAPI.project.entity.Dishes;
import com.wxMenuAPI.project.entity.User;
import com.wxMenuAPI.project.service.IBrowsingService;
import com.wxMenuAPI.project.service.IDishesService;
import com.wxMenuAPI.project.service.IDishesTypeService;
import com.wxMenuAPI.project.service.IUserService;
import com.wxMenuProvider.project.mapper.DishesMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@Service(version = "1.0.0")
public class DishesServiceImpl extends ServiceImpl<DishesMapper, Dishes> implements IDishesService {

    @Reference(version = "1.0.0")
    private IUserService userService;
    @Reference(version = "1.0.0")
    private IDishesTypeService dishesTypeService;
    @Reference(version = "1.0.0")
    private IBrowsingService browsingService;

    @Override
    public IPage listPage(int pageNum, int pageSize) {
        Page<Dishes> page = new Page<>(pageNum, pageSize);
        return getBaseMapper().selectPage(page, new QueryWrapper<Dishes>());
    }

    @Override
    public IPage getsByDishesName(String dishesName, int pageNum, int pageSize) {

        IPage<Dishes> dishesIPage;
        Page<Dishes> page = new Page<>(pageNum, pageSize);
        if (dishesName != null)
            dishesIPage = getBaseMapper().selectPage(page, new QueryWrapper<Dishes>().like("dishesName",dishesName));
        else
            dishesIPage = getBaseMapper().selectPage(page, new QueryWrapper<>());
        return dishesIPage;
    }

    @Override
    public IPage<Dishes> getsByType(Integer typeId, int pageNum, int pageSize) {
        Page<Dishes> page = new Page<>(pageNum, pageSize);
        if (typeId != null)
            return getBaseMapper().selectPage(page, new QueryWrapper<Dishes>().in("id", dishesTypeService.getTypeDishId(typeId)));
        else
            return  getBaseMapper().selectPage(page, new QueryWrapper<>());
    }

    @Override
    public IPage getsByAuthor(int userId, int pageNum, int pageSize) {
        // 单页记录数，页数
        Page<Dishes> page = new Page<>(pageNum, pageSize);
        return getBaseMapper().selectPage(page, new QueryWrapper<Dishes>().lambda().eq(Dishes::getUserId, userId));
    }

    @Override
    public IPage getsByMaterials(String[] materialsName, int pageNum, int pageSize) {
//        // 不返回总记录数 设置false
//        Page<Dishes> page = new Page<>(pageNum, pageSize, false);
//
//        return getBaseMapper().selectPage(page, new QueryWrapper<Dishes>().lambda().eq(Dishes::getMaterials.getSqlSelect(), userId));;
        return null;
    }

    @Override
    public IPage getDishesCards(Integer typeId, int pageNum, int pageSize) {
        Page<DishesCardsVO> cardsVOIPage = new Page<>();
        IPage<Dishes> dishesIPage = getsByType(typeId,pageNum,pageSize);

        if (dishesIPage != null) {
            cardsVOIPage.setTotal(dishesIPage.getTotal());
            cardsVOIPage.setRecords(new ArrayList<>());

            dishesIPage.getRecords().forEach(d -> {
                DishesCardsVO  cardsVO= new DishesCardsVO(d);
                cardsVOIPage.getRecords().add(cardsVO);
            });
        }
        return cardsVOIPage;
    }

    @Override
    public IPage getDishesByOpenId(String openId, int pageNum, int pageSize) {
        User user = userService.getByOpenId(openId);
        Page<Dishes> page = new Page<>(pageNum, pageSize);
        return getBaseMapper().selectPage(page, new QueryWrapper<Dishes>().eq("user_id", user.getId()));
    }

}
