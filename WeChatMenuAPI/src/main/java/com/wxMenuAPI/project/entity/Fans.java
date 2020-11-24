package com.wxMenuAPI.project.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 粉丝
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_fans")
@ApiModel(value="Fans对象", description="粉丝信息 ")
public class Fans implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "粉丝表id")
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "粉丝id")
    private Integer fansUserId;

    @ApiModelProperty(value = "关注状态(0关注 1取消)")
    private Boolean status;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime creatTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
}
