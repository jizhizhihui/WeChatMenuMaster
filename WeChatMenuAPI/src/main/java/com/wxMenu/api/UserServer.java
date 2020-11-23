package com.wxMenu.api;

import com.wxMenu.model.WXSessionModel;

public interface UserServer {

    boolean wxLogin(String code);

    String getUser(Long id);
}
