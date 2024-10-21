<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/guest/write" method="post">	<!-- todo: http://localhost:8080/guest/write 부분 해결 -->
		<textarea rows="3" name='btext'></textarea>
		<input type="submit" value="글쓰기">
	</form>

</body>
</html>