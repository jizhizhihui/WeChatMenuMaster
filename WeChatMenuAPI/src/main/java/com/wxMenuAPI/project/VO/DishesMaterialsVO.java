package com.wxMenuAPI.project.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class DishesMaterialsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    // 材料名称
    private String name;

    // 材料用量
    private String number;
}
