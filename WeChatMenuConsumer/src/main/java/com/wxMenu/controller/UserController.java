package com.wxMenu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxMenu.api.UserServer;
import com.wxMenu.common.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/user")
@Api(tags = "用户")
public class UserController {

    @Reference(version = "1.0.0")
    private UserServer userServer;


    @GetMapping("wxLogin/{code}")
    @ApiOperation("微信登录")
    public CommonResult wxLogin(@PathVariable @NotBlank String code){
        if (userServer.wxLogin(code))
            return CommonResult.success("ok");
        return CommonResult.failed("Login fail");
    }

    @GetMapping("get/{id}")
    @ApiOperation("获取用户信息，ID")
    public CommonResult getUser(@PathVariable long id){
        return CommonResult.success(userServer.getUser(id));
    }
}
