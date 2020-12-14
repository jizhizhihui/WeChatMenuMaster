package com.wxMenuProvider.project.serverImpl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wxMenuAPI.project.service.IWxService;
import com.wxMenuProvider.project.mode.WeChatRequst;
import com.wxMenuProvider.utils.HttpClientUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

@Service(version = "1.0.0")
@Log4j2
public class WxServiceImpl implements IWxService {

    @Autowired
    private WeChatRequst weChatRequst;
    @Autowired
    private RedisServiceImpl redisService;

    @Override
    public String wxLogin(String code){

        //发送post请求读取调用微信接口获取openid用户唯一标识
        String requestUrl = weChatRequst.getUrl() +
                "?appid=" + weChatRequst.getAppid() +
                "&secret=" + weChatRequst.getSecret() +
                "&js_code=" + code +
                "&grant_type=" + weChatRequst.getGrantType();
        JSONObject wxObject = JSON.parseObject(HttpClientUtils.doGet(requestUrl));
        // 获取参数返回的
        log.info("jsonObject:"+wxObject);
        String sessionKey = wxObject.get("session_key").toString();
        String openId = wxObject.get("openid").toString();

        if (StringUtils.isEmpty(sessionKey) || StringUtils.isEmpty(openId)) {
            log.debug("微信请求失败" + wxObject);
        }
        redisService.wxLogin(openId,sessionKey);
        return openId;
    }
}
