<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
<h3>인덱스 페이지입니다.</h3>
<p><a href="board/list.do">게시판보기</a></p>

<c:forEach var="tmp" items="${news }">
	<li>${tmp }</li>
</c:forEach>
</body>
</html>