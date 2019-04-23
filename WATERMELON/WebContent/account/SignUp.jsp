<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${checkId==true}">
	<script>
		alert("회원가입에 실패하였습니다. 중복된 아이디가 있습니다!")
	</script>
	<meta http-equiv="Refresh" content="0;url=/WaterMelon/sign.water">
</c:if>

<c:if test="${checkPass==false}">
	<script>
		alert("회원가입에 실패하였습니다. 비밀번호를 다시한번 확인해주세요!")
	</script>
	<meta http-equiv="Refresh" content="0;url=/WaterMelon/sign.water">
</c:if>

<c:if test="${checkInsert==false}">
	<script>
		alert("회원가입에 실패하였습니다. 다시 시도해주세요!")
	</script>
	<meta http-equiv="Refresh" content="0;url=/WaterMelon/sign.water">
</c:if>

<c:if test="${check==true}">
	<script>
		alert("회원가입에 성공하였습니다!")
	</script>
	<meta http-equiv="Refresh" content="0;url=/WaterMelon/sign.water?id=<%=request.getAttribute("id") %>">
</c:if>