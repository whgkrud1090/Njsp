<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//url의 리소스를 이용하여 디스크의 물리적 위치를 확인하는 메소드
	// /css/blog.css --> 물리적인 경로를 구해주는 메소드
	String blogCssPath = application.getRealPath("/css/blog.css");
	
	File file = new File(blogCssPath);
	
	FileInputStream fis = new FileInputStream(file);
	InputStreamReader isr = new InputStreamReader(fis);
	
	char[] buffer = new char[512];
	
	int len = 0 ;
	
	while( (len = isr.read(buffer, 0, 512)) != -1){
		out.write(buffer);
	}
	
	isr.close();
	fis.close();
	
%>

	blogCssPath : <%=blogCssPath %><br>
 