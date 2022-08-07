<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="domain.AdultQuiz"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クイズ</title>
</head>
<body>
	<h1>１日1回クイズに答えて１０ポイント</h1>
	<form action="" method="post">
		<c:forEach items="${AQList}" var="adultQuiz">
			<p>
				Q!
				<c:out value="${adultQuiz.content}" />
			</p>
			<br>
			<p>
			<input type="radio" name="choice" value="choice1">
			<c:out value="${adultQuiz.choice1}" />
			</p>
			<p>
			<input type="radio" name="choice" value="choice2">
			<c:out value="${adultQuiz.choice2}" />
			</p>


			<select name="choice" size="2">

				<option value="<c:out value="${adultQuiz.choice1}"/>">
				<option value="<c:out value="${adultQuiz.choice2}"/>">
			</select>
		</c:forEach>
		<input type="submit" value="決定">
	</form>

</body>
</html>