<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${id!=null}">
	<script>
	alert("찾고계신 아이디는 <%=request.getAttribute("id")%> 입니다.");
	history.go(-1);
	</script>
</c:if>

<c:if test="${id==null}">
	<script>
	alert("입력하신 정보에 해당하는 아이디를 찾을 수 없습니다.");
	history.go(-1);
	</script>
</c:if>