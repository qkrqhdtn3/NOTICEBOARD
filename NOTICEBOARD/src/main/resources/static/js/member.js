// alert("hi");
function fn_login() {
    //var memberId=$("#memberId").val();
    //var password=$("#password").val();
    var data = $("#frm").serialize();

    $.ajax({
        type: "POST",
        url: "/member/login",
        data: data,
        success: function (data) {
            if (data == "Y") {
                location.href = "/board/list";
            } else {
                alert("아이디 또는 비밀번호가 일치하지 않습니다. data == 'N'");
            }
        },
        error: function (data) {
            alert("아이디 또는 비밀번호가 일치하지 않습니다. error");
        }
    }).done(function () {
        // alert("요청 성공");
    }).fail(function () {
        alert("요청 실패");
    }).always(function () {
        // alert("요청 완료");
    });
};

function fn_join() {
    var f = $('#join_frm');
    var formData = f.serialize();

    $.ajax({
        type: "POST",
        url: "/join",
        data: formData,
        success: function (data) {
            if (data == "Y") {
                alert("회원가입이 완료되었습니다.");
                location.href = "/"
            } else {
                alert("회원가입에 실패파였습니다.");
            }
        },
        error: function (data) {
            alert("회원가입 에러 발생!");
        }
    });
}

$(function () {
    var email_auth_cd = '';
    $('#join').click(function () {
        if ($('#memberId').val() == "") {
            alert("아이디를 입력해주세요.");
            return false;
        }
        if ($('#nickname').val() == "") {
            alert("닉네임을 입력해주세요.");
            return false;
        }
        if ($('#password').val() == "") {
            alert("비밀번호를 입력해주세요.");
            return false;
        }
        if ($('#password').val() != $('#password_ck').val()) {
            alert("비밀번호가 일치하지 않습니다.");
            return false;
        }
        if ($('#email_auth_key').val() != email_auth_cd) {
            alert("인증번호가 일치하지 않습니다.");
            return false;
        }
    });

    $(".email_auth_btn").click(function () {
        var email = $('#email').val();

        if (email == '') {
            alert("이메일을 입력해주세요.");
            return false;
        }
        $.ajax({
            type: "POST",
            url: "/emailAuth",
            data: {email: email},
            success: function (data) {
                alert("인증번호가 발송되었습니다.");
                email_auth_cd = data;
            },
            error: function (data) {
                alert("메일 발송에 실패했습니다.");
            }
        });
    });

    $('#memberId').focusout(function () {
        var memberId = $('#memberId').val();
        $.ajax({
            type: "POST",
            url: "/memberIdCheck",
            data: {memberId: memberId},
            success: function (data) {
                if (data == "Y") {
                    $('#memberId_ck').removeClass("dpn");
                } else {
                    $('#memberId_ck').addClass("dpn");
                }
            },
            error: function (data) {

            }
        });
    });

    $('#nickname').focusout(function () {
        var nickname = $('#nickname').val();

        $.ajax({
            type: "POST",
            url: "/nicknameCheck",
            data: {nickname: nickname},
            success: function (data) {
                if (data == "Y") {
                    $('#nickname_ck').removeClass("dpn");
                } else
                    $('#nickname_ck').addClass("dpn");
            },
            error: function (data) {

            }
        });
    });
});