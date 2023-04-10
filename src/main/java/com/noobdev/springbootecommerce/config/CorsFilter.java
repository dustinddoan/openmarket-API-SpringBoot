package com.noobdev.springbootecommerce.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CorsFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    Filter.super.init(filterConfig);
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletResponse servletResponse = (HttpServletResponse) response;
    HttpServletRequest servletRequest= (HttpServletRequest) request;

    servletResponse.setHeader("Access-Control-Allow-Origin", "*");
    servletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
    servletResponse.setHeader("Access-Control-Allow-Headers", "*");
    servletResponse.setHeader("Access-Control-Allow-Credentials", "true");
    servletResponse.setHeader("Access-Control-Max-Age", "180");
    chain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
    Filter.super.destroy();
  }
}
