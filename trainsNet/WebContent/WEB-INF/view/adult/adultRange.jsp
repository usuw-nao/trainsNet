<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>定期の範囲</title>
</head>
<body>
	<h1>定期の情報</h1>
	<p>${adult.name }さんの定期</p>
	<table border="2">
		<tr>
			<th>定期範囲</th>
			<td><c:out value="${adult.distance}" /></td>
		</tr>
		<tr>
			<th>定期開始日</th>
			<td><c:out value="${adult.startDate}" /></td>
		</tr>
		<tr>
			<th>定期終了日</th>
			<td><c:out value="${adult.endDate}" /></td>
		</tr>

	</table>
	<p>距離を調べる</p>




	<p>
		<a href="AdultMypage">マイページ</a>
	</p>
</body>
</html>