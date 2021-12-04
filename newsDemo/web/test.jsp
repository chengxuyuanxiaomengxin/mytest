<%--
  Created by IntelliJ IDEA.

  Date: 2021/10/18
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
    String basePath =
    request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath;
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div> contextPath = <%=contextPath%> </div>
<div> basePath = <%=basePath%>> </div>
<a href="images/banner.jpg">点击看图1</a>
<a href="<%=contextPath%>/images/banner.jpg">点击看图2</a>
<a href="${pageContext.request.contextPath}/images/banner.jpg">点击看图3</a>
<a href="${requestScope.contextPath}images/banner.jpg">点击看图4</a>
</body>
</html>
