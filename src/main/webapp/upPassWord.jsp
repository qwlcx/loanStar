<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/11/15
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src="images/login.png" style="margin-top: 0px;margin-left: 0px"><br/>
<c:choose>
<c:when test="${dis=='dis'}">
    <h1 style="margin-left: 400px;margin-top: 50px">修改成功</h1>
</c:when>
<c:otherwise>
    <form action="/upPass.action" method="post" style="margin-left: 400px">
        新密码：<input type="password" minlength="6" name="administrator_password1"/><br/>
        确认密码：<input type="password" name="administrator_password2"/><br/>
        <input type="submit" value="确认">
    </form>
</c:otherwise>
</c:choose>
</body>
</html>
