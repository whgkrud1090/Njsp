<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String number = request.getParameter("number");
	String number2 = request.getParameter("number2");
	
	int numberInt = Integer.parseInt(number);
	int number2Int = Integer.parseInt(number2);
	
	int sumResult = 0;
	for(int i = numberInt; i <= number2Int; i++)
		sumResult += i;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	result : <%=sumResult %>
</body>
</html>