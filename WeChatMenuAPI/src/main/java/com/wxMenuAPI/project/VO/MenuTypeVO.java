package com.wxMenuAPI.project.VO;

import com.wxMenuAPI.project.entity.MenuType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MenuTypeVO implements Serializable {
    private MenuType parent;
    private List<MenuType> children;
}
