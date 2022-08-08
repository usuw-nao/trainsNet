<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おとな個人情報</title>
</head>
<body>
	<h1>登録情報</h1>
	<table border="3">

		<tr>
			<th>ID</th>
			<td><c:out value="${adult.id }" /></td>
		</tr>


		<tr>
			<th>名前</th>
			<td><c:out value="${adult.name }" /></td>
		</tr>
		<tr>
			<th>住所</th>
			<td><c:out value="${adult.address }" /></td>
		</tr>
		<tr>
			<th>年齢</th>
			<td><c:out value="${adult.age }" /></td>
		</tr>
		<tr>
			<th>メールアドレス</th>
			<td><c:out value="${adult.email }" /></td>
		</tr>
		<tr>
			<th>イベント参加回数</th>
			<td><c:out value="${adult.ivent}" /></td>
		</tr>
		<tr>
			<th>保有ポイント</th>
			<td><c:out value="${adult.point}" /></td>
		</tr>
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
		<tr>
			<th>ニックネーム</th>
			<td><c:out value="${adult.nickName}" /></td>
		</tr>
		<tr>
			<th>ログインID</th>
			<td><c:out value="${adult.login}" /></td>
		</tr>
		<tr>
			<th><a href="AdultUpdate">会員情報の変更</a></th>
		</tr>
		<tr>
			<th><a href="deleteAdult?id=<c:out value="${adult.id }" />">会員情報の削除</a>
			</th>
		</tr>
	</table>


	<p>
		<a href="AdultLogin">ログイン</a>画面に戻る
	</p>
	<p>
		<a href="AdultMypage">マイページ</a>
	</p>
</body>
</html>