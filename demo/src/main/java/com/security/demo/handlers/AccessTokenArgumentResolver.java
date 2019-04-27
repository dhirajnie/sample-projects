package com.security.demo.handlers;

import com.security.demo.configuration.AccessToken;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public class AccessTokenArgumentResolver implements HandlerMethodArgumentResolver
{

    @Override
    public boolean supportsParameter( MethodParameter methodParameter )
    {
        return methodParameter.getParameterType().equals(AccessToken.class);
    }


    @Override
    public Object resolveArgument( MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
        NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory )
    {
        String code = nativeWebRequest.getHeader( "code" );
        System.out.println( code );
        return new AccessToken( "this is access-token" );
    }

}
