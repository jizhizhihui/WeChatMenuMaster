package com.wxMenuConsumer.controller.business;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wxMenuAPI.common.result.CommonResult;
import com.wxMenuAPI.project.entity.Dishes;
import com.wxMenuAPI.project.entity.DishesType;
import com.wxMenuAPI.project.service.IDishesService;
import com.wxMenuAPI.project.service.IDishesTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 菜品分类控制器
 *
 * @author com.JZhi
 * @since 2020-11-25
 */
@RestController
@RequestMapping("/api/dishes-type")
@Api(tags = "菜品分类")
public class DishesTypeController {

    @Reference(version = "1.0.0")
    private IDishesTypeService dishesTypeService;


    @GetMapping("get/{id}")
    @ApiOperation("获取菜品分类信息，ID")
    public CommonResult get(@PathVariable int id) {
        return CommonResult.success(dishesTypeService.getById(id));
    }

    @GetMapping("gets")
    @ApiOperation("获取所有菜品分类信息")
    public CommonResult gets() {
        return CommonResult.success(dishesTypeService.list());
    }

    @PutMapping("update")
    @ApiOperation("更新菜品分类信息")
    public CommonResult update(@RequestBody DishesType dishesType) {
        if(dishesTypeService.updateById(dishesType))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation("删除菜品分类信息")
    public CommonResult delete(@PathVariable int id) {
        if (dishesTypeService.removeById(id))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @PostMapping("add")
    @ApiOperation("新增菜品分类信息")
    public CommonResult add(@RequestBody DishesType dishesType) {
        if (dishesTypeService.getById(dishesType.getId()) == null)
            return CommonResult.success(dishesTypeService.save(dishesType));
        return CommonResult.failed("ID 已存在");
    }
}
