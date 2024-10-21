<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.peisia.spring.mi.vo.GuestVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 - 글 목록</title>
<link rel="stylesheet" href="/resources/common.css" >
</head>
<body>
<h1>방명록</h1>
<h2>글목록</h2>
총 글 수 :${count} , 총 페이지 수 :${totalPageCount} , 블럭 당 페이지 수: ${pagesPerBlock} ,
 현재 블럭: ${currentBlock} <br>
블럭 시작 페이지: ${blockStartPage} , 블럭 끝 페이지: ${blockEndPage} , 
블럭 총 수 : ${blockCount}<br>
이전 블럭 가능: ${hasBlockPrev} , 다음 블럭 가능: ${hasBlockNext} 
<hr>
<table>
	<tr>
		<td>번호</td>
		<td>내용</td>
	</tr>
<c:set var="arr" value="${list}" />
		
<c:forEach var="i" items="${arr}">
<tr><td>${i.bno}</td><td>${i.btext}</td></tr>	
</c:forEach>

</table>
<!-- 이전 블럭 링크 -->
<c:if test="${hasBlockPrev}" >
	<a href="/guest/getList?currentPage=${prevPage}">이전</b>
</c:if>

<!-- 페이지 링크 -->
<c:forEach var="i" begin="${blockStartPage}" end="${blockEndPage}">
[<a href="/guest/getList?currentPage=${i}">${i}<a>]	
</c:forEach>

<!-- 다음 블럭 링크 -->
<c:if test="${hasBlockNext}" >
	<a href="/guest/getList?currentPage=${nextPage}">다음</b>
</c:if>

<hr>

<!-- [ ] 글쓰기 페이지로 이동 -->
<a href="/guest/write">새글 쓰기</a>

</body>
</html>