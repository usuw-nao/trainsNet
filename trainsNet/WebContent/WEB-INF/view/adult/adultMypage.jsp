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
	<h2>問題に答えてポイントGET！</h2>
	<form action="" method="post">
		<p>
			Q!
			<c:out value="${adultQuiz.content}" />
		</p>


		<select name="choice" size="2">

			<option value="<c:out value="${adultQuiz.choice1}"/>">
			<option value="<c:out value="${adultQuiz.choice2}"/>">
		</select>

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
	<p>
		<a href="AdultQuiz">クイズ!</a>
	</p>
	<p>新幹線予約</p>




</body>
</html>