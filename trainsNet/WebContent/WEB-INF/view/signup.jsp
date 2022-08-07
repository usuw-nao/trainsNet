<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>

</head>
<body>
	<h1>新規登録</h1>
	<form action="" method="post">

		<p>
			名前<input type="text" name="name" placeholder="名前" />
		</p>
		<p>
			ニックネーム<input type="text" name="nick_name" placeholder="ニックネーム" />
		</p>
		<p>
			年齢<input type="number" name="age" placeholder="年齢" />
		</p>
		<p>
			住所<input type="text" name="address" placeholder="住所" />
		</p>
		<p>
			メールアドレス<input type="email" name="email" placeholder="email" />
		</p>
		<p>
			タイプ(大人▶︎1：こども▶︎2) <input type="number" min="1" max="2" name="type_id" />
		</p>
		<p>
			ログインID<input type="text" name="login_id" placeholder="ログインID" />
		</p>
		<p>
			パスワード<input type="password" name="login_pass" placeholder="パスワード">
		</p>

		<p>
			パスワード確認用 <input type="password" name="confpass" placeholder="パスワード確認" />
		</p>
		<p>
			<input type="submit" value="新規登録">
		</p>
		<p></p>

	</form>

</body>
</html>