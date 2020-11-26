package com.wxMenuAPI.project.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * 做菜步骤模型
 */
@Data
public class DishesProcedureVO implements Serializable {

    private static final long serialVersionUID = 1L;

    //步骤数：2; 第2步
    private int step;

    // 图片ID
    private String pictureId;

    //步骤详细
    private String content;
}
