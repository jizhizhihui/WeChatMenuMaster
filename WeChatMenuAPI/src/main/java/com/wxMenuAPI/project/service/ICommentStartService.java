package com.wxMenuAPI.project.service;

import com.wxMenuAPI.project.entity.CommentStart;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *  评论点赞服务类
 *
 * @author com.JZhi
 * @since 2020-12-12
 */
public interface ICommentStartService extends IService<CommentStart> {

    int getByCommentId(int commentId);
}
