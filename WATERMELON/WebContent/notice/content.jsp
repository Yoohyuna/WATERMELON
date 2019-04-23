<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Contact V10</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
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
			<form class="contact100-form" action="/WaterMelon/notice.water">
				<span class="contact100-form-title" style="font-weight:bold">
					글 보기
				</span>

				<input type="hidden" name="role" value="${role}">
				
				<div class="wrap-input100 validate-input" data-validate="Please enter n_subject">
					<input class="input100" type="text" id="n_subject" name="n_subject"  value="${notice.n_subject}" disabled>
				</div>
				
				<div class="wrap-input50 validate-input" data-validate="Please enter writedate" style="width:275px;">
					<input class="input100" type="text" id="writedate" name="writedate"  value="<fmt:formatDate value="${notice.writedate}" timeStyle="medium" pattern="yy.MM.dd"/>" disabled>
					
				</div>
				<div class="wrap-input50 validate-input" data-validate="Please enter readCount"  style="width:275px;">
						<input class="input100" type="text" id="readCount" name="readCount"  value="${notice.readCount}" disabled>
					</div>
				
			

				<div class="wrap-input100 validate-input" data-validate = "Please enter content" align="center">
					<textarea class="input100" id="n_content" name="n_content"  disabled>${notice.n_content}</textarea>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input50 validate-input" data-validate="Please enter password" id="passwd" style="width:550px; display:none;">
						<input class="input100" type="password" id="password" name="password"  placeholder="관리자 비밀번호 입력" >
					</div>

				<div class="container-contact100-form-btn validate-input" style="margin-left:20px;" >
				<c:if test="${role == 1}" >
					<button type="button" class="contact100-form-btn" id="update_btn"  onclick="update(${notice.n_Num},${pageNum},${role})" value="글수정" style="margin-right:30px;">
						<span id="upspan">
							<i class="fa fa-paper-plane-o m-r-6" aria-hidden="true"></i>
							글 수정
						</span>
					</button>
					<button type="button" class="contact100-form-btn" id="delete_btn" onclick="deletebtn(${notice.n_Num},${pageNum},${role})" value="글삭제" style="margin-right:30px;">
						<span id="despan">
							<i class="fa fa-paper-plane-o m-r-6" aria-hidden="true"></i>
							글 삭제
						</span>
					</button>
					<button type="submit" class="contact100-form-btn" >
						<span>
							<i class="fa fa-paper-plane-o m-r-6" aria-hidden="true"></i>
							글 목록
						</span>
					</button>
				</c:if>
				<c:if test="${role == 0}" >
					<button type="submit" class="contact100-form-btn" style="margin-left:180px;">
						<span>
							<i class="fa fa-paper-plane-o m-r-6" aria-hidden="true"></i>
							글 목록
						</span>
					</button>
				</c:if>
				</div>
			</form>
		</div>
	</div>




	<script src="/WaterMelon/notice/js/notice.js"></script>
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