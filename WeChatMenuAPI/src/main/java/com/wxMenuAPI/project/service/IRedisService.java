package com.wxMenuAPI.project.service;

import redis.clients.jedis.Jedis;

/**
 * REDIS 服务
 */
public interface IRedisService {

    void wxLogin(String openId,String sessionKey);

    boolean updateWxSessionExpire(String openId);

    Jedis getJedis();
}
