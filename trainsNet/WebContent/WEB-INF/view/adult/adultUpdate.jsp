<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報の編集</title>
</head>
<body>
	<h1>登録情報の変更</h1>
	<p>${adult.name }さん</p>

	<form action="" method="post">




		<p>
			ログインID <input type="text" name="login">
		</p>
		<p>
			ニックネーム <input type="text" name="nickName">
		</p>

		<p>
			メールアドレス <input type="email" name="email">
		</p>
		<p>
			住所 <input type="text" name="address">
		</p>
		<input type="hidden" name="id">



		<p>
			<input type="submit" value="保存する">
		</p>
	</form>
	<a href="AdultInf">戻る</a>


</body>
</html>