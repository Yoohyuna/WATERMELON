<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${success==true}">
	<script>
		alert("회원 수정에 성공하였습니다!")
	</script>
	<meta http-equiv="Refresh"
		content="0;url=/WaterMelon/accountList.water?id=<%=request.getAttribute("id")%>">
</c:if>

<c:if test="${success==false}">
	<script>
		alert("회원 수정에 실패하였습니다!\n모든 정보를 다시 입력해 주세요!")
		history.go(-1)
	</script>
</c:if>
