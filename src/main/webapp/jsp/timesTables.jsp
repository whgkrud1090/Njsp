<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td { border : 1px solid pink;
</style>
</head>
<body>
	<table>
		<%for(int i = 1; i <= 9; i++ ){ %>
			<tr>
				<%for(int j = 2; j <= 9; j++ ){ %>
					<td><%=j %>*<%=i %>=<%=j*i %></td>
				<%} %>
			</tr>
		<%} %>
	</table>
</body>
</html>




