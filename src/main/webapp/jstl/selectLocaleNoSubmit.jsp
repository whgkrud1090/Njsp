<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="${cp }/js/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){
	
	//select box option selected 설정
	$("select[name=locale]").val('${locale}');
	
	$("select[name=locale]").on("change", function(){
		$("#frm").submit();
	});
});
</script>
</head>
<body>

<form id="frm" action="${cp }/selectLocale" method="get"> 
	<select name="locale">
		<option value="ko">한국어</option>
		<option value="en">english</option>
		<option value="zh">中国话</option>
	</select>
</form>	

<fmt:setLocale value="${locale }"/>
<fmt:setBundle basename="kr.or.ddit.msg.message" var="msg"/>
<fmt:message key="GREETING" bundle="${msg}"/> <br>
</body>
</html>






