<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>servlet</h2>
	<%
		out.write("application.getServerInfo() : " + application.getServerInfo() + "<br>");
		out.write("application.getContextPath() : " + application.getContextPath()+ "<br>");
		out.write("application.getMajorVersion() : "  +  application.getMajorVersion()+ "<br>");
		out.write("application.getMinorVersion() : " + application.getMinorVersion()+ "<br>");
		out.write("application.getServletContextName() : " +  application.getServletContextName()+ "<br>");
	%>
	
	<h2>jsp</h2>	
	application.getServerInfo() : <%=application.getServerInfo() %> <br>
	application.getContextPath() : <%=application.getContextPath()%><br> 
	application.getMajorVersion() : <%=application.getMajorVersion()%><br>
	application.getMinorVersion() : <%=application.getMinorVersion()%> <br>
	application.getServletContextName() : <%=application.getServletContextName()%> <br>
	
	<h2>initParam</h2>
	<%
		String admin = application.getInitParameter("ADMIN");
		out.write("admin : " + admin + "<br>");
	%>
	
</body>
</html>











