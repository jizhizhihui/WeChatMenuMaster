package com.wxMenuConsumer.controller.job;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxMenuAPI.common.result.CommonResult;
import com.wxMenuAPI.project.entity.Browsing;
import com.wxMenuAPI.project.service.IBrowsingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 浏览收藏信息控制器
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@RestController
@RequestMapping("/api/browsing")
@Api(tags = "浏览收藏")
public class BrowsingController {

    @Reference(version = "1.0.0")
    private IBrowsingService browsingService;

    @GetMapping("get/{id}")
    @ApiOperation("获取浏览信息，ID")
    public CommonResult get(@PathVariable int id) {
        return CommonResult.success(browsingService.getById(id));
    }

    @GetMapping("gets")
    @ApiOperation("获取所有浏览信息")
    public CommonResult gets() {
        return CommonResult.success(browsingService.list());
    }

    @PutMapping("update")
    @ApiOperation("更新浏览信息")
    public CommonResult update(@RequestBody Browsing browsing) {
        if(browsingService.updateById(browsing))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation("删除浏览信息")
    public CommonResult delete(@PathVariable int id) {
        if (browsingService.removeById(id))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @PostMapping("add")
    @ApiOperation("新增浏览信息")
    public CommonResult add(@RequestBody Browsing browsing) {
        if (browsingService.getById(browsing.getId()) != null)
            return CommonResult.success(browsingService.save(browsing));
        return CommonResult.failed("ID 不存在");
    }

    @GetMapping("getByDishesId/{dishesId}")
    @ApiOperation("通过菜品id获取菜品收藏浏览信息")
    public CommonResult getByDishesId(@PathVariable("dishesId") int dishesId) {
        return CommonResult.success(browsingService.getByDishesId(dishesId));
    }

    @GetMapping("getByUserId/{userId}")
    @ApiOperation("通过用户Id获取用户的菜品收藏浏览信息")
    public CommonResult getByUserId(@PathVariable("userId") int userId) {
        return CommonResult.success(browsingService.getByUserId(userId));
    }

}
