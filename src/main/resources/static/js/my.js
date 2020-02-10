/*<![CDATA[*/
$('#quit').click(function () {
    $.ajax({
        type: "post",
        url: "/user/quitLogin",
        contentType: "application/json;charset=utf-8",
        success: function (result) {
            alert("注销成功")
            window.location.href = "login"
        }
    })
})
/*]]>*/