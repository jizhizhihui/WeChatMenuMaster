package com.wxMenuConsumer.controller.job;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.wxMenuAPI.project.entity.User;
import com.wxMenuAPI.project.service.IRedisService;
import com.wxMenuAPI.project.service.IUserService;
import com.wxMenuAPI.common.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/user")
@Api(tags = "用户")
@Log4j2
public class UserController {

    @Reference(version = "1.0.0")
    private IUserService userServer;

    @Reference
    private IRedisService redisService;

//    @GetMapping("wxAddUser")
//    @ApiOperation("微信登录")
//    public CommonResult wxLogin(
//                                @RequestParam("userHead") String userHead,
//                                @RequestParam("userName") String userName,
//                                @RequestParam("userGender") String userGender,
//                                @RequestParam("userCity") String userCity,
//                                @RequestParam("userProvince") String userProvince) {
//        // 根据返回的user实体类，判断用户是否是新用户，不是的话，更新最新登录时间，是的话，将用户信息存到数据库
//        User user = userServer.getByOpenId(open_id);
//        if (user != null) {
//            user.setLoginTime(LocalDateTime.now());
//            userServer.updateById(user);
//        } else {
//            User newUser = new User();
//            newUser.setUserHeader(userHead);
//            newUser.setUsername(userName);
//            newUser.setUserGender(userGender);
//            newUser.setLoginTime(LocalDateTime.now());
//            newUser.setCity(userCity);
//            newUser.setProvince(userProvince);
//            newUser.setOpenid(open_id);
//            log.info("newUser:" + newUser.toString());
//            // 添加数据
//            if (!userServer.save(newUser)) {
//                return CommonResult.failed("ADD FAIL");
//            }
//        }
//        return CommonResult.success("ADD SUCCES");
//
//    }

    @GetMapping("get/{id}")
    @ApiOperation("获取用户信息，ID")
    public CommonResult getUser(@PathVariable long id) {
        return CommonResult.success(userServer.getById(id));
    }

    @GetMapping("gets")
    @ApiOperation("获取所有用户信息")
    public CommonResult gets() {
        return CommonResult.success(userServer.list());
    }

    @PutMapping("update")
    @ApiOperation("更新用户信息")
    public CommonResult update(@RequestBody User user) {
        if (userServer.updateById(user))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation("删除用户信息")
    public CommonResult delete(@PathVariable int id) {
        if (userServer.removeById(id))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @PostMapping("add")
    @ApiOperation("新增用户信息")
    public CommonResult add(@RequestBody User user) {
        if (userServer.getById(user.getId()) != null)
            return CommonResult.success(userServer.save(user));
        return CommonResult.failed("ID 不存在");
    }
}
