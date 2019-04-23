<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="accounts.AccountsDAO"></jsp:useBean>
<jsp:useBean id="dto" class="accounts.AccountsDTO"></jsp:useBean>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${loginCheck==true}">
	<%
		request.setCharacterEncoding("UTF-8");
			String id = (String) request.getAttribute("id");
			dto = dao.getAccount(id);
			session.setAttribute("id", id);
	%>
	<script>
	alert("<%=dto.getNickname()%>님 환영합니다!")
	</script>
	<meta http-equiv="Refresh"
		content="0;url=/WaterMelon/demo-03-html/home.jsp">
</c:if>

<c:if test="${loginCheck==false}">
	<script>
	alert("아이디 또는 비밀번호가 일치하지 않습니다. 다시 시도해 주세요!");
	history.go(-1);
	</script>
</c:if>