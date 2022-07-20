function fn_boardRegi(){
	/*
	var subject = $("#subject").val();
	var name = $("#name").val();
	var content = $("#content").val();
	*/
	var data = $("#frm").serialize();
	//alert(data);
	$.ajax({
		//type : "GET",
		type : "POST",
		url : "/board/regi",
		data : data,
		//data : {subject : subject, name : name, content : content},
		//dataType : 'json',
		//async: false,
		//data : JSON.stringify(data),
		//dataType:"text",
		//contentType : "application/json; charset=UTF-8",
		success: function(data){
			//alert('?');
			if(data=="Y"){
				alert("글 등록이 완료되었습니다.");
				location.href="/board/list";
			} else{
				alert("글 등록 실패");
			}	
			
		},/*
		error: function(data){
			alert("실패"+data);
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}*/
		/*
		error: function(jqXHR, textStatus, errorThrown){
			alert("ERROR : " + textStatus + " : " + errorThrown);
		}*/
		error: function(xhr, ajaxOptions, thrownError){
			alert(xhr.status + " , " + xhr.responseText);
			alert(thrownError);
		}
		
	}).done(function(){
		alert("요청 성공");
	}).fail(function(){
		//alert("요청 실패");
	}).always(function(){
		//alert("요청 완료");
	});
	//alert('hi4');
};

function fn_goView(seq){
	$("#seq").val(seq);
	
	var f = $("frm");
	f.attr("action", "/board/view");
	f.attr("method", "POST");
	f.submit();
};