<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%
	String Directory = (String) request.getAttribute("Directory");
%>
<title>:: JAVASCRIPT 음악 재생 ::</title>
<script type="text/javascript">
	// Audio 객체생성 ①
	// var audio = new Audio('./lucky.mp3');

	// Audio 객체생성 ②
	var audio = new Audio();
	audio.src = '<%=Directory%>';
</script>
</head>
<body>
	<input type="button" onClick="audio.play();" value="PLAY" />
	<input type="button" onClick="audio.pause();" value="PAUSE" />
	<input type="number" onChange="audio.currentTime=this.value" />
	<input type="number" onChange="audio.volume=this.value" />
</body>
</html>