<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>el attribute</h2>
	elScope : ${elScope } <br>
	
	<h2>el parameter</h2>
	표현식 param : <%=request.getParameter("req") %><br>
	el param : ${param.req} <br>
	
	<h2>el cookie</h2>
	<%
		Cookie[] cookies = request.getCookies();
		String cookieValue = "";
		for(Cookie cookie : cookies){
			if("userId".equals(cookie.getName()))
				cookieValue = cookie.getValue();
		}
	%>
	표현식 cookie : <%=cookieValue %> <br>
	el cookie : ${cookie.userId.value } <br>
</body>
</html>











