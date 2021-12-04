package edu.soft1.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "CharSetFilter",
//        urlPatterns = {"/newspages/*","/util/*"})
public class CharSetFilter implements Filter {
    private String filterName;
    private String charSet;
    public void init(FilterConfig config) throws ServletException {
        filterName = config.getInitParameter("name");
        charSet = config.getInitParameter("charSet");
        System.out.println("过滤器"+filterName+"初始化。。。");
    }

    public void destroy() {
        System.out.println("过滤器charSetFilter销毁。。");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("开始过滤"+charSet+"字符及编码。。。。");
//        request.setCharacterEncoding(charSet);//客户端到服务端
//        response.setCharacterEncoding(charSet);//服务端到客户端
        System.out.println("过滤器charSetFilter设置字符编码");
        chain.doFilter(request, response);//进入下个过滤器，若已经是最后一个过滤器，则进入web资源
    }
}
