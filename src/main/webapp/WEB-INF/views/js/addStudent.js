$(function () {
    $('#btnAddStudent').click(function () {
        var name = $('#name').val();
        var password = $('#password').val();
        var age = $('#age').val();
        var address = $('#address').val();
        // var form = document.forms["studentRESTForm"];
        var post_data = {name: name,
            password: password,
            age: age,
            address: address};
        $.ajax({
            url: "http://localhost:8080/students/",
            dataType: "json",
            async: false,
            data: JSON.stringify(post_data),
            type: "POST",

            beforeSend: function(request){
                request.setRequestHeader("content-type", "application/json; charset=utf-8");
                request.setRequestHeader("Accept", "application/json; charset=utf-8");

            },
            success:function (data) {
                alert("添加学生成功！");
                window.location.href="http://localhost:8080/";
            },
            error:function () {
                alert("添加学生失敗了！");
            }
        });
    });
});