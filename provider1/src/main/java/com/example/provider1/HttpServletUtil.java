package com.example.provider1;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class HttpServletUtil {

    /**
     * 获取请求所有header
     * @param request
     * @return
     */
    public static Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> headerMap = new HashMap<>();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name	= enumeration.nextElement();
            String value = request.getHeader(name);
            headerMap.put(name, value);
        }
        return headerMap;
    }

    /**
     * 获取请求所有参数
     * @param request
     * @return
     */
    public static Map<String, String> getParameters(HttpServletRequest request) {
        Map<String, String> parameterMap = new HashMap<>();
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name	= enumeration.nextElement();
            String value = request.getParameter(name);
            parameterMap.put(name, value);
        }
        return parameterMap;
    }
}
