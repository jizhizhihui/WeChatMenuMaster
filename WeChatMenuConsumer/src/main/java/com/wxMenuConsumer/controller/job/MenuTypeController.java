package com.wxMenuConsumer.controller.job;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wxMenuAPI.common.result.CommonResult;
import com.wxMenuAPI.project.entity.MenuType;
import com.wxMenuAPI.project.service.IMenuTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 分类控制器
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@RestController
@RequestMapping("/api/menu-type")
@Api(tags = "分类")
public class MenuTypeController {

    @Reference(version = "1.0.0")
    private IMenuTypeService menuTypeService;

    @GetMapping("get/{id}")
    @ApiOperation("获取分类信息，ID")
    public CommonResult get(@PathVariable int id) {
        return CommonResult.success(menuTypeService.getById(id));
    }

    @GetMapping("gets")
    @ApiOperation("获取所有分类信息")
    public CommonResult gets() {
        return CommonResult.success(menuTypeService.list());
    }

    @GetMapping("getParentChildrenMenu")
    @ApiOperation("获取父菜单和子菜单信息")
    public CommonResult getParentChildrenMenu() {
        return CommonResult.success(menuTypeService.getParentChildrenMenu());
    }

    @PutMapping("update")
    @ApiOperation("更新分类信息")
    public CommonResult update(@RequestBody MenuType menuType) {
        if(menuTypeService.updateById(menuType))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation("删除分类信息")
    public CommonResult delete(@PathVariable int id) {
        if (menuTypeService.removeById(id))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @PostMapping("add")
    @ApiOperation("新增分类信息")
    public CommonResult add(@RequestBody MenuType menuType) {
        if (menuTypeService.getById(menuType.getId()) != null)
            return CommonResult.success(menuTypeService.save(menuType));
        return CommonResult.failed("ID 不存在");
    }
}
