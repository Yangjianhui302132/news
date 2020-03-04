package com.cloud.news.member.service.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.cloud.news.common.entity.base.BaseResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String secretKey = request.getHeader("from");
        //不是从网关中转发过来的，则拦截不允许直接访问
        if(StringUtils.isBlank(secretKey)||!secretKey.equals("gateway")){
            //给客户端返回错误消息
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSONObject.toJSONString(BaseResponse.getErrorResponse("访问的页面不存在")));
            return false;
        }
        return true;
    }
}
