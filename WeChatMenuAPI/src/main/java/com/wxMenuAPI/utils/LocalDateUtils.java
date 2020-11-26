package com.wxMenuAPI.utils;

import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Log4j2
public class LocalDateUtils {

    public static LocalDate getNowLocalDate(){
        return LocalDate.now();
    }

    public static LocalDateTime getNowLocalDateTime(){
        return LocalDateTime.now();
    }

    public static void main(String[] args) {
        log.info(getNowLocalDateTime());
    }
}
