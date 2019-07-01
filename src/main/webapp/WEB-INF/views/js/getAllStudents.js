$(document).ready(function() {
    var tbody = window.document.getElementById("tb_AllStudents");

    $.ajax({
        url: "http://localhost:8080/students/",
        dataType: "json",
        async: true,
        data: {},
        type: "GET",

        beforeSend: function(request){
            request.setRequestHeader("Content-type", "application/json; charset=utf-8");
            request.setRequestHeader("Accept", "application/json; charset=utf-8");
        },
        success: function (data, textStatus) {
            var str = "";
            var stu = data;
            for (var i = 0; i < stu.length; i++){
                var getStudentRESTById = "http://localhost:8080/student/getStudentREST?id=" +  stu[i].id;
                var delStudentById = "javascript:deleteREST(" + stu[i].id + ")";
                str += "<tr>" +
                    "<td>" + stu[i].id + "</td>" +
                    "<td>" + stu[i].name + "</td>" +
                    "<td>" + stu[i].password + "</td>" +
                    "<td>" + stu[i].age + "</td>" +
                    "<td>" + stu[i].address + "</td>" +
                    "<td>" + "<a href=" + getStudentRESTById + ">编辑</a>" +
                    "<a href=" + delStudentById + ">删除</a>" + "</td>" +
                    "</tr>";
            }
            tbody.innerHTML = str;
        },
        error: function () {
            alert("获取所有学生失敗了啊！")
        }
    });
});
