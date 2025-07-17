
package kr.co.wellbe.front.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class HtmxRequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean isHtmx = request.getHeader("HX-Request") != null;
        request.setAttribute("isHtmxRequest", isHtmx);
        log.info("HTMX Interceptor - preHandle: HX-Request header present = {}, Request URI = {}", isHtmx, request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Boolean isHtmxRequest = (Boolean) request.getAttribute("isHtmxRequest");
        if (modelAndView != null && (isHtmxRequest == null || !isHtmxRequest)) {
            String uri = request.getRequestURI();
            modelAndView.addObject("initialUrl", uri);
            modelAndView.setViewName("layout/main-layout");
        }
    }
}
