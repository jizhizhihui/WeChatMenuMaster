package com.wxMenu.server;

import com.wxMenu.api.UserServer;
import com.wxMenu.model.WXSessionModel;
import com.wxMenu.utils.FileUtils;
import com.wxMenu.utils.HttpClientUtils;
import com.wxMenu.utils.JsonUtils;
import com.wxMenu.utils.RedisUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Service(version = "1.0.0")
public class userServiceImpl implements UserServer {

    @Autowired
    private RedisUtils redis;

    @Override
    public boolean wxLogin(String code) {
        if (code.equals(""))
            return false;
        try {
            String url = "https://api.weixin.qq.com/sns/jscode2session";
            Map<String, String> param = new HashMap<>();
            param.put("appid", "wxa2049f5aead89372");
            param.put("secret", "3a62d9b55028c644bacdd8412fada021");
            param.put("js_code", code);
            param.put("grant_type", "authorization_code");

            String wxResult = HttpClientUtils.doGet(url, param);
            System.out.println(wxResult);

            WXSessionModel model = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);

            // 存入session到redis
            assert model != null;
            redis.set("user-redis-session:" + model.getOpenid(),
                    model.getSession_key(),
                    1000 * 60 * 30);
        }catch (Exception e){
            log.debug("LOGIN EXCEPTION : " + e);
            return false;
        }
        return true;
    }

    @Override
    public String getUser(Long id) {
        return "hello " + id;
    }

//    @Override
    public boolean upLoadHeader(int userId,MultipartFile file){
        try{
            //保存图片
            FileUtils.uploadImage(file);
            //保存头像路径
            return true;
        } catch (Exception e){
            log.error("头像存储失败：" + e);
        }
        return false;
    }
}
