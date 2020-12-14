package com.wxMenuProvider.project.serverImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxMenuAPI.project.entity.User;
import com.wxMenuAPI.project.service.IUserService;
import com.wxMenuProvider.project.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;


@Log4j2
@Service(version = "1.0.0")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public User getByOpenId(String openId) {
        return getBaseMapper().selectOne(new QueryWrapper<User>().eq("open_id",openId));
    }

    @Override
    public User getUserHeaderAndName(int userId){
        return getBaseMapper().selectOne(new QueryWrapper<User>().eq("user_id",userId).select("username","user_header"));
    }

    @Override
    public List<User> getsByUserIds(List userIds) {
        return null;
    }
}
