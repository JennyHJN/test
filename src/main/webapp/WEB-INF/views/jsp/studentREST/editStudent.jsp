<%--
  Created by IntelliJ IDEA.
  User: hejn
  Date: 2019/6/26
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="../../js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="${ctx }../../js/editStudent.js?v=${version}"></script>
    <title>修改学生信息</title>
</head>
<body>
<h1>编辑学生</h1>
<form action="" name="studentRESTForm">
    <input type="hidden" name="id" id="id" value="${student.id }">
    姓名：<input type="text" name="name" id="name" value="${student.name }">
    密码：<input type="text" name="password" id="password" value="${student.password}">
    年龄：<input type="text" name="age" id="age" value="${student.age }"
              onKeyUp="this.value=this.value.replace(/\D/g,'')"
              onafterpaste="this.value=this.value.replace(/\D/g,'')">
    地址：<input type="text" name="address" id="address" value="${student.address}">
    <input type="button" value="编辑" id="btnEditStudent">
</form>
</body>
</html>