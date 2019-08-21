<%-- <%@ page language="java" contentType="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" --%>
<%--      pageEncoding="UTF-8"%>  --%>
     
<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.IUserService"%>
<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.repository.UserDao"%>
<%@page import="kr.or.ddit.user.repository.IUserDao"%>
 <%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8" 
     pageEncoding="UTF-8"%> 
<%
	//response.setHeader("content-type, value)
	//response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Insert title here</title>
</head>
<body>
<%
	response.setHeader("Content-Disposition", "attahchement; filename=line.xls");
	
	//response.setHeader("Content-Disposition", "attahchement; filename=line.xlsx");
	IUserService userService = new UserService();
	List<User> userList = userService.getUserList();
	System.out.println("userList : " + userList);
%>
<table>
	<tr>
		<th>이름</th>
		<th>나이</th>
	</tr>
	<%
		for(User userVo : userList){
	%>
		<tr>
			<td><%=userVo.getUserNm() %></td>
			<td></td>
		</tr>
	<%} %>
	
</table>
</body>
</html>




