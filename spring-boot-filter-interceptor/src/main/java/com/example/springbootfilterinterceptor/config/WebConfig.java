package com.example.springbootfilterinterceptor.config;


import com.example.springbootfilterinterceptor.filter.TimeFilter;
import com.example.springbootfilterinterceptor.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        filterRegistrationBean.setFilter(timeFilter);

        List<String> urlList = new ArrayList<>();
        urlList.add("/*");

        filterRegistrationBean.setUrlPatterns(urlList);
        return filterRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TimeInterceptor())
                .addPathPatterns("/**")//拦截所有
                .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**");//排除登录页面 静态资源 以及登录请求
    }
}
