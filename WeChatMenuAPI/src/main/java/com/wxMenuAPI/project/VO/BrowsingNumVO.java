package com.wxMenuAPI.project.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class BrowsingNumVO implements Serializable {

    private static final long serialVersionUID = 1L;

    //浏览数
    private String browsingNum;

    //收藏数
    private String collectionNum;
}
