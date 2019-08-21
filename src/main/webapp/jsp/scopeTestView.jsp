<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>scope test</h2>
<form action="<%=request.getContextPath() %>/scopeTest" method="post">
request : <input type="text" name="reqParam" value="brown" /> <br>
session : <input type="text" name="sessionParam" value="sally" /> <br>
application : <input type="text" name="applicationParam" value="cony" /> <br>
<input type="submit" value="전송"/>
</form>
</body>
</html>










