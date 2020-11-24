package com.wxMenuConsumer.controller.business;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wxMenuAPI.common.result.CommonResult;
import com.wxMenuAPI.project.entity.Fans;
import com.wxMenuAPI.project.entity.MenuType;
import com.wxMenuAPI.project.service.IMenuTypeService;
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
@RequestMapping("/api/menu-type")
@Api(tags = "菜品分类")
public class MenuTypeController {

    @Reference(version = "1.0.0")
    private IMenuTypeService menuTypeService;

    @GetMapping("get/{id}")
    @ApiOperation("获取菜品分类信息，ID")
    public CommonResult get(@PathVariable int id) {
        return CommonResult.success(menuTypeService.getById(id));
    }

    @GetMapping("gets")
    @ApiOperation("获取所有菜品分类信息")
    public CommonResult gets() {
        return CommonResult.success(menuTypeService.list());
    }

    @PutMapping("update")
    @ApiOperation("更新菜品分类信息")
    public CommonResult update(@RequestBody MenuType menuType) {
        if(menuTypeService.updateById(menuType))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation("删除菜品分类信息")
    public CommonResult delete(@PathVariable int id) {
        if (menuTypeService.removeById(id))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @PostMapping("add")
    @ApiOperation("新增菜品分类信息")
    public CommonResult add(@RequestBody MenuType menuType) {
        if (menuTypeService.getById(menuType.getId()) != null)
            return CommonResult.success(menuTypeService.save(menuType));
        return CommonResult.failed("ID 不存在");
    }
}
