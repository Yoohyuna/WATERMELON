


	 
	function update(n_Num, pageNum, role) {
	if ($('#update_btn').val() == '글수정') {
		$('#n_subject').attr('disabled', false).css('background', '#dee1e3')
		$('#n_content').attr('disabled', false).css('background', '#dee1e3')
		$('#update_btn').val('수정 완료!')
		$('#upspan').html('수정 완료!')
	} else {
		var n_subject = $('#n_subject').val()
		var n_content = $('#n_content').val()
		location.href = "/WaterMelon/noticeUpdate.water?n_Num=" + n_Num
				+ "&pageNum=" + pageNum + "&n_subject=" + n_subject
				+ "&n_content=" + n_content + "&role=" + role
	}
}

function deletebtn(n_Num, pageNum, role) {
	if($('#delete_btn').val() == '글삭제') {
		$('#passwd').css('display', 'block')
		$('#delete_btn').val('삭제 하기!')
		$('#despan').html('삭제 하기!')
	}else {
		var password = $('#password').val()
		location.href = "/WaterMelon/noticeDelete.water?n_Num=" + n_Num
		+ "&pageNum=" + pageNum + "&password=" + password
		+ "&role=" + role
	}
}
	 




