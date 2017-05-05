<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户登录</title>
<jsp:include page="../include/headtag.jsp" />
<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">
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
				</div> -->
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3 style="color: #969696;">用户登录</h3>
								<p>请输入身份证号及密码</p>
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
									<label class="sr-only" for="userIdenf">身份证号</label>身份证号(*):<input
										type="text" name="userIdenf"
										class="form-username form-control" id="userIdenf" required
										onkeyup="isCheckIdenf()" style="font-weight: bold" /><span
										id="idenfTip"></span>
								</div>
								<div class="form-group col-xs-12">
									<label class="sr-only" for="userPassword">Password</label>密码(*): <input
										type="password" name="userPassword" placeholder="用户密码"
										class="form-password form-control" id="userPassword"
										style="font-weight: bold" required onkeyup="isClearTip()">
								</div>
								<div class="form-group col-xs-12">
									<button type="submit" class="btn">立即登录</button>
								</div>
							</form>
							<span><a href="#">找回密码</a></span> <span><a href="sign"
								class="pull-right">用户注册</a></span>
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
		function isCheckIdenf() {
			var idenf = document.getElementById("userIdenf").value;
			document.getElementById("errorTip").innerHTML = "";
			if (idenf != "") {
				var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
				isok = reg.test(idenf);
				if (!isok) {
					document.getElementById("btn").disabled = true;
					document.getElementById("idenfTip").innerHTML = "身份证格式不正确";
				} else {
					document.getElementById("idenfTip").innerHTML = "<font color='#969696'>身份证格式正确</font>";
					document.getElementById("btn").disabled = false;
				}
			} else {
				document.getElementById("idenfTip").innerHTML = "";
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