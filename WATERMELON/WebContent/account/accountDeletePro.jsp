<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${check==-1}">
	<script>
		alert("회원 탈퇴에 실패하였습니다!\n 탈퇴하시려면 비밀번호를 정확히 입력해주세요!")
		history.go(-1)
	</script>

</c:if>

<c:if test="${check==0}">
	<script>
		alert("회원 탈퇴에 실패하였습니다!\n 탈퇴하시려면 비밀번호를 정확히 입력해주세요!")
		history.go(-1)
	</script>
</c:if>

<c:if test="${check==1}">
	<script>
		alert("WaterMelon 회원정보를 삭제하였습니다.")
	</script>
	<meta http-equiv="Refresh" content="0;url=/WaterMelon/sign.water">
</c:if>