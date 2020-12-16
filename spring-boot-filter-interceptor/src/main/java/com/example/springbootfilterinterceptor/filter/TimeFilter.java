package com.example.springbootfilterinterceptor.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

/* @Component
 @WebFilter(urlPatterns = {"/*"})*/
public class TimeFilter implements Filter {


     @Override
     public void init(FilterConfig filterConfig) throws ServletException {
         System.out.println("过滤器初始化！");
     }

     @Override
     public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         System.out.println("开始过滤！");
         long time = new Date().getTime();
         filterChain.doFilter(servletRequest,servletResponse);
         System.out.println("过滤结束！");
         System.out.println("过滤器一共消耗" + (new Date().getTime() - time) + "S");
     }

     @Override
     public void destroy() {
         System.out.println("过滤器销毁！");
     }
 }
