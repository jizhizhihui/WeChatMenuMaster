package com.wxMenuAPI.project.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author com.JZhi
 * @since 2020-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_comment_start")
@ApiModel(value="CommentStart对象", description="")
public class CommentStart implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论点赞表ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "评论id")
    private Integer commentId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
}
