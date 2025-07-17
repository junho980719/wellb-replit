
package kr.co.misoinfo.core.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class HtmxRequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean isHtmx = request.getHeader("HX-Request") != null;
        request.setAttribute("isHtmxRequest", isHtmx);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Boolean isHtmxRequest = (Boolean) request.getAttribute("isHtmxRequest");

        // 로그인 페이지는 별도 layout
        if (request.getRequestURI().startsWith("/auth")) {
            return;
        }

        if (modelAndView != null && (isHtmxRequest == null || !isHtmxRequest)) {
            String uri = request.getRequestURI();
            modelAndView.addObject("initialUrl", uri);
            modelAndView.setViewName("layout/main-layout");
        }
    }
}
