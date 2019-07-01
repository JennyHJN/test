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
    <script type="text/javascript">
        function del(id){
            $.get("delStudent?id=" + id,function(data){
                if("success" == data.result){
                    alert("删除成功");
                    window.location.reload();
                }else{
                    alert("删除失败");
                }
            });
        }

        function searchStudent(){
            var form = document.forms['searchForm'];  //获取name为form1的form表单
            form.action = "getStudentByName";
            form.method="get";
            form.submit();
        }
    </script>
</head>
<body>
<form action="" name="searchForm">
    <input name="name" type="text" placeholder="请输入学生的名字" autocomplete="off">
    <input type="button" value="搜索" onclick="searchStudent()">
</form>
<h3><a href="toAddStudent">添加学生</a></h3>
<table border="1">
    <tbody>
    <tr>
        <th>姓名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>地址</th>
        <th>操作</th>
    </tr>
    <c:if test="${!empty studentList }">
        <c:forEach items="${studentList }" var="student">
            <tr>
                <td>${student.name }</td>
                <td>${student.password}</td>
                <td>${student.age }</td>
                <td>${student.address}</td>
                <td>
                    <a href="getStudent?id=${student.id }">编辑</a>
                    <a href="javascript:del('${student.id }')">删除</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
