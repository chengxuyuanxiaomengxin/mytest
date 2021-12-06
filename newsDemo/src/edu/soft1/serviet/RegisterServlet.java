package edu.soft1.serviet;



import edu.soft1.dao.UserDao;
import edu.soft1.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String upwd = request.getParameter("upwd");

        boolean flag = new UserDao().addUser(username,upwd);
        if (flag==true){

            response.sendRedirect("index.jsp");
        }else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println("<script language='javascript'> "+
                    "alert('注册失败，请重新尝试');"+
                    "window.location.href='register.jsp';"+
                    "</script>");
            writer.flush();
            writer.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
