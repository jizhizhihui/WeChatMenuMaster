package com.wxMenuConsumer.controller.business;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxMenuAPI.project.entity.User;
import com.wxMenuAPI.project.service.IUserService;
import com.wxMenuAPI.common.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/user")
@Api(tags = "用户")
public class UserController {

    @Reference(version = "1.0.0")
    private IUserService userServer;


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
        return CommonResult.success(userServer.getById(id));
    }

    @GetMapping("gets")
    @ApiOperation("获取所有菜品分类信息")
    public CommonResult gets() {
        return CommonResult.success(userServer.list());
    }

    @PutMapping("update")
    @ApiOperation("更新菜品分类信息")
    public CommonResult update(@RequestBody User user) {
        if(userServer.updateById(user))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation("删除菜品分类信息")
    public CommonResult delete(@PathVariable int id) {
        if (userServer.removeById(id))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @PostMapping("add")
    @ApiOperation("新增菜品分类信息")
    public CommonResult add(@RequestBody User user) {
        if (userServer.getById(user.getId()) != null)
            return CommonResult.success(userServer.save(user));
        return CommonResult.failed("ID 不存在");
    }
}
