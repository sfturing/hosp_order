<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天津市医院预约挂号</title>
<%
	/********** 保存网站的基本路径 ***********/
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//将该路径地址缓存到 session中 ,例如：http://localhost:8090/tjnu_ssh_1128/
	session.setAttribute("mybasePath", basePath);
%>
<!-- CSS -->
<jsp:include page="../include/headtag.jsp" />
<!-- <link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500"> -->
<link rel="stylesheet"
	href="${mybasePath}assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${mybasePath}assets/css/form-elements.css">
<link rel="stylesheet" href="${mybasePath}assets/css/style.css">
</head>
<body>
	<jsp:include page="../include/head.jsp" />
	<jsp:include page="../include/menu.jsp" />
	<div id="page-wrapper" style="margin-top: 50px;">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12 text-left">
					<h3>意见反馈</h3>
				</div>
			</div>
			<!-- /. ROW  -->
			<hr />


			<div class="form-group">
				<form class="form-search form-horizontal" id="feedbackForm"
					action="/ssm_pro/feedBackInfo" method="post">
					<input type="hidden" value="${userInfo.userId }" name="userId"
						id="userId">
					<div class="col-lg-12">
						<textarea class="form-control" rows="3" id="content" name="content"
							style="margin: 0px -6.8375px 0px 0px; width: 560px; height: 250px;"
							placeholder="感谢您的反馈" required></textarea>
					</div>
				</form>
				<div class="col-lg-8 text-center" style="margin-top: 7px;">
					<button onclick="feedback()" class="btn btn-primary btn-lg">提交反馈</button>
				</div>
			</div>



		</div>
		<!-- /. PAGE INNER  -->

	</div>
	<!-- /. PAGE WRAPPER  -->

</body>
<!-- Javascript -->
<script src="${mybasePath}assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${mybasePath}assets/bootstrap/js/jquery.min.js"></script>
<script src="${mybasePath}assets/js/jquery.backstretch.min.js"></script>
<script type="text/javascript">
	function feedback() {
		var userId = $("#userId").val();
		if (userId == "") {
			alert("请登录后反馈！");
			return false;
		}
		$("#feedbackForm").submit();
		return false;
	}
</script>
</html>