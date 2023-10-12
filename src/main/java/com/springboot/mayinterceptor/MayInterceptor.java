package com.springboot.mayinterceptor;

import com.springboot.util.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MayInterceptor implements HandlerInterceptor {


    //Controller逻辑执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        String uri = request.getRequestURI();
//        System.out.println("当前路径-url:"+uri);

        /**
         * HandlerMethod=>Controller中标注@RequestMapping的方法
         *  需要配置静态资源不拦截时，添加这块逻辑  => 前后端分离项目
         **/
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String token=request.getHeader("Authorization");

        if (!TokenUtil.verify(token)) {
            System.out.println("no login!");
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":401,\"msg\":\"用户未登录\"}");
            // 未登录跳转到登录界面
            return false;
        } else {
            return true;
        }
    }

    //Controller逻辑执行完毕但是视图解析器还未进行解析之前
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle....");
    }

    //Controller逻辑和视图解析器执行完毕
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//        System.out.println("afterCompletion....");
    }
}
