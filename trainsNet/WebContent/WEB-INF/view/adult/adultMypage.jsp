<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おとなマイページ</title>
</head>
<body>
	<h1>ようこそ</h1>
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
			<input type="hidden" name="id" value="${adultQuiz.id}">

			<p>
				<input type="submit" value="決定">
			</p>
		</c:forEach>
	</form>



	<p>
		<a href="AdultInf">個人情報確認・変更</a>
	</p>
	<p>
		<a href="AdultRange">定期の範囲</a>
	</p>
	<p>
		<a href="IventTop">イベント</a>
	</p>
	<p>ポイント</p>

	<p>新幹線予約</p>
	<p>
		<a href="AdultLogout">ログアウト</a>
	</p>



</body>
</html>