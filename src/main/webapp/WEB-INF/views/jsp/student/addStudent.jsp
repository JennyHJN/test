<%--
  Created by IntelliJ IDEA.
  User: hejn
  Date: 2019/6/13
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
        function addStudent(){
            var form = document.forms['studentForm'];
            //var form = document.forms[0];
            form.action = "addStudent";
            form.method = "post";
            form.submit();
        }
    </script>
</head>
<body>
<h1>添加学生</h1>
<form action="" name="studentForm">
    姓名：<input type="text" name="name" id="name">
    密码：<input type="text" name="password" id="password">
    年龄：<input type="text" name="age" id="age">
    地址：<input type="text" name="address" id="address">
    <input type="button" value="添加" onclick="addStudent()">
</form>
</body>
</html>
