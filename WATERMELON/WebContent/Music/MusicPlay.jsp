<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String dir = (String) request.getAttribute("Directory");
%>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="/WaterMelon/Music/js/WaterPlayer.js"></script>
<script>
$(function() {
	player('<%=dir%>');
		$('#ppbutton').click(function() {
			if ($('.play').attr('class') == 'play') {
				$('.play').attr('class', 'pause');
				waterPlay();
			} else if ($('.pause').attr('class') == 'pause') {
				$('.pause').attr('class', 'play');
				waterPause();
			}
		})
	})
</script>
<c:if test="${1<=t_ID<=45}">
	<a id="ppbutton" class="play" href="#"><img
		src="/WaterMelon/assets/images/svg/play-2.svg" height="25px"
		weight="25px" /></a>
</c:if>

<c:if test="${next!=null}">
	<script>
		alert("WaterMelon")
	</script>
</c:if>

<c:if test="${pre!=null}">
	<script>
		alert("WaterMelon")
	</script>
</c:if>
