function fn_boardRegi(){
	var data = $("#frm").serialize();
	
	$.ajax({
		type : "POST",
		url : "/board/regi",
		data : data,
		success: function(data){
			if(data=="Y"){
				alert("글 등록이 완료되었습니다.");
				location.href="/board/list";
			} else{
				alert("글 등록 실패");
			}	
			
		},
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
};

function fn_boardUpdate(){
	var seq = $("#seq").val();
	var data = $("#frm").serialize();
	
	$.ajax({
		type : "POST",
		url : "/board/update",
		data : data,
		success : function(data){
			if(data=="Y"){
				alert("글 수정이 완료되었습니다.");
				alert(seq);
				fn_goView(seq);
			} else{
				alert("글 수정이 실패되었습니다.");
			}
		},
		error : function(data){
			alert("실패");
		}
	});
};

function fn_boardDelete(seq){
	$.ajax({
		type : "POST",
		url : "/board/delete",
		data : {seq : seq},
		success : function(data){
			if(data=="Y"){
				alert("글 삭제가 완료되었습니다.");
			} else{
				alert("글 삭제가 실패되었습니다.");
			}
		},
		error : function(data){
			alert("실패");
		}
	})
};

function fn_goView(seq){
	$("#seq").val(seq);
	
	var f = $("#frm");
	f.attr("action", "/board/view");
	f.attr("method", "POST");
	f.submit();
};

function fn_goUpdateView(seq){
	$("#seq").val(seq);
	
	var f = $("#frm");
	f.attr("action", "/board/goUpdateView");
	f.attr("method", "POST");
	f.submit();
};