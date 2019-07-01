<%--<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>--%>
<%--<html>--%>
<%--&lt;%&ndash;<body>&ndash;%&gt;--%>
<%--&lt;%&ndash;<h2>Hello World!</h2>&ndash;%&gt;--%>
<%--&lt;%&ndash;<h1>加油吧，You can do it!</h1>&ndash;%&gt;--%>
<%--&lt;%&ndash;</body>&ndash;%&gt;--%>
<%--<head>--%>
<%--    <meta charset="UTF-8"/>--%>
<%--    <title>所有学生信息</title>--%>
<%--    <script type="text/javascript" src="../../js/jquery-1.7.1.js"></script>--%>
<%--    <script src="../../js/getAllStudents.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<input type="button" value="搜索" id="btSearch"/>--%>
<%--<h2>学生管理</h2>--%>
<%--<table border="1" width="100%" id="tab_Students">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>编号</th>--%>
<%--        <th>姓名</th>--%>
<%--        <th>密码</th>--%>
<%--        <th>年龄</th>--%>
<%--        <th>地址</th>--%>
<%--        <th>操作</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody id="tb_Students">--%>
<%--    </tbody>--%>
<%--</table>--%>
<%--<p>--%>

<%--</p>--%>
<%--<p id="" class="loading" style="display: none;">--%>
<%--    <!--    <img src="images/loading.gif" align="absmiddle">努力加载中...-->--%>
<%--</p>--%>
<%--<p class="message">--%>

<%--</p>--%>
<%--</body>--%>
<%--</html>--%>
<%--
  Created by IntelliJ IDEA.
  User: hejn
  Date: 2019/6/25
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>所有学生信息</title>
    <script type="text/javascript" src="js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="${ctx }js/getAllStudents.js?v=${version}"></script>
    <script type="text/javascript" src="${ctx }js/searchStudent.js?v=${version}"></script>
    <script type="text/javascript">
        //删除
        function deleteREST(id){
            $.ajax({
                url: "http://localhost:8080/students/" + id,
                type: "Delete",
                dataType: "json",

                beforeSend: function(request){
                    request.setRequestHeader("Content-type", "application/json; charset=utf-8");
                    request.setRequestHeader("Accept", "application/json; charset=utf-8");
                },
                success: function (data) {
                    alert("删除成功");
                    window.location.reload();
                },
                error: function () {
                    alert("删除失败");
                }
            });
        }
    </script>
</head>
<body>
<form action="" name="searchStudentForm">
    <input name="stuName" id="stuName" type="text" placeholder="请输入学生的名字" autocomplete="off">
    <input type="button" value="搜索" id="btnSearchStudent">
</form>
<h3><a href="/student/toAddStudentREST">添加学生</a></h3>
<table border="1" id="tab_Students">
    <thead>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>地址</th>
        <th>操作</th>
    </tr>
    </thead>
    </thead>
    <tbody id="tb_AllStudents">
    </tbody>
</table>
</body>
</html>