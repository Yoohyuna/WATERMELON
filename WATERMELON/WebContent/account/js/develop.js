function accountUpdate(id, password, nickname, name, email) {
	if ($('#btn_AccountUpdate').val() == '회원정보 수정하기!') {
		$('#btn_AccountUpdate').val('수정 할게요!');
		$('#btn_AccountUpdate').text('수정 할게요!');
		$('#password').attr('disabled', false);
		$('#password_confirm').attr('disabled', false);
		$('#nickname').attr('disabled', false);
		$('#email').attr('disabled', false);
		return false;
	} else {
		$('#btn_AccountUpdate').val('회원정보 수정하기!');
		$('#btn_AccountUpdate').text('회원정보 수정하기!');
		$('#password').attr('disabled', true);
		$('#password_confirm').attr('disabled', true);
		$('#nickname').attr('disabled', true);
		$('#email').attr('disabled', true);
		window
				.open(
						"/WaterMelon/accountUpdateCheck.water?id=" + id
								+ "&password=" + password + "&nickname="
								+ nickname + "&name=" + name + "&email="
								+ email,
						"post",
						"left=400,top=220,width=500,height=300,menubar=no,status=yes,toolbar=no,scrollbars=yes");
	}
}

function accountDelete(id, password) {
	if ($('#btn_AccountDelete').val() == '회원 탈퇴하기!') {
		$('#btn_AccountDelete').val('삭제 하시려면 비밀번호 입력 후 다시 눌러주세요!');
		$('#btn_AccountDelete').text('삭제 하시려면 비밀번호 입력 후 다시 눌러주세요!');
		$('#password').attr('disabled', false);
		return false;
	} else {
		location.href = "/WaterMelon/accountDelete.water?id=" + id
				+ "&password=" + password;
	}
}

function dataLoad(id, nickname, name, email) {
	$('#id').val(id)
	$('#nickname').val(nickname)
	$('#name').val(name)
	$('#email').val(email)
}