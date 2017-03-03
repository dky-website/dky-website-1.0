package com.dky.website.web.controller;

import com.dky.website.common.constats.GlobConts;
import com.dky.website.common.response.ReturnT;
import com.dky.website.common.utils.PropertieUtils;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by wonpera on 2017/1/7.
 */
@Order(Integer.MAX_VALUE)
@ControllerAdvice(basePackages = "com.dky.website.web.controller")
public class DykResponseBodyAdvice implements ResponseBodyAdvice<Object> {



    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        HttpServletRequest request = ((ServletServerHttpRequest)serverHttpRequest).getServletRequest();
        String callback = request.getParameter("callback");
        if(StringUtils.isNoneBlank(callback)){
            ReturnT returnT = (ReturnT) body;
            String result = callback + "(" + new Gson().toJson(returnT) +")";
            HttpServletResponse response = ((ServletServerHttpResponse)serverHttpResponse).getServletResponse();
            writeResponse(response,result);
            return null;
        }
        return body;
    }


    private void writeResponse(HttpServletResponse response,String result){
        try {
            response.setCharacterEncoding(PropertieUtils.getString(GlobConts.RESPONSE_ENCODING));
            response.getWriter().write(result);
        } catch (IOException e) {

        }
    }




}
