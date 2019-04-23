<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>공지사항 게시판</title>

<!-- 부트스트랩 -->
<!-- <link rel="stylesheet" type="text/css" href="css/util.css"> -->
<link rel="stylesheet" type="text/css" href="/WaterMelon/notice/css/main.css">
<link href="/WaterMelon/notice/css/bootstrap.min.css" rel="stylesheet">

<!-- a태그 글씨 색 고정 -->
		<style type"text/css"> 
		A:link {text-decoration:none;color:#212529;} 
		A:visited {text-decoration:none; color:#212529;}
		</style>
		
		
	<script>
	</script>
  </head>
<body>
	<div class="logo"><a href="/WaterMelon/demo-03-html/home.jsp"><img src="/WaterMelon/logo.png" /></a></div>
	<div class="container text-center">
		<h1 class="text">공지사항</h1><br>
		<c:if test="${role == 1}" >
		<h4 class="text" style="text-align: right; margin-right: 30px;">
			<a href="/WaterMelon/notice_form.water?role=${role}">글쓰기</a>
		</h4>
		</c:if>
		<!-- 데이터의 유무 -->
		<c:if test="${pgList.count==0}">
			<table class="table">
				<tr>
					<td align="center">게시판에 저장된 글이 없습니다.</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${pgList.count > 0 }">
			<table class="table">
				<thead>
					<tr class="header">
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일</td>
						<td>조회수</td>
					</tr>
				</thead>
				<c:set var="number" value="${pgList.number}" />
				<c:forEach var="notice" items="${noticeList}">
					<tr class="center">
						<td class="row"><c:out value="${notice.n_Num}" /></td>
						<td class="row"><a href="/WaterMelon/content.water?n_Num=${notice.n_Num}&pageNum=${pgList.currentPage}&role=${role}">${notice.n_subject}</td>
						<td class="row">관리자</td>
						<td class="row"><fmt:formatDate value="${notice.writedate}" timeStyle="medium" pattern="yy.MM.dd" /></td>
						<td class="row">${notice.readCount}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<c:if test="${pgList.startPage > pgList.blockSize}">
			<a
				href="/WaterMelon/notice.water?pageNum=${pgList.startPage-pgList.blockSize}&search=${search}&searchtext=${searchtext}&role=${role}">이전페이지</a>
		</c:if>

		<c:forEach var="i" begin="${pgList.startPage}" end="${pgList.endPage}">
			<a href="/WaterMelon/notice.water?pageNum=${i}&search=${search}&searchtext=${searchtext}&role=${role}">
				<c:if test="${pgList.currentPage==i}">
					<button type="button">
						<font color="hotpink"><b>${i}</b></font>
					</button>
				</c:if> <c:if test="${pgList.currentPage!=i}">
					<button type="button">${i}</button>
				</c:if>
			</a>
		</c:forEach>

		<c:if test="${pgList.endPage < pgList.pageCount}">
			<a
				href="/WaterMelon/notice.water?pageNum=${pgList.startPage+pgList.blockSize}&search=${search}&searchtext=${searchtext}&role=${role}">다음페이지</a>
		</c:if>

		<P>
			<br>
			<!-- 검색어 추가(자주 검색이 되는 항목을 잘 선택) 제목,작성자,제목+본문 -->
		<form name="test" action="/WaterMelon/notice.water?">
		<input type="hidden"  name="role" value="${role}">
			<select name="search">
				<option value="n_subject">제목</option>
				<option value="n_content">본문</option>
			</select> <input type="text" size="15" name="searchtext">&nbsp; 
			<input type="submit" value="검색">
		</form>

	</div>

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="/WaterMelon/notice/js/notice.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="/WaterMelon/notice/js/bootstrap.min.js"></script>
</body>
</html>