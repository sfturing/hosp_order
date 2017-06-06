<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约挂号</title>
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
				<div class="col-md-12">
					<h3 class="text-left">预约挂号</h3>
				</div>
			</div>
			<hr />
			<div class="panel panel-primary text-left">
				<div class="panel-heading">
					<h3 class="panel-title">医生信息</h3>
				</div>
				<div class="panel-body">
					<div class="col-md-5">
						<div class="col-md-3">
							<img alt="图片加载出现了一些问题" src="${doctorImg }">
						</div>
						<div class="col-md-9">
							<p>医生姓名：${orderRecords.doctorName }</p>
							<p>医院名称：${orderRecords.hospitalName }</p>
							<p>科室名称：${orderRecords.officesName }</p>
						</div>
					</div>
					<div class="col-md-7">
						<p>
							<font color="#eb6864">门诊类型：${orderRecords.officesName }</font>
						</p>
						<p>
							<font color="#eb6864">费用：50元</font>
						</p>
					</div>
				</div>

			</div>
			<div class="panel panel-primary text-left">
				<div class="panel-heading">
					<h3 class="panel-title">时间信息</h3>
				</div>
				<div class="panel-body">
					<div class="col-md-12">
						<div class="col-md-2">
							<h3>${orderRecords.transactDate }</h3>
						</div>
					</div>
					<div class="col-md-12">
						<div class="col-md-10">
							<h3>就诊时间：${orderRecords.transactTime }</h3>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-primary text-left">
				<div class="panel-heading">
					<h3 class="panel-title">就诊人信息</h3>
				</div>
				<div class="panel-body">
					<div class="col-md-12">
						<div class="col-md-1">
							<h3>${commonUser.userName }&nbsp;</h3>
						</div>
						<div class="col-md-1">
							<h3>${commonUser.userSex }&nbsp;</h3>
						</div>
						<div class="col-md-4">
							<h3>&nbsp;身份证：${commonUser.userIdenf }</h3>
						</div>
						<!-- <div class="col-md-2">
							<h3>&nbsp;1996-10-14</h3>
						</div> -->
						<div class="col-md-2">
							<h3>&nbsp;${commonUser.userMobile }</h3>
						</div>
					</div>
					<div class="col-md-12">
						<div class="col-md-10">
							<h3>用户邮箱：${commonUser.userEmail }</h3>
							<div class="alert alert-dismissible alert-warning">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>请注意!</strong> 用户邮箱将作为通知依据 ，就诊人信息本页面不可更改.（请于个人中心处修改个人信息）
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-primary text-left">
				<div class="panel-heading">
					<h3 class="panel-title">疾病信息</h3>
				</div>
				<div class="panel-body">
					<form class="form-search form-horizontal" id="orderInfo"
						action="<c:url value='/orderUserCenter' />" method="post">
						<input type="hidden" value="${orderRecords.userID }" name="userID"
							id="userID"> <input type="hidden"
							value="${orderRecords.id }" name="id" id="id">

						<div class="form-group">
							<label for="textArea" class="col-lg-1 control-label">疾病信息</label>
							<div class="col-lg-10">
								<textarea class="form-control" rows="3" id="diseaseInfo" name="diseaseInfo" 
									style="margin: 0px -6.8375px 0px 0px; width: 424px; height: 80px;"
									placeholder="请填写病史，症状，发病时间，接受过的治疗等信息，提前告知医生您的病情，有助于医生对您的诊疗"></textarea>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="panel panel-primary text-left">
				<div class="panel-heading">
					<h3 class="panel-title">支付方式</h3>
				</div>
				<div class="panel-body">
					<div class="form-group">
						<div class="col-lg-10">
							<div class="radio">
								<label> <input type="radio" name="optionsRadios"
									id="optionsRadios2" value="option2"
									style="width: 20px; height: 20px" checked="">
									&nbsp;现场支付(可使用医保，预约后请到医院现场缴费取号。)
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="optionsRadios"
									id="optionsRadios1" value="option1"
									style="width: 20px; height: 20px" disabled>&nbsp;在线支付(暂未开通)
								</label>
							</div>

						</div>
					</div>
				</div>
			</div>
			<!-- <div class="panel panel-primary text-left">
				<div class="panel-heading">
					<h3 class="panel-title">邮箱验证</h3>
				</div>
				<div class="panel-body">
					<div class="form-group">
						<div class="col-lg-1 text-right" style="margin-top: 2px">
							<p style="width: 80px">验证码：</p>
						</div>
						<div class="col-lg-2 text-left" style="margin-top: 2px">
							<input type="text" class="form-control" id="inputEmail"
								placeholder="邮箱验证码">
						</div>
						<div class="col-lg-1 text-right" style="margin-top: 2px">
							<input id="btnSendCode" type="button" value="发送验证码" onclick="sendMessage()" />
							<input type="button" id="btn" value="免费获取验证码"
								style="color: #ffffff; background-color: #eb6864; border-color: #eb6864; display: inline-block; margin-bottom: 0; font-weight: normal; text-align: center; vertical-align: middle; -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; background-image: none; border: 1px solid transparent; white-space: nowrap; padding: 8px 12px; font-size: 15px; line-height: 1.42857143; border-radius: 4px; -webkit-user-select: none;" />
						</div>
					</div>
				</div>
			</div> -->

			<div class="text-left">
				<label><input id="check_yuyue_rule" type="checkbox"
					name="check_yuyue_rule" value="1"
					style="border: none; margin: 4px 5px 0 0;" class="must_choose fl">
					我已经确认我的个人信息</label>
			</div>
			<div class="text-left">
				<button onclick="submitOrder()" class="btn btn-primary btn-lg"
					id="submitOrder">提交订单</button>
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
	function submitOrder() {
		var $check_yuyue_rule = $("#check_yuyue_rule");
		if ($check_yuyue_rule.is(":checked")) {
			$("#orderInfo").submit();
			return false;
		}
		alert("请确认您的基本信息！")
	}
</script>
<!-- <script type="text/javascript">
	var wait = 300;
	function time(o) {
		if (wait == 0) {
			o.removeAttribute("disabled");
			o.value = "免费获取验证码";
			wait = 300;
		} else {

			o.setAttribute("disabled", true);
			o.value = "重新发送(" + wait + ")";
			wait--;
			setTimeout(function() {
				time(o)
			}, 1000)
		}
	}
	document.getElementById("btn").onclick = function() {
		time(this);
	}
</script> -->
</html>