<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="notice.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check==1}">
	<script>
          alert("글이 삭제되었습니다!")
	</script>
	<meta http-equiv="Refresh"  content="0;url=/WaterMelon/notice.water?pageNum=${pageNum}&role=${role}">
</c:if>
<c:if test="${check!=1}">
	<script>
          alert("비밀번호가 맞지않습니다. \n다시 입력해주세요!")
          history.go(-1)
	</script>
</c:if>

