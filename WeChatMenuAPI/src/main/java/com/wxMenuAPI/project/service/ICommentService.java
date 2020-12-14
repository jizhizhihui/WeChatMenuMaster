package com.wxMenuAPI.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wxMenuAPI.project.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 评论服务类
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
public interface ICommentService extends IService<Comment> {

    /**
     * 获取分页评论
     * @param pageNum 页数
     * @param pageSize 条数
     * @return IPage<Comment>
     */
    IPage<Comment> getComment(int dishesId,int pageNum, int pageSize);

    /**
     * 获取分页评论模型
     * @param pageNum 页数
     * @param pageSize 条数
     * @return IPage<CommentVO>
     */
    IPage getCommentVO(int dishesId,int pageNum, int pageSize);
}
