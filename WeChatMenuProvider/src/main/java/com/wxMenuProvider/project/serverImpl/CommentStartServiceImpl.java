package com.wxMenuProvider.project.serverImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wxMenuAPI.project.entity.Comment;
import com.wxMenuAPI.project.entity.CommentStart;
import com.wxMenuAPI.project.service.ICommentStartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxMenuProvider.project.mapper.CommentStartMapper;
import org.apache.dubbo.config.annotation.Service;

/**
 *  评论点赞服务实现类
 *
 * @author com.JZhi
 * @since 2020-12-12
 */
@Service(version = "1.0.0")
public class CommentStartServiceImpl extends ServiceImpl<CommentStartMapper, CommentStart> implements ICommentStartService {

    @Override
    public int getByCommentId(int commentId){
        return getBaseMapper().selectCount(new QueryWrapper<CommentStart>().eq("comment_id",commentId));
    }
}
