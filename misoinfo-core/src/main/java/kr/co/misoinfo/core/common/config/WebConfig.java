package kr.co.misoinfo.core.common.config;

import kr.co.misoinfo.core.common.interceptor.HtmxRequestInterceptor;
import kr.co.misoinfo.core.common.interceptor.LoginCheckInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(name = "security.type", havingValue = "front")
public class WebConfig implements WebMvcConfigurer {

    private final LoginCheckInterceptor loginCheckInterceptor;
    private final HtmxRequestInterceptor htmxRequestInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] commonExclusions = {"/auth/**", "/css/**", "/js/**"};

        // login session interceptor
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(commonExclusions);

        // htmx interceptor
        registry.addInterceptor(htmxRequestInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(commonExclusions);
    }
}
