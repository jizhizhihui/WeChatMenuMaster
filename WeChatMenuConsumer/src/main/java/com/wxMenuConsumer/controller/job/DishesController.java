package com.wxMenuConsumer.controller.job;


import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wxMenuAPI.common.result.CommonResult;
import com.wxMenuAPI.project.entity.Dishes;
import com.wxMenuAPI.project.service.IDishesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@RestController
@RequestMapping("/api/dishes")
@Api(tags = "菜品")
public class DishesController {

    @Reference(version = "1.0.0")
    private IDishesService dishesService;


    @GetMapping("get/{id}")
    @ApiOperation("获取菜品信息，ID")
    public CommonResult get(@PathVariable int id) {
        return CommonResult.success(dishesService.getById(id));
    }

    @GetMapping("gets")
    @ApiOperation("获取所有菜品信息")
    public CommonResult gets(@RequestParam int pageNum,int pageSize) {
        return CommonResult.success(dishesService.listPage(pageNum,pageSize));
    }

    @PutMapping("update")
    @ApiOperation("更新菜品信息")
    public CommonResult update(@RequestBody Dishes dishes) {
        if(dishesService.updateById(dishes))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation("删除菜品信息")
    public CommonResult delete(@PathVariable int id) {
        if (dishesService.removeById(id))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @PostMapping("add")
    @ApiOperation("新增菜品信息")
    public CommonResult add(@RequestBody Dishes dishes) {
        if (dishesService.getById(dishes.getId()) == null)
            return CommonResult.success(dishesService.save(dishes));
        return CommonResult.failed("ID 已存在");
    }

    @GetMapping("getsByAuthor")
    @ApiOperation("通过作者分类获取菜品")
    public CommonResult getsByAuthor(@RequestParam int authorId, int pageNum, int pageSize) {
        return CommonResult.success(dishesService.getsByAuthor(authorId, pageNum, pageSize));
    }


    @GetMapping("getCards")
    @ApiOperation("通过分类Id获取菜品")
    public CommonResult getDishesCards(int pageNum, int pageSize) {
        return CommonResult.success(dishesService.getDishesCards(null, pageNum, pageSize));
    }

    @GetMapping("getDishesByOpenId")
    @ApiOperation("通过用户的OpenId获取菜品")
    public CommonResult getDishesByOpenId(@RequestParam String openId, int pageNum, int pageSize) {
        return CommonResult.success(dishesService.getDishesByOpenId(openId, pageNum, pageSize));
    }
}
