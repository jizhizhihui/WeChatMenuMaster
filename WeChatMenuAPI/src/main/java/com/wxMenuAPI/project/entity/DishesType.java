package com.wxMenuAPI.project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author com.JZhi
 * @since 2020-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_dishes_type")
@ApiModel(value="DishesType对象", description="")
public class DishesType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜品分类主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "菜品id")
    private Integer dishesId;

    @ApiModelProperty(value = "分类id")
    private Integer menuTypeId;
}
