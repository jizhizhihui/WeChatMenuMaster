package com.wxMenuProvider.project.serverImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxMenuAPI.project.VO.BrowsingNumVO;
import com.wxMenuAPI.project.entity.Browsing;

import com.wxMenuAPI.project.service.IBrowsingService;
import com.wxMenuProvider.project.mapper.BrowsingMapper;
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
public class BrowsingServiceImpl extends ServiceImpl<BrowsingMapper, Browsing> implements IBrowsingService {

    @Override
    public BrowsingNumVO getBrowsingById(int dishesId) {
        BrowsingNumVO browsingNumVO = new BrowsingNumVO();

        QueryWrapper<Browsing> queryWrapper = new QueryWrapper<Browsing>().eq("dishes_id",dishesId).eq("browsing",1);
        browsingNumVO.setBrowsingNum(getBaseMapper().selectCount(queryWrapper));
        browsingNumVO.setCollectionNum(getBaseMapper().selectCount(queryWrapper.eq("collection",1)));

        return browsingNumVO;
    }

    @Override
    public BrowsingNumVO getBrowsingByUserId(int userId) {
        BrowsingNumVO browsingNumVO = new BrowsingNumVO();

        QueryWrapper<Browsing> queryWrapper = new QueryWrapper<Browsing>().eq("user_id",userId).eq("browsing",1);
        browsingNumVO.setBrowsingNum(getBaseMapper().selectCount(queryWrapper));
        browsingNumVO.setCollectionNum(getBaseMapper().selectCount(queryWrapper.eq("collection",1)));

        return browsingNumVO;
    }
}
