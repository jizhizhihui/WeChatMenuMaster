package com.wxMenuProvider.project.serverImpl;

import com.wxMenuAPI.project.entity.Comment;
import com.wxMenuProvider.project.mapper.CommentMapper;
import com.wxMenuAPI.project.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@Service(version = "1.0.0")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
