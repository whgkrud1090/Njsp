<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>jstl fmt</h2>
<c:set var="userId" value="brown"/>
<fmt:bundle basename="kr.or.ddit.msg.message">	<%--message_국가_언어.properties --%>
	GREETING : <fmt:message key="GREETING"/><br>
	VISITNG : <fmt:message key="VISITNG">
			   <fmt:param value="${userId }"/>
			  </fmt:message>
</fmt:bundle>
<br>
<br>
<fmt:setLocale value="en"/>
<%--이 밑으로는 영어로 출력된다. --%>
<fmt:bundle basename="kr.or.ddit.msg.message">	<%--message_국가_언어.properties --%>
	GREETING : <fmt:message key="GREETING"/><br>
	VISITNG : <fmt:message key="VISITNG">
			   <fmt:param value="${userId }"/>
			  </fmt:message>
</fmt:bundle>
<br>
<br>
<fmt:setLocale value="zh"/>
<%--이 밑으로는 중국어로 출력된다. --%>
<fmt:bundle basename="kr.or.ddit.msg.message">	<%--message_국가_언어.properties --%>
	GREETING : <fmt:message key="GREETING"/><br>
	VISITNG : <fmt:message key="VISITNG">
			   <fmt:param value="${userId }"/>
			  </fmt:message>
</fmt:bundle>

<%-- <fmt:setLocale value="en"/> value에 국가코드를 입력해주면
       그 국가의 언어로 변경된다.
	  (미리 properties에 지정해준값으로)
--%>


<%--<fmt:bundle> : 출력할 메시지를 담고 있는 리소스 번들 지정
		* <fmt:message> 태그가 bundle 태그 안에 기술 
		
	<fmt:message> : 출력하고자하는 code 지정
	
	<fmt:param> : message에 파라미터가 있는 경우 전달
--%>

<h2>fmt setBundle</h2>
<%-- <fmt:setBundle basename=""/> --%>
<%-- 불러온 bundle을 var에 담아 출력 --%>
<fmt:setLocale value="ko"/>
<fmt:setBundle basename="kr.or.ddit.msg.message" var="msg"/>
GREETING : <fmt:message key="GREETING" bundle="${msg }"/><br>
VISITNG : <fmt:message key="VISITNG" bundle="${msg }">
 			<fmt:param value="${userId }"/>
		  </fmt:message>

<h2>fmt number</h2>
<c:set var="num" value="1000000.100"/>
<fmt:setLocale value="ko"/>
ko : <fmt:formatNumber value="${num }"/><br>

<fmt:setLocale value="de"/>
<%-- var를 설정해주면 value값을 var에 지정해준다는 뜻이다. --%>
de : <fmt:formatNumber value="${num }"/><br>

<h2>fmt parseNumber</h2>
<fmt:setLocale value="ko"/>
<%-- 문자열을 숫자로 변환 --%>
<fmt:parseNumber value="1,000,000" var="koNum"/>
not patten parseNumber : ${koNum }<br>


<h2>fmt formatDate</h2>
<%-- 데이트 객체를 포메팅된 문자열로 반환 --%>
formatDate : <fmt:formatDate value="${dt }" pattern="yyyy-MM-dd HH:mm:ss"/><br>
no patten formatDate : <fmt:formatDate value="${dt }"/><br>
</body>
</html>