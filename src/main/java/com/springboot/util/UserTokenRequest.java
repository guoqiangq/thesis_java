package com.springboot.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class UserTokenRequest {
    public static Object getCurrentToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String token = request.getHeader("Authorization");
        Object tokenUser = TokenUtil.getUser(token);
        return tokenUser;
    };
    public static String getTokenUserId() {
        Object object = getCurrentToken();
        Map entity = (Map)object;
        //获取Object中id的值：
        String id = entity.get("id").toString();
        return id;
    }
    public static String getTokenUserName() {
        Object object = getCurrentToken();
        Map entity = (Map)object;
        //获取Object中name的值：
        String name = entity.get("name").toString();
        return name;
    }
}
