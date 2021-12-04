package edu.soft1.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LogonFilter",urlPatterns = {"/newspages/*","/util/*"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器LogonFilter销毁..");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session.getAttribute("loginUser") == null){
//未登入，给出提示，跳转到其他页面
            resp.sendRedirect(req.getContextPath()+"/error/error.jsp");

        }else {
            chain.doFilter(request, response);
        }
        }
}
