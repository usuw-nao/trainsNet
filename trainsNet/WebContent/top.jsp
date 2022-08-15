<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>トップ</title>

<script type="text/javascript"
	src="http://express.heartrails.com/api/express.js">

</script>
<script type="text/javascript"
	src="http://express.heartrails.com/api/express.js">

</script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>

	<div class="container-fluid header-outer">
		<header class="text-light py-3">
			<h1 class="display-1">TレインNット【 TN 】</h1>
			<p class="lead">電車でどこいく？</p>
			<nav class="navbar navbar-dark bg-dark">
				<div class="container">
					<a class="navbar-brand" href="#">My Weather</a>
				</div>
			</nav>
		</header>
	</div>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
		<div class="container">
			<a class="navbar-brand" href="">Train-Net</a>
			<button class="navbar-toggler" data-bs-toggle="collapse"
				data-bs-target="#menu">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="menu">
				<ul class="navbar-nav">
					<li class="nav-item"><a href="" class="nav-link active">後でなんかのリンク？</a></li>
					<li class="nav-item"><a href="search.html" class="nav-link">Search後でなんか？？</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container my-4">
		<main>
			<div class="row">
				<div class="col-lg-8">
					<h2>メニュー</h2>
					<div class="row">
						<div class="animal col-md-6 col-lg-4 mb-4">
							<img class="img-thumbnail w-100" src="images/animal1.jpg">
							<h3>大人はこちら</h3>
							おとなのひと<a href="AdultLogin" class="btn btn-primary">ログイン</a>
						</div>

						<div class="animal col-md-6 col-lg-4 mb-4">
							<img class="img-thumbnail w-100" src="images/animal4.jpg">
							<h3>子どもの人はこちら</h3>
							<p>
								こどものひと<a href="" class="btn btn-primary">ろぐいん</a>
							</p>
							<div class="alert alert-danger">申し訳ありません。 現在、子どもログイン工事中です。
							</div>
						</div>

						<div class="animal col-md-6 col-lg-4 mb-4">
							<img class="img-thumbnail w-100" src="images/animal2.jpg">
							<h3>新規登録はこちらから</h3>
							<a href="Signup" class="btn btn-primary">新規登録</a>
						</div>

						<div class="animal col-md-6 col-lg-4 mb-4">
							<img class="img-thumbnail w-100" src="images/animal3.jpg">
							<h3>電車の発車確認</h3>
							<a href="" class="btn btn-primary">電車発車確認</a>
						</div>



					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.col -->
			<div class="col-lg-4">
			<br><br>
				<h2>Infomation~お知らせ~</h2>
				<p>現在お知らせはございません</p>



				<body onload="HRELoadArea('area', 'line', 'station');">
					<select id="area" name="area" onchange="HREOnChangeArea();">
						<option value="エリアを選択してください">エリアを選択してください</option>
					</select>
					<select id="line" name="line" onchange="HREOnChangeLine();">
						<option value="路線を選択してください">路線を選択してください</option>
					</select>
					<select id="station" name="station">
						<option value="駅を選択してください">駅を選択してください</option>
					</select>
			</div>
	</div>
	<!-- /.row -->
	</main>
	<br><br>
	<!--Footer IN-->
	<div id="footer">
		<ul class="footer">
			<li>
				<div class="footer_title"
					onclick="location.href='https://www.starbooks.jp/'"
					style="cursor: pointer;">TrainNet</div>
				<div class="footer_cn_login">
					<a href="https://www.starbooks.jp/note/open.php">大人会員様ログイン</a>
				</div>
				<div class="footer_cn_login">
					<a href="https://www.starbooks.jp/inquiry.php">子ども会員様ログイン</a>
				</div>
			</li>
			<li>
				<div class="footer_title">電車検索</div> <a
				href="https://e.starbooks.jp/index/index.php">TNSearch</A><br>
				<a href="https://www.starbooks.jp/store/index/">料金表</A><br> <a
				href="https://www.starbooks.jp/doujin/">？？？</A><br> <a
				href="https://www.starbooks.jp/goods/">？？？</A><br>
			</li>
		</ul>
	</div>
	<!--Footer OUT-->




	<div class="container-fluid bg-dark text-light text-center pt-4 pb-2">
		<footer>
			<p>
				<small>&copy Train_Net：TN All Rights Reserved.</small>
			</p>
		</footer>
	</div>
	<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>

