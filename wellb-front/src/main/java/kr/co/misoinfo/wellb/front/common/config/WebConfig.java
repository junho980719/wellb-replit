package kr.co.misoinfo.wellb.front.common.config;

import kr.co.misoinfo.wellb.front.common.interceptor.HtmxRequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HtmxRequestInterceptor());
    }
}
