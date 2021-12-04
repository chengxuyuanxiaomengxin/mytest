<%--
  Created by IntelliJ IDEA.
  User: 田金磊
  Date: 2021/10/20
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<%
response.setStatus(HttpServletResponse.SC_OK);
%>
<html>
<head>
    <title>访问的页面不存在</title>
</head>
<body>
访问的页面不存在<br>
<a href="javascript:history.go(-1)">返回上个页面</a>
</body>
</html>
