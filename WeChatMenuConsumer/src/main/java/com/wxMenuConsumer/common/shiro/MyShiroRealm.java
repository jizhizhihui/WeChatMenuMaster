//package com.wxMenuConsumer.common.shiro;
//
//import com.wxMenuAPI.project.service.IRedisService;
//import org.apache.dubbo.config.annotation.Reference;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.util.StringUtils;
//
//public class MyShiroRealm extends AuthorizingRealm {
//
//    @Reference(version = "1.0.0")
//    private IRedisService redisService;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        return new SimpleAuthorizationInfo();
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
//        //获取用户的输入的账号.
//        String openid = (String) token.getPrincipal();
//        boolean isExists = redisService.updateWxSessionExpire(openid);
//        if (StringUtils.isEmpty(openid) || isExists) { return null; }
//
//        return new SimpleAuthenticationInfo();
//    }
//}