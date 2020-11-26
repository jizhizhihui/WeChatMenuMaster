package com.wxMenuAPI.project.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class DishesTypeVO implements Serializable {

    private static final long serialVersionUID = 1L;

    // 分类id
    private int id;

    // 分类名称
    private int name;
}
