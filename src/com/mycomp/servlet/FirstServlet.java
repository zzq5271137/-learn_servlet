package com.mycomp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet implements Servlet {

    /**
     * 当servlet创建的时候调用
     * 
     * servlet什么时候被创建: 
     * 1. 默认: 第一次访问的时候会被创建 
     * 2. 通过配置可以设置服务器一启动的时候就创建
     * (web.xml中用<load-on-startup>3</load-on-startup>进行配置, 数字代表优先级)
     * 
     * 创建的对象会被缓存
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init...");

        // 获取servlet-name
        String servletName = config.getServletName();
        System.out.println("ServletName = " + servletName);

        // 获取初始化参数
        String param1 = config.getInitParameter("param1");
        System.out.println("param1 = " + param1);

        // 获取ServletContext
        ServletContext servletContext = config.getServletContext();
        System.out.println(servletContext);
    }

    /**
     * 每一次发送请求的时候调用,发送一次就会调用一次
     */
    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {
        System.out.println("service...");
        HttpServletResponse response = (HttpServletResponse) res;
        PrintWriter writer = response.getWriter();
        writer.write("<h1>Hello from first servlet</h1>");
        
    }

    /**
     * 当servlet销毁的时候调用
     * 
     * 什么时候销毁servlet: 当服务器关闭的时候
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        return null;
    }

}
