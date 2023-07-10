package com.skyjiangccheng.sdd.unsettled;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApiInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization=request.getHeader("Authorization");
        if(authorization == null || ! authorization.startsWith("Bearer ")){
            this.setErrorResponse(response,"未携带token");
            return false;
        }
        String token=authorization.substring(7);
        try {
            request.setAttribute("user",Jwt.parseJwt(token));
        }catch(Exception e) {
            this.setErrorResponse(response,e.getMessage());
            return  false;
        }
        return  true;
    }
    protected void setErrorResponse(HttpServletResponse response,String message) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(message);
        response.getWriter().flush();
        response.getWriter().close();

    }
}