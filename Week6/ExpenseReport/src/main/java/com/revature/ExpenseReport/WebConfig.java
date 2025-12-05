package com.revature.ExpenseReport;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    // Fields
    private final BasicAuthInterceptor basicAuthInterceptor;


    // Constructor
    @Configuration
    public WebConfig(BasicAuthInterceptor bai {
        this.basicAuthInterceptor = bai;
    })

    // Methods
    @Override
    public void addInterceptors (InterceptorRegistry reg){
        // adding interceptors t the list of active/running
        // that are scanning requests as they come in
        reg.addInterceptor(basicAuthInterceptor);
            .addPathPatterns("/api/**")
            .excludePathPatterns("/api/hello");
    }
}
