package edu.soft1.serviet;

import edu.soft1.dao.UserDao;
import edu.soft1.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet",
        loadOnStartup = 1,
        value = "/loginServlet",
         initParams = {@WebInitParam(name="name1",value = "value1"),
                       @WebInitParam(name="name2",value = "value2")})



public class loginServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("开始创建LoginServlet");

        super.init(config);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
       System.out.println("LoginServlet的service");
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//接收get方法提交的数据
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("1111");
        String username = request.getParameter("username");
        String upwd = request.getParameter("upwd");
        User user = new UserDao().findUser(username,upwd);

        if (user!=null){//查询到用户
            //将用户user存入session
            HttpSession session = request.getSession();

            session.setAttribute("loginUser",user);
            //session.removeAttribute("session");
//            request.getRequestDispatcher("NewsListServlet").forward(request,response);
            //response.sendRedirect("newspages/admin.jsp");
            //跳转到下个页面
            response.sendRedirect("NewslistServlet");//新闻页面
        }else{//没有查询到用户，跳转回去
            //response.sendRedirect("../index.jsp");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print("<script language='javascript'>"+
                    //"alert('账号密码错误，请重新登入！');"+
                    "window.location.href='index.jsp';"+
                    "</script>");
            writer.flush();//输出流清空
            writer.close();//输出流关闭
        }
    }





    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接收post方法提交的数据
//        System.out.println("进入doPost()方法");
        this.doGet(request,response);//调用doGet()方法
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
