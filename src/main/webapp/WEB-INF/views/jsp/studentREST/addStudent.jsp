<%--
  Created by IntelliJ IDEA.
  User: hejn
  Date: 2019/6/26
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="../../js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="${ctx }../../js/addStudent.js?v=${version}"></script>
</head>
<body>
<h1>添加学生</h1>
<form action="" name="studentRESTForm">
    姓名：<input type="text" name="name" id="name">
    密码：<input type="text" name="password" id="password">
    年龄：<input type="text" name="age" id="age"
              onKeyUp="this.value=this.value.replace(/\D/g,'')"
              onafterpaste="this.value=this.value.replace(/\D/g,'')" >
    地址：<input type="text" name="address" id="address">
    <input type="button" value="添加" id="btnAddStudent">
</form>
</body>
</html>

