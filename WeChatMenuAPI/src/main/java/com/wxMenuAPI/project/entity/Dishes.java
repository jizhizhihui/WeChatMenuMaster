package com.wxMenuAPI.project.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.wxMenuAPI.project.VO.DishesMaterialsVO;
import com.wxMenuAPI.project.VO.DishesProcedureVO;
import com.wxMenuAPI.project.VO.DishesTypeVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import springfox.documentation.spring.web.json.Json;

/**
 * 菜品
 *
 * @author com.JZhi
 * @since 2020-11-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_dishes")
@ApiModel(value="Dishes对象", description="菜品信息")
public class Dishes implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜品表主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "菜品名称")
    private String dishesName;

    @ApiModelProperty(value = "菜品分类；多个分类的标签：[{'id':1,'name';'家常菜'},{'id':8,'name;:'烘焙'}]")
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<DishesTypeVO> menuType;

    @ApiModelProperty(value = "作者")
    private Integer userId;

    @ApiModelProperty(value = "用料；如：[{'name':'鸡蛋','number':'2个'},{'name':'面粉','number':'500克'}]")
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<DishesMaterialsVO> materials;

    @ApiModelProperty(value = "做菜详细；如：[{'step‘:1,'picture':'image1',content':‘步骤详情’}，{'step‘:2,'pictureId':'image2','content':‘步骤详情’}]")
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<DishesProcedureVO> detailed;

    @ApiModelProperty(value = "提示")
    private String tips;

    @ApiModelProperty(value = "发布日期")
    private LocalDate publishTime;

    @ApiModelProperty(value = "更新日期")
    private LocalDate updateTime;

}
