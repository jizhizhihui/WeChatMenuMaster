//package com.wxMenuConsumer.common.aop;
////
////import com.wxMenuAPI.project.service.IRedisService;
////import com.wxMenuConsumer.common.result.CommonResult;
////import org.apache.dubbo.config.annotation.Reference;
////import org.aspectj.lang.JoinPoint;
////import org.aspectj.lang.ProceedingJoinPoint;
////import org.aspectj.lang.annotation.*;
////import org.aspectj.lang.reflect.MethodSignature;
////import org.springframework.stereotype.Component;
////import org.springframework.util.StringUtils;
////import org.springframework.web.context.request.RequestAttributes;
////import org.springframework.web.context.request.RequestContextHolder;
////import org.springframework.web.context.request.ServletRequestAttributes;
////
////import javax.servlet.http.HttpServletRequest;
////import java.lang.reflect.Method;
////import java.time.LocalDateTime;
////import java.util.HashMap;
////import java.util.Map;
////
/////**
//// * 切面处理类，操作日志异常日志记录处理
//// *
//// * @author JZhi
//// * @date 2019/03/21
//// */
////@Aspect
////@Component
////public class OpenIdCheckAspect {
////
////    @Reference(version = "1.0.0")
////    private IRedisService redisService;
////
////    /**
////     * 设置操作异常切入点记录异常日志 扫描所有controller包下操作
////     */
////    private final String executeExpr = "execution(* com.wxMenuConsumer.controller..*.*(..))";
////
////    @Before(executeExpr)
////    public com.wxMenuAPI.common.result.CommonResult<String> OpenIdCheck(ProceedingJoinPoint joinPoint) {
////        // 获取RequestAttributes
////        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
////        // 从获取RequestAttributes中获取HttpServletRequest的信息
////        HttpServletRequest request =  ((ServletRequestAttributes)requestAttributes).getRequest();
////
////        String openid = request.getParameter("openId");
////        boolean isExists = redisService.getJedis().exists(openid);
////
////        if(StringUtils.isEmpty(openid) || isExists) {
////            return CommonResult.unauthorized("NO LOGIN");
////        }
////        return CommonResult.success("ok");
////    }
////}