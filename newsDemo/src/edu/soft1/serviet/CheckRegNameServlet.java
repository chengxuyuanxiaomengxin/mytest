package edu.soft1.serviet;

import edu.soft1.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckRegNameServlet", value = "/CheckRegNameServlet")
public class CheckRegNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String regName = request.getParameter("regName");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //查询数据库,调用UserDao中的查询方法
        int res = new UserDao().findUserByName(regName);
            out.print(res);//向前端用输出流的方式发送一个值（返回值）
            out.flush();//清空输出流
            out.close();//关闭数据流
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
