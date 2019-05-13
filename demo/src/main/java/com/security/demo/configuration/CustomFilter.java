package com.security.demo.configuration;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

public class CustomFilter implements Filter
{

    @Override
    public void init( FilterConfig filterConfig ) throws ServletException
    {
        System.out.println("Filter init called");
    }


    @Override
    public void doFilter( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain )
        throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Principal principal= httpServletRequest.getUserPrincipal();
        System.out.println(principal.toString());
    }


    @Override
    public void destroy()
    {
        System.out.println("Filter is destroyed");
    }
}
