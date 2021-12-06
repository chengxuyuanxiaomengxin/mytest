<%--
  Created by IntelliJ IDEA.
  User: 田金磊
  Date: 2021/9/25
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="edu.soft1.dao.UserDao" %>

<%@ page import="edu.soft1.pojo.User" %>
<%--
  Created by IntelliJ IDEA.

  Date: 2021/9/24
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="textml;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>do_login</title>
    </head>
    <body>
        <%
            //  //设置字符集编码()
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");

            //1，解析Rwquest对象，获取username,upwd对象
            String username = request.getParameter("username");
            String upwd = request.getParameter("upwd");
            //2,查询用户是否存在：调用UserDao中的findUser()方法
            User user = new UserDao().findUser(username,upwd);
            //3.判定返回值，跳转页面
            if (user != null){//查询到用户
                out.write("欢迎"+ ((User) user).getUsername()+"登录!");
                //将用户user存入session
                session.setAttribute("loginUser",user);
                response.sendRedirect("do_news_list.jsp");//新闻页面
            }else{//没有查询到用户，跳转回去
                System.out.print("登录失败");
                response.sendRedirect("");//跳转(重定向)到登录页面
            }
        %>
    </body>
</html>
