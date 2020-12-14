package com.wxMenuAPI.project.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.wxMenuAPI.utils.ImageUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜谱分类
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_menu_type")
@ApiModel(value="MenuType对象", description="菜谱分类信息")
public class MenuType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜品分类表主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父级")
    private Integer parent;

    @ApiModelProperty(value = "分类名称")
    private String menuName;

    @ApiModelProperty(value = "分类图片")
    private String menuImage;

    public String getMenuImage(){
        return ImageUtils.dishesTypePicturePath(menuImage) ;
    }
}
