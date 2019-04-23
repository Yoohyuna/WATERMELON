<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>WaterMelon - 아이디 / 비밀번호 찾기</title>
<!-- <link rel="stylesheet" href="../account/css/style.css"> -->
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
						<li class="active"><a href="#find_id" role="tab" data-toggle="tab">아이디 찾기</a></li>
						<li><a href="#find_password" role="tab" data-toggle="tab">비밀번호 찾기</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane fade active in" id="find_id">
							<form id="sign-in" method="post"
								action="/WaterMelon/findId.water">
								<div class="form-group">
									<label> 이름<span class="req">*</span>
									</label> <input type="text" name="name" id="name" class="form-control"
										required data-validation-required-message="이름을 입력 해 주세요!"
										autocomplete="off" value="${Login_id}">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<label> 이메일<span class="req">*</span>
									</label> <input type="text" name="email" class="form-control"
										id="email" required
										data-validation-required-message="이메일을 입력 해 주세요!"
										autocomplete="off">
									<p class="help-block text-danger"></p>
								</div>
								<div class="mrgn-30-top">
									<button type="submit" class="btn btn-larger btn-block" />
									아이디 찾기
									</button>
								</div>
							</form>
						</div>
						<div class="tab-pane fade in" id="find_password">
							<form id="sign-up" method="post"
								action="/WaterMelon/findPassword.water">
								<div class="form-group">
									<label> 아이디<span class="req">*</span>
									</label> <input type="text" class="form-control" name="id" id="id"
										required data-validation-required-message="아이디를 입력 해 주세요!"
										autocomplete="off">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<label> 이름<span class="req">*</span>
									</label> <input type="text" class="form-control" name="name" id="name"
										required data-validation-required-message="이름을 입력 해 주세요!"
										autocomplete="off">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<label> 이메일<span class="req">*</span>
									</label> <input type="text" class="form-control" name="email" id="email"
										required data-validation-required-message="이메일을 입력 해 주세요!"
										autocomplete="off">
									<p class="help-block text-danger"></p>
								</div>
								<div class="mrgn-30-top">
									<button type="submit" class="btn btn-larger btn-block" />
									비밀번호 찾기!
									</button>
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

	<script src="/WaterMelon/account/js/index.js"></script>
</body>
</html>