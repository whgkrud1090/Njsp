<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

before setTimeZone : <fmt:formatDate value="${dt }" pattern="yyyy-MM-dd HH:mm:ss"/><br>
<fmt:setTimeZone value="Asia/Bangkok"/>
after setTimeZone : <fmt:formatDate value="${dt }" pattern="yyyy-MM-dd HH:mm:ss"/><br>
<table>
	<thead>
		<tr>
			<th>timeZone Id</th>
		</tr>
	</thead>
	<tbody>
	<%-- timeZoneList : String[], time : String --%>
	<c:forEach items="${timeZoneList }" var="timeZone">
		<tr>
			<td>${timeZone }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>