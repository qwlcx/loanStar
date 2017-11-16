<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/26 0026
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 引入bootstrap库 -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="jquery/jquery.min.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!-- bootstrap table组件以及中文包的引用 -->
    <script src="bootstrap-table-develop/src/bootstrap-table.js"></script>
    <link href="bootstrap-table-develop/src/bootstrap-table.css" rel="stylesheet" />
    <script src="bootstrap-table-develop/src/locale/bootstrap-table-zh-CN.js"></script>
</head>
<body>
<form role="form" action="/userLogin.action" method="post">
    <div class="form-group">
        <label for="user_character">帐号</label>
        <input type="text" class="form-control" id="user_character" name="user_character" placeholder="请输入帐号">
    </div>
    <div class="form-group">
        <label for="user_password">密码</label>
        <input type="text" class="form-control" id="user_password" name="user_password" placeholder="请输入密码">
    </div>

    <button type="submit" class="btn btn-default">登录</button>
</form>
<a class="btn btn-default" href="UserZhuce.jsp" role="button">注册</a>
</body>
</html>
