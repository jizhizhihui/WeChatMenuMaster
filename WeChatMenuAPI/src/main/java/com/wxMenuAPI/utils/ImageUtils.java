package com.wxMenuAPI.utils;

import org.springframework.util.StringUtils;

public class ImageUtils {

    //    @Value("${spring.file.requestImagePath}")
    private static String imagePath = "http://127.0.0.1:9098/";

    // 菜品头像路径
    public static String dishesHeaderPath(String image) {
        if (!StringUtils.isEmpty(image))
            return imagePath + "dishes/header/"+ image;
        return null;
    }

    // 菜品步骤图片路径
    public static String dishesStepPicturePath(String image) {
        if (!StringUtils.isEmpty(image)) return imagePath + "dishes/stepPic/"+ image;
        return null;
    }

    // 菜品分类图片路径
    public static String dishesTypePicturePath(String image) {
        if (!StringUtils.isEmpty(image)) return imagePath + "dishes/type/"+ image;
        return null;
    }

    // 用户头像路劲
    public static String userHeaderPath(String image) {
        if (!StringUtils.isEmpty(image)) return imagePath + "userHeader/" + image;
        return null;
    }

    public static void main(String[] args) {
        System.out.println(imagePath);
    }
}
