<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/updateform.jsp</title>
</head>
<body>
<h3>글정보 수정 페이지</h3>
<form action="update.do" method="post">
	<input type="hidden" name="num" value="${dto.num } "/>
	번호 <input type="text" value="${dto.num }" disabled /><br/>
	작성자 <input type="text" name="writer" value="${dto.writer }" /><br/>
	제목 <input type="text" name="title" value="${dto.title }" /><br/>
	글내용 <textarea name="content" id="content" cols="30" rows="10">${dto.content }</textarea><br/>
	<button type="submit">수정확인</button>

</body>
</html>