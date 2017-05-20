<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户登录</title>
<jsp:include page="../include/headtag.jsp" />
<!-- CSS -->
<!-- <link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500"> -->

<link rel="stylesheet"
	href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">

<style>
input:-webkit-autofill {
	-webkit-box-shadow: 0 0 0px 1000px white inset;
	border: 1px solid #CCC !important;
}
</style>
</head>

<body>
	<jsp:include page="../include/head.jsp" />
	<jsp:include page="../include/menu.jsp" />
	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<!-- <div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1></h1>
						<div class="description">
							<h3 style="color: #96968E;">天津市医院预约挂号系统</h3	>
						</div>
					</div>
				</div>  -->
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3 style="color: #969696;">用户登录</h3>
								<p>请输入邮箱及密码</p>
							</div>
							<div class="pull-right-bottom">
								<p class="text-danger"
									style="position: absolute; right: 60px; bottom: 300px"
									id="errorTip">${error}</p>
							</div>

						</div>

						<div class="form-bottom">
							<form role="form" action="login" method="post" class="login-form">
								<div class="form-group col-xs-12">
								<label class="sr-only" for="userEmail">userEmail</label>邮箱(*):<input
									style="font-weight: bold" type="text" name="userEmail"
									id="userEmail" class="form-control input-control clearfix"
									required onkeyup="isCheckEmail()" /><span id="emailTip"></span>
							</div>
								<div class="form-group col-xs-12">
									<label class="sr-only" for="userPassword">Password</label>密码(*):
									<input type="password" name="userPassword" placeholder="用户密码"
										class="form-password form-control" id="userPassword"
										style="font-weight: bold" required onkeyup="isClearTip()">
								</div>
								<div class="form-group col-xs-12">
									<button type="submit" class="btn">立即登录</button>
								</div>
							</form>
							<span><a href="findPassword">找回密码</a></span> <span><a
								href="sign" class="pull-right">用户注册</a></span>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>


	<!-- Javascript -->
	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/scripts.js"></script>

	<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->
<script type="text/javascript">
		function isCheckEmail() {
			var email = document.getElementById("userEmail").value;
			document.getElementById("errorTip").innerHTML = "";
			if (email != "") {
				var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
				isok = reg.test(email);
				if (isok) {
					document.getElementById("emailTip").innerHTML = "邮箱格式正确";
					document.getElementById("btn").disabled = false;
				} else {
					document.getElementById("btn").disabled = true;
					document.getElementById("emailTip").innerHTML = "邮箱格式不正确";
				}
			} else {
				document.getElementById("emailTip").innerHTML = "";
			}
		}
	</script>
	<script type="text/javascript">
		function isClearTip() {
			document.getElementById("errorTip").innerHTML = "";
		}
	</script>

</body>

</html>