<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
@import
	url('http://cdn.gbtags.com/twitter-bootstrap/3.2.0/css/bootstrap.css');

body {
	font-family: 'microsoft yahei', Arial, sans-serif;
	margin: 0;
	padding: 0;
}
</style>
<title>登录</title>
</head>
<body>
	<div id="loginModal" class="modal show">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="text-center text-primary">用户登录</h1>
				</div>
				<div class="modal-body">
					<form action="" class="form col-md-12 center-block">
						<div class="form-group">
							<input type="text" class="form-control input-lg"
								placeholder="身份证号">
						</div>
						<div class="form-group">
							<input type="password" class="form-control input-lg"
								placeholder="登录密码">
						</div>
						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block">立刻登录</button>
							<span><a href="#">找回密码</a></span> <span><a href="#"
								class="pull-right">注册</a></span>
						</div>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>

</body>
</html>