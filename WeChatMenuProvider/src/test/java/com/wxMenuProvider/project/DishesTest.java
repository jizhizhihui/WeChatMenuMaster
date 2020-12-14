package com.wxMenuProvider.project;

import com.wxMenuAPI.project.service.IDishesService;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class DishesTest {

    @Reference(version = "1.0.0")
    private IDishesService dishesService;

    @Test
    public void getDishesCards(){
        log.info(dishesService.getDishesCards(null,1,1));
    }
}
