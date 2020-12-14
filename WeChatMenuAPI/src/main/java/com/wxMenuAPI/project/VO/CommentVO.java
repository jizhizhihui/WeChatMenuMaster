package com.wxMenuAPI.project.VO;

import com.wxMenuAPI.project.entity.Comment;
import com.wxMenuAPI.project.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class CommentVO implements Serializable {
    private LocalDate commentTime;
    private int start;
    private String userHeader;
    private String username;
    private String content;
    private List<CommentVO> children;

    public CommentVO(Comment comment, User user){
        this.commentTime = comment.getCommentTime().toLocalDate();
        this.content = comment.getContent();
        this.userHeader = user.getUserHeader();
        this.username =  user.getUsername();
    }
}
