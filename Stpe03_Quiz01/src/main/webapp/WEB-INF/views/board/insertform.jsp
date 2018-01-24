<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/insertform.jsp</title>
</head>
<body>
<h3>글작성 페이지입니다.</h3>
<form action="insert.do" method="post">
	<label for="writer">글쓴이</label>
	<input type="text" name="writer" id="writer" /></br>
	<label for="title">제목</label>
	<input type="text" name="title" id="title" /></br>
	<label for="content">글내용</label>
	<textarea name="content" id="content" cols="30" rows="10"></textarea></br>
	<button type="submit">글작성하기</button>
</form>

</body>
</html>