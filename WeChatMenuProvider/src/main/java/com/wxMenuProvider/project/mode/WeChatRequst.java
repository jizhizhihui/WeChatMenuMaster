package com.wxMenuProvider.project.mode;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class WeChatRequst {

    @Value("${task.wx.url}")
    private String url;
    @Value("${task.wx.secret}")
    private String secret;
    @Value("${task.wx.appid}")
    private String appid;
    @Value("${task.wx.grantType}")
    private String grantType;
}
