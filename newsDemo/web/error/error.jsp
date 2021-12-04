<%--
  Created by IntelliJ IDEA.
  User: 田金磊
  Date: 2021/10/19
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
尚未登入，没有权限进入请求页面
<a href="${pageContext.request.contextPath}/index.jsp">返回登入界面</a>
</body>
</html>
