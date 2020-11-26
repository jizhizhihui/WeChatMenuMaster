package com.wxMenuProvider.project.serverImpl;

import com.wxMenuAPI.project.entity.Fans;
import com.wxMenuProvider.project.mapper.FansMapper;
import com.wxMenuAPI.project.service.IFansService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class FansServiceImpl extends ServiceImpl<FansMapper, Fans> implements IFansService {

    @Override
    public int getFansNum(int userId) {
        return 0;
    }

    @Override
    public int getAttentionNum(int userId) {
        return 0;
    }

    @Override
    public List getsFans(int userId) {
        return null;
    }

    @Override
    public List getsAttention(int userId) {
        return null;
    }
}
