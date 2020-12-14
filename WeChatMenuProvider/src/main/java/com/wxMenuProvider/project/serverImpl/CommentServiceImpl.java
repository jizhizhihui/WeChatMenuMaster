package com.wxMenuProvider.project.serverImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxMenuAPI.project.VO.CommentVO;
import com.wxMenuAPI.project.VO.DishesCardsVO;
import com.wxMenuAPI.project.entity.Comment;
import com.wxMenuAPI.project.entity.Dishes;
import com.wxMenuAPI.project.entity.User;
import com.wxMenuAPI.project.service.ICommentStartService;
import com.wxMenuAPI.project.service.IUserService;
import com.wxMenuProvider.project.mapper.CommentMapper;
import com.wxMenuAPI.project.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  评论服务实现类
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@Service(version = "1.0.0")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Reference(version = "1.0.0")
    private IUserService userService;
    @Reference(version = "1.0.0")
    private ICommentStartService startService;

    @Override
    public IPage<Comment> getComment(int dishesId,int pageNum, int pageSize){
        Page<Comment> page = new Page<>(pageNum, pageSize);
        return getBaseMapper().selectPage(page, new QueryWrapper<Comment>().eq("dishes_id",dishesId));
    }

    @Override
    public IPage getCommentVO(int dishesId,int pageNum, int pageSize){
        Page<CommentVO> commentVOPage = new Page<>();
        IPage<Comment> commentIPage = getComment(dishesId,pageNum,pageSize);

        if (commentIPage != null) {
            commentVOPage.setTotal(commentIPage.getTotal());
            commentVOPage.setRecords(new ArrayList<>());

            commentIPage.getRecords().forEach(comment -> {
                User user = userService.getUserHeaderAndName(comment.getUserId());
                CommentVO  commentVO= new CommentVO(comment,user);
                commentVO.setStart(startService.getByCommentId(comment.getId()));
                commentVO.setChildren(getChildren(comment.getId()));
                commentVOPage.getRecords().add(commentVO);
            });
        }
        return commentVOPage;
    }

    /**
     * 将评论写入评论VO
     * @param comment 评论
     * @return CommentVO
     */
    private CommentVO setCommentVo(Comment comment){
        User user = userService.getUserHeaderAndName(comment.getUserId());
        CommentVO  commentVO= new CommentVO(comment,user);
        commentVO.setStart(startService.getByCommentId(comment.getId()));
        return  commentVO;
    }

    /**
     * 获取评论的子评论
     * @param commentId 评论ID
     * @return List<CommentVO>
     */
    private List<CommentVO> getChildren(int commentId){
        List<CommentVO> commentVOS = new ArrayList<>();
        List<Comment> comments = getBaseMapper().selectList(new QueryWrapper<Comment>().eq("parent_id",commentId));
        comments.forEach(comment -> {
            commentVOS.add(setCommentVo(comment));
        });
        return commentVOS;
    }
}
