<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベント情報トップ</title>
</head>
<body>
	<h1>イベント情報</h1>
	<h2>お知らせ</h2>
	<br>
	<h2>開催予定イベント</h2>
	<table border="1">
		<tr>
			<th>イベント名</th>
			<th>日にち</th>
		</tr>
		<c:forEach items="${iventList}" var="ivent">

			<tr>
				<td><a href="iventid=?">u<c:out value="${ivent.name }" /></a></td>
				<td><c:out value="${ivent.day }" /></td>
			</tr>
		</c:forEach>

	</table>
	<p>
		<a href="adultMypage">マイページに戻る</a>
	</p>



</body>
</html>