package com.wxMenuProvider.project.serverImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxMenuAPI.project.VO.BrowsingNumVO;
import com.wxMenuAPI.project.entity.Browsing;

import com.wxMenuAPI.project.service.IBrowsingService;
import com.wxMenuProvider.project.mapper.BrowsingMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 *  收藏浏览服务实现类
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@Service(version = "1.0.0")
@Log4j2
public class BrowsingServiceImpl extends ServiceImpl<BrowsingMapper, Browsing> implements IBrowsingService {

    @Override
    public BrowsingNumVO getByDishesId(int dishesId) {
        BrowsingNumVO browsingNumVO = new BrowsingNumVO();

        QueryWrapper<Browsing> queryWrapper = new QueryWrapper<Browsing>().eq("dishes_id",dishesId).eq("browsing",1);
        browsingNumVO.setBrowsingNum(integration(getBaseMapper().selectCount(queryWrapper)));
        browsingNumVO.setCollectionNum(integration(getBaseMapper().selectCount(queryWrapper.eq("collection",1))));

        return browsingNumVO;
    }

    @Override
    public BrowsingNumVO getByUserId(int userId) {
        BrowsingNumVO browsingNumVO = new BrowsingNumVO();

        QueryWrapper<Browsing> queryWrapper = new QueryWrapper<Browsing>().eq("user_id",userId).eq("browsing",1);
        browsingNumVO.setBrowsingNum(integration(getBaseMapper().selectCount(queryWrapper)));
        browsingNumVO.setCollectionNum(integration(getBaseMapper().selectCount(queryWrapper.eq("collection",1))));

        return browsingNumVO;
    }

    /**
     * 大数化整
     * @param number 数字
     * @return String  98765 -> 9.88 万
     */
    private String integration(int number){
        String s = "";
        if (number > 100000000) {
            double f =  number / 100000000 + (double)(number % 100000000) / 100000000.0;
            return String.format("%.2f", f) + "亿";
        }
        if (number > 10000) {
           double f =  number / 10000 + (double)(number % 10000) / 10000.0;
           return String.format("%.2f", f) + "万";
        }

        return " ";
    }

}
