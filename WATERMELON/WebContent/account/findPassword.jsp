<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String id = (String) request.getAttribute("id");
String password = (String) request.getAttribute("password");
%>
<c:if test="${password!=null}">
	<script>
	alert("찾고계신 아이디의 비밀번호는 <%=password%> 입니다.");
	</script>
	<meta http-equiv="Refresh"
		content="0;url=/WaterMelon/sign.water?id=<%=id%>&password=<%=password%>">
</c:if>

<c:if test="${password==null}">
	<script>
	alert("입력하신 정보에 해당하는 비밀번호를 찾을 수 없습니다.");
	history.go(-1);
	</script>
</c:if>