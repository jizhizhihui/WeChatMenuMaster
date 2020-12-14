package com.wxMenuProvider.project.serverImpl;

import com.wxMenuAPI.project.service.IRedisService;
import com.wxMenuProvider.utils.RedisUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import redis.clients.jedis.Jedis;

@Service(version = "1.0.0")
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private RedisUtils redisUtils;
    @Value("${task.wx.loginExpire}")
    private int sessionExpire;

    @Override
    public void wxLogin(String openId, String sessionKey) {
        //MD5加密
//        String keys = DigestUtils.md5DigestAsHex((openId + sessionKey).getBytes());
        redisUtils.set(openId, sessionKey, 1);
        redisUtils.expire(openId, sessionExpire, 1);
    }

//    public void checkWXSession(String keys){
//
//    }

    public boolean updateWxSessionExpire(String openId) {
        if (redisUtils.exists(openId)) {
            redisUtils.expire(openId,sessionExpire,1);
            return true;
        }
        return false;
    }

    @Override
    public Jedis getJedis() {
        return redisUtils.getJedis();
    }
}
