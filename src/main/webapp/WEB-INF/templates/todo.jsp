<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>やることリスト</title>
</head>
<body>
	<form action="list" method="POST">
		タイトル：<input type="text" name="title"> 優先度：<input type="text"
			name="priority"> 
		<button>追加</button>
	</form>
	<form action="clear" method="GET">
		<button>Clear</button>
	</form>
	<hr>
	<h1>やること一覧</h1>
	<%-- @Namedのついたクラス名の先頭文字を小文字にした名前toDosで参照 --%>
	<c:forEach var="todo" items="${toDos}">
		<div>${todo.title} [${todo.priority}]</div>
	</c:forEach>
</body>
</html>
