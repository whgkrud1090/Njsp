<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
// DB작업에 필요한 객체 변수 선언
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;  // 쿼리문이 select문일 경우에만 필요

	Class.forName("oracle.jdbc.driver.OracleDriver");

	//start
	long start = System.currentTimeMillis();
	
	for(int i = 0; i < 20; i++){
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sem","java");
		String sql = "select * from lprod";  // 실행할 SQL문장
		stmt = conn.createStatement();  // Statement객체 생성
		rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			out.println("lprod_id : " + rs.getInt("lprod_id") + "<br>");
			out.println("lprod_gu : " + rs.getString(2) + "<br>"); // 숫자는 컬럼 번호를 의미한다.
			out.println("lprod_nm : " + rs.getString("lprod_nm") + "<br>");
			out.println("-----------------------------<br>" );
		}
	
		rs.close();
		stmt.close();
		conn.close();
	}
	//end
	long end = System.currentTimeMillis();
	out.println( "end - start :" + (end-start) + "ms <br>"); 
%>	
</body>
</html>










