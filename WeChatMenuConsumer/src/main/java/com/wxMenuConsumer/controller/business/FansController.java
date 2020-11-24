package com.wxMenuConsumer.controller.business;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wxMenuAPI.common.result.CommonResult;
import com.wxMenuAPI.project.entity.Comment;
import com.wxMenuAPI.project.entity.Fans;
import com.wxMenuAPI.project.service.IFansService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@RestController
@RequestMapping("/api/fans")
@Api(tags = "粉丝")
public class FansController {

    @Reference(version = "1.0.0")
    private IFansService fansService;

    @GetMapping("get/{id}")
    @ApiOperation("获取粉丝信息，ID")
    public CommonResult get(@PathVariable int id) {
        return CommonResult.success(fansService.getById(id));
    }

    @GetMapping("gets")
    @ApiOperation("获取所有粉丝信息")
    public CommonResult gets() {
        return CommonResult.success(fansService.list());
    }

    @PutMapping("update")
    @ApiOperation("更新粉丝信息")
    public CommonResult update(@RequestBody Fans fans) {
        if(fansService.updateById(fans))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation("删除粉丝信息")
    public CommonResult delete(@PathVariable int id) {
        if (fansService.removeById(id))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @PostMapping("add")
    @ApiOperation("新增粉丝信息")
    public CommonResult add(@RequestBody Fans fans) {
        if (fansService.getById(fans.getId()) != null)
            return CommonResult.success(fansService.save(fans));
        return CommonResult.failed("ID 不存在");
    }
}
