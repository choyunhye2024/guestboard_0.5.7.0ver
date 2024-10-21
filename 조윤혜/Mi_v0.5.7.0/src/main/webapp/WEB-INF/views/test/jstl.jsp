<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<h1>jstl 연습</h1>
<%
String str1 = "고양이"; 
Date now = new Date();
request.setAttribute("now", now);

for(int i=0;i<5;i++){
	
}


%>
<c:out value="<%=str1 %>" default="야옹이" /><br>

<c:forEach var="num" begin="0" end="5">
	<b>고양이</b>
</c:forEach>

<%

	String animals[] = {"개","고양이","토끼"};	

/* 	for(int i=0;i<animals.size();i++){ */
	for(String x : animals){
%>
		<%=x%>
<%		
	}
%>	

<c:set var="arr" value="<%=animals%>" />
		
<c:forEach var="i" items="${arr}" begin="0" end="2">
	${i}
</c:forEach>
<c:forEach var="i" items="${arr}">
	${i}
</c:forEach>

현재 시간: <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" />

</body>
</html>
