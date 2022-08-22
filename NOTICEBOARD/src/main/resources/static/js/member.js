// alert("hi");
function fn_login(){
	//var id=$("#id").val();
	//var password=$("#password").val();
	var data = $("#frm").serialize();
	
	$.ajax({
		type : "POST",
		url : "/member/login",
		data : data,
		success : function(data){
			if(data == "Y"){
				location.href="/board/list";
			} else{
				alert("아이디 또는 비밀번호가 일치하지 않습니다. data == 'N'");
			}
		},
		error : function(data){
			alert("아이디 또는 비밀번호가 일치하지 않습니다. error");
		}
	}).done(function(){
		// alert("요청 성공");
	}).fail(function(){
		alert("요청 실패");
	}).always(function(){
		// alert("요청 완료");
	});
};