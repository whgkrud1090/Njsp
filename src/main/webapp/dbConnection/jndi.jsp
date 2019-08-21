<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	InitialContext context = new InitialContext();
	DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracleDB");
	//BasicDataSource ds = (BasicDataSource)application.getAttribute("ds");
	
	long start = System.currentTimeMillis();
	for(int i = 0; i <20; i ++){
		Connection connection = ds.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from lprod");
		
		while(rs.next()){
			out.println( "lprod_id : " + rs.getInt(1) + "<br>");
			out.println( "lprod_gu : " + rs.getString(2) + "<br>");
			out.println( "lprod_nm : " + rs.getString(3) + "<br>");
			out.println("-----------------------------<br>" );
		}
		
		rs.close();
		stmt.close();
		connection.close();
	}
	
	long end = System.currentTimeMillis();
	out.println("end - start : " + (end-start) + "ms <br>");
%>
</body>
</html>









