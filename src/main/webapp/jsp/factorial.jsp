<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 선언부 : 메소드나 변수를 선언  -->    
<%!

Map<Integer, Integer> facMap = new HashMap<Integer, Integer>();

public int factorialLoop(int fac){
	int result = 1;
	for(int i = fac; i > 1; i--)
		result *=i;
	return result;
}

public int factorial(int fac){
	if(fac < 0)
		return 0;
	else if(fac <= 1)
		return 1;
	else{
		System.out.println("call");
		return fac * factorial(fac-1);
	}
}

public int factorialMemo(int fac){
	if(fac < 0)
		return 0;
	else if(fac <= 1)
		return 1;
	else{
		int result = facMap.getOrDefault(fac, 0);
		if(result != 0)
			return result; //return fac;
		else{
			int facResult = factorialMemo(fac-1);
			facMap.put(fac-1, facResult);
			
			System.out.println("callMemo");
			return fac * factorialMemo(fac-1);	
		}
		
	}
}


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	<h1>factorial</h1> -->
<%-- 	<%for(int i = 0 ; i <= 8; i++){ %> --%>
<%-- 		factorial(<%=i %>) : <%=factorial(i) %> <br> --%>
<%-- 	<%} %> --%>
	
	<h1>factorialMemo</h1>
	<%for(int i = 0 ; i <= 8; i++){ %>
		factorialMemo(<%=i %>) : <%=factorialMemo(i) %> <br>
	<%} %>
</body>
</html>







