<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="/WaterMelon/assets/js/jquery-3.3.1.min.js"></script>
<%
	String id = (String) request.getAttribute("id");
	String password = (String) request.getAttribute("password");
	String nickname = (String) request.getAttribute("nickname");
	String name = (String) request.getAttribute("name");
	String email = (String) request.getAttribute("email");
%>
<title>WaterMelon - 회원 탈퇴</title>
<link rel="stylesheet" href="/WaterMelon/account/css/style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div id="form">
		<div class="container">
			<div
				class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-md-8 col-md-offset-2">
				<div id="userform">
					<ul class="nav nav-tabs nav-justified" role="tablist">
						<li class="active"><a id="AccountList_Title" href="#signup"
							role="tab" data-toggle="tab">회원 정보</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane fade active in" id="accountList">
							<form id="accountList" method="post" action="/WaterMelon/accountDeletePro.water?id=<%=id%>">
								<div class="form-group">
									<label> 아이디<span class="req">*</span>
									</label> <input disabled="disabled" type="text" class="form-control"
										name="id" id="id" required
										data-validation-required-message="아이디를 입력 해 주세요!"
										autocomplete="off" value="<%=id%>">
									<p class="help-block text-danger"></p>
								</div>
								<div class="row">
									<div class="col-xs-12 col-sm-6">
										<div class="form-group">
											<label> 비밀번호<span class="req">*</span>
											</label> <input type="password"
												class="form-control" name="password" id="password" required
												data-validation-required-message="비밀번호를 입력 해 주세요!"
												autocomplete="off">
											<p class="help-block text-danger"></p>
										</div>
									</div>
									<div class="col-xs-12 col-sm-6">
										<div class="form-group">
											<label> 비밀번호 확인<span class="req">*</span>
											</label> <input type="password"
												name="password_confirm" class="form-control"
												id="password_confirm" required
												data-validation-required-message="비밀번호를 한번 더 입력 해 주세요!"
												autocomplete="off">
											<p class="help-block text-danger"></p>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label> 닉네임<span class="req">*</span>
									</label> <input disabled="disabled" type="text" class="form-control"
										name="nickname" id="nickname" required
										data-validation-required-message="닉네임을 입력해주세요!"
										autocomplete="off" value="<%=nickname%>">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<label> 이름<span class="req">*</span>
									</label> <input disabled="disabled" type="text" class="form-control"
										name="name" id="name" required
										data-validation-required-message="성함을 입력 해 주세요!"
										autocomplete="off" value="<%=name%>">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<label> 이메일<span class="req">*</span>
									</label> <input disabled="disabled" type="email" class="form-control"
										name="email" id="email" required
										data-validation-required-message="이메일을 입력 해 주세요!"
										autocomplete="off" value="<%=email%>">
									<p class="help-block text-danger"></p>
								</div>
								<div class="mrgn-30-top">
									<button id="btn_AccountDelete" type="submit"
										class="btn btn-larger btn-block" value="회원 탈퇴하기!">회원
										탈퇴하기!</button>
									<button id="btn_gotoHome" type="button"
										class="btn btn-larger btn-block"
										onclick="location.href='/WaterMelon/demo-03-html/home.jsp'">메인
										페이지 가기!</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.container -->
	</div>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script src="js/index.js"></script>
</body>
</html>