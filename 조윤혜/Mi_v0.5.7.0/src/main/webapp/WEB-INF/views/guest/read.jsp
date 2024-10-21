<%@page import="com.peisia.spring.mi.vo.GuestVO"%>
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
/* 	GuestVO read = (GuestVO)request.getAttribute("read");
	long bno = read.getBno();
	String btext = read.getBtext(); */
%>	

글 읽기
<hr> 
<%-- 글번호:<%=bno %> --%>
<hr> 
글번호: ${read.bno}
<hr> 
<%-- 글내용:<%=btext %> --%>
<hr> 
글내용: ${read.btext}
<hr>
<!-- [ ] 글삭제로 이동. 글번호를 넘겨야함. -->
<a href="/guest/del?bno=${read.bno}">글 삭제</a>
<!-- [ ] 글 수정으로 이동. 글번호를 넘겨야함. -->
<a href="/guest/modify?bno=${read.bno}">글 수정</a>
<!-- [ ] 글 리스트로 이동. -->
<a href="/guest/getList">글 리스트</a>

</body>
</html>