package com.wxMenuConsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxMenuAPI.common.result.CommonResult;
import com.wxMenuAPI.project.service.IWxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@Api(tags = "微信服务")
@RequestMapping("/api")
public class WeChatController {

    @Reference(version = "1.0.0")
    private IWxService wxService;

    @GetMapping("wxLogin/{code}")
    @ApiOperation("微信登录")
    public CommonResult wxLogin(@PathVariable("code") String code){
        String keys = wxService.wxLogin(code);
        if (StringUtils.isEmpty(keys))
            return CommonResult.failed();
        return CommonResult.success(keys);
    }
}
