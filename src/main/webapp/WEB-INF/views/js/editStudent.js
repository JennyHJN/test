$(function () {
    $('#btnEditStudent').click(function () {
        var id = $('#id').val();
        var name = $('#name').val();
        var password = $('#password').val();
        var age = $('#age').val();
        var address = $('#address').val();

        var put_data = {
            name: name,
            password: password,
            age: age,
            address: address
        };
        $.ajax({
            url: "http://localhost:8080/students/" + id,
            dataType: "json",
            async: false,
            data: JSON.stringify(put_data),
            type: "PUT",

            beforeSend: function(request){
                request.setRequestHeader("content-type", "application/json; charset=utf-8");
                request.setRequestHeader("Accept", "application/json; charset=utf-8");

            },
            success:function (data) {
                alert("修改学生成功！");
                window.location.href="http://localhost:8080/";
            },
            error:function () {
                alert("修改学生失敗了！");
            }
        });
    });
})