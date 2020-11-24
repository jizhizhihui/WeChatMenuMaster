package com.wxMenuAPI.project.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 浏览收藏
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_browsing")
@ApiModel(value="Browsing对象", description="浏览收藏信息")
public class Browsing implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "收藏表ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "菜品id")
    private Integer dishesId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "收藏(0:false;1:true)")
    private Boolean collection;

    @ApiModelProperty(value = "浏览(0:false;1:true)")
    private Boolean browsing;


}
