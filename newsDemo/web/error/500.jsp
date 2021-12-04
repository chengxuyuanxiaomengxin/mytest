<%--
  Created by IntelliJ IDEA.
  User: 田金磊
  Date: 2021/10/20
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%
response.setStatus(HttpServletResponse.SC_OK);
%>
<html>
<head>
    <title>内部服务器错误</title>
</head>
<body>
程序发生错误<br>
<a href="${pageContext.request.contextPath}/index.jsp">返回首页</a>
</body>
</html>
