<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Contact V10</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="/WaterMelon/notice/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/WaterMelon/notice/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/WaterMelon/notice/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/WaterMelon/notice/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/WaterMelon/notice/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/WaterMelon/notice/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/WaterMelon/notice/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/WaterMelon/notice/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/WaterMelon/notice/css/util.css">
	<link rel="stylesheet" type="text/css" href="/WaterMelon/notice/css/main2.css">
<!--===============================================================================================-->
</head>
<body>


	<div class="container-contact100">

		<div class="wrap-contact100">
			<form method="post" class="contact100-form validate-form" action="/WaterMelon/writePro.water?role=${role}">
				<span class="contact100-form-title" style="font-weight:bold">
					공지글 쓰기
				</span>

				

				<div class="wrap-input100 validate-input" data-validate="Please enter title">
					<input class="input100" type="text" name="n_subject" placeholder="제목">
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate = "Please enter content">
					<textarea class="input100" name="n_content" placeholder="내용" style="margin-top: 0px; margin-bottom: 0px; height: 470px;"></textarea>
					<span class="focus-input100"></span>
				</div>

				<div class="container-contact100-form-btn validate-input" style="margin-left:110px;">
					<button type="submit" class="contact100-form-btn" style="margin-right:30px;">
						<span style="font-weight:bold">
							<i class="fa fa-paper-plane-o m-r-6" aria-hidden="true"></i>
							 글 작성
						</span>
					</button>
					<button type="button" class="contact100-form-btn" onclick="location.href='/WaterMelon/notice.water?role=${role}'">
						<span>
							<i class="fa fa-paper-plane-o m-r-6" aria-hidden="true"></i>
							글 목록
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>



	<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
	<script src="/WaterMelon/notice/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="/WaterMelon/notice/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="/WaterMelon/notice/vendor/bootstrap/js/popper.js"></script>
	<script src="/WaterMelon/notice/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="/WaterMelon/notice/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="/WaterMelon/notice/vendor/daterangepicker/moment.min.js"></script>
	<script src="/WaterMelon/notice/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="/WaterMelon/notice/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="/WaterMelon/notice/js/main.js"></script>

<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');
</script>

</body>
</html>