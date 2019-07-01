<%--
  Created by IntelliJ IDEA.
  User: hejn
  Date: 2019/6/13
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="../../js/jquery-1.7.1.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>编辑学生 </h1>
<form action="updateStudent" name="studentForm" method="post">
    <input type="hidden" name="id" value="${student.id }">
    姓名：<input type="text" name="name" value="${student.name }">
    密码：<input type="text" name="password" value="${student.password}">
    年龄：<input type="text" name="age" value="${student.age }">
    地址：<input type="text" name="address" value="${student.address}">
    <input type="submit" value="编辑" >
</form>
</body>
</html>
