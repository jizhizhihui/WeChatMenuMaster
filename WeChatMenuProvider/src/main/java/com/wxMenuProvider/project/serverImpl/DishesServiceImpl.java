package com.wxMenuProvider.project.serverImpl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxMenuAPI.project.entity.Dishes;
import com.wxMenuAPI.project.service.IDishesService;
import com.wxMenuProvider.project.mapper.DishesMapper;
import org.apache.dubbo.config.annotation.Service;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@Service(version = "1.0.0")
public class DishesServiceImpl extends ServiceImpl<DishesMapper, Dishes> implements IDishesService {

    @Override
    public IPage getsByDishesName(String dishesName,int pageNum,int pageSize) {
        return null;
    }

    @Override
    public IPage getsByType(String[] type,int pageNum,int pageSize) {
        return null;
    }

    @Override
    public IPage getsByAuthor(int userId,int pageNum,int pageSize) {

        // 单页记录数，页数
        Page<Dishes> page = new Page<>(pageNum, pageSize);
        return getBaseMapper().selectPage(page, new QueryWrapper<Dishes>().lambda().eq(Dishes::getUserId, userId));
    }

    @Override
    public IPage getsByMaterials(String[] materialsName,int pageNum,int pageSize) {
//        // 不返回总记录数 设置false
//        Page<Dishes> page = new Page<>(pageNum, pageSize, false);
//
//        return getBaseMapper().selectPage(page, new QueryWrapper<Dishes>().lambda().eq(Dishes::getMaterials.getSqlSelect(), userId));;
        return null;
    }
}
