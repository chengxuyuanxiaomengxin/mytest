<%@ page import="edu.soft1.pojo.User" %>
<%@ page import="edu.soft1.dao.NewsDao" %>
<%@ page import="java.sql.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.soft1.pojo.News" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: samsg
  Date: 2021/9/24
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>title</title>
</head>
<body>
    <%
        //1.获取登录用户信息
        User user =
        (User) session.getAttribute("loginUser");
        System.out.println("username="+user.getUsername());
        out.print("欢迎"+user.getUsername()+"登录！<br>");
        //2.获取新闻模块的(查询所有新闻)结果
        List<News> list = new ArrayList<News>();
        list = new NewsDao().findAllNews();
        for (News tmp:list
             ) {
            out.write(tmp.toString()+"<br>");
        }
        session.setAttribute("allNews",list);
        //3.跳转至newspages/admin.jsp页面
        response.sendRedirect("../newspages/admin.jsp");
    %>
</body>
</html>
