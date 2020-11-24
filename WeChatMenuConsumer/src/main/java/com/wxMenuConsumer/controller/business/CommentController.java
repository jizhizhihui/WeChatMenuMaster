package com.wxMenuConsumer.controller.business;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wxMenuAPI.common.result.CommonResult;
import com.wxMenuAPI.project.entity.Browsing;
import com.wxMenuAPI.project.entity.Comment;
import com.wxMenuAPI.project.service.ICommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 *  评论信息控制器
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@RestController
@RequestMapping("/api/comment")
@Api(tags = "评论")
public class CommentController {

    @Reference(version = "1.0.0")
    private ICommentService commentService;

    @GetMapping("get/{id}")
    @ApiOperation("获取评论信息，ID")
    public CommonResult get(@PathVariable int id) {
        return CommonResult.success(commentService.getById(id));
    }

    @GetMapping("gets")
    @ApiOperation("获取所有评论信息")
    public CommonResult gets() {
        return CommonResult.success(commentService.list());
    }

    @PutMapping("update")
    @ApiOperation("更新评论信息")
    public CommonResult update(@RequestBody Comment comment) {
        if(commentService.updateById(comment))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation("删除评论信息")
    public CommonResult delete(@PathVariable int id) {
        if (commentService.removeById(id))
            return CommonResult.success("SUCCESS");
        return CommonResult.failed("FAIL");
    }

    @PostMapping("add")
    @ApiOperation("新增评论信息")
    public CommonResult add(@RequestBody Comment comment) {
        if (commentService.getById(comment.getId()) != null)
            return CommonResult.success(commentService.save(comment));
        return CommonResult.failed("ID 不存在");
    }
}
