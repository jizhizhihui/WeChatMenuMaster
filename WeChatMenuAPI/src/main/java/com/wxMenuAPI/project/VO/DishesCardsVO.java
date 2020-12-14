package com.wxMenuAPI.project.VO;

import com.wxMenuAPI.project.entity.Dishes;
import lombok.Data;

import java.io.Serializable;

@Data
public class DishesCardsVO implements Serializable {

    private String dishesTitle;
    private String dishesHead;
    private String collection;
    private String userHeader;
    private String username;

    public DishesCardsVO(){
    }

    public DishesCardsVO(Dishes dishes){
        this.dishesTitle =  dishes.getDishesTitle();
        this.dishesHead = dishes.getDishesHead();
        this.userHeader = dishes.getUserHeader();
        this.username = dishes.getUsername();
    }

    public String getDishesTitle(){
        if (dishesTitle.length() > 20)
            return dishesTitle.substring(0,18) + "…";
        return dishesTitle;
    }
}
