package com.wxMenuAPI.project.VO;

import lombok.Data;

/**
 * 做菜步骤模型
 */
@Data
public class DishesProcedureVO {

    //步骤数：2; 第2步
    private int step;

    // 图片ID
    private String pictureId;

    //步骤详细
    private String detailed;
}
