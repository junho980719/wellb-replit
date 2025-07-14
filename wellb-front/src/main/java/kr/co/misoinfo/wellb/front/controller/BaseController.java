
package kr.co.misoinfo.wellb.front.controller;

import jakarta.servlet.http.HttpServletRequest;

public abstract class BaseController {
    
    /**
     * HTMX 요청인지 확인하여 적절한 템플릿을 반환
     * @param request HTTP 요청
     * @param fullTemplateName 전체 페이지 템플릿명
     * @param contentTemplateName 컨텐츠만 있는 템플릿명
     * @return 반환할 템플릿명
     */
    protected String getTemplateName(HttpServletRequest request, String fullTemplateName, String contentTemplateName) {
        if (request.getHeader("HX-Request") != null) {
            return contentTemplateName;
        }
        return fullTemplateName;
    }
    
    /**
     * HTMX 요청인지 확인
     * @param request HTTP 요청
     * @return HTMX 요청 여부
     */
    protected boolean isHtmxRequest(HttpServletRequest request) {
        return request.getHeader("HX-Request") != null;
    }
}
