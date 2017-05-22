<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医院列表</title>
<!-- CSS -->
<jsp:include page="../include/headtag.jsp" />
<!-- <link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500"> -->
<link rel="stylesheet"
	href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
	<jsp:include page="../include/head.jsp" />
	<jsp:include page="../include/menu.jsp" />
	<div id="page-wrapper" style="margin-top: 50px;">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h3 class="text-left">医院详情</h3>
				</div>
			</div>
			<hr />
			<div class="col-md-12">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab"
						aria-expanded="true">预约挂号</a></li>
					<li class=""><a href="#orderNotice" data-toggle="tab"
						aria-expanded="false">预约须知</a></li>
					<li class=""><a href="#notice" data-toggle="tab"
						aria-expanded="false">医院通知</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> 医院介绍 <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#about" data-toggle="tab">医院简介</a></li>
							<li><a href="#equipment" data-toggle="tab">医院设备 </a></li>
							<li><a href="#honor" data-toggle="tab">医院荣誉 </a></li>
						</ul></li>
				</ul>
				<div class="col-md-12">
					 <div class="col-md-3">
						<p class="text-left">医院名称</p>
					</div>
					<div class="col-md-5">
					<p class="text-right"><font color="#eb6864">等级：</font>三级甲等</p>
					</div>
					<div class="col-md-2">
					<p class="text-right"><font color="#eb6864">区域：</font>和平区</p>
					</div>
					<div class="col-md-2">
					<p class="text-right"><font color="#eb6864">类型：</font>综合医院</p>
					</div> 
				</d>
				<hr width="1300px"/>
				<div class="col-md-12">
					<div class="col-md-3">
						<img alt="Bootstrap Thumbnail Third"
							src="http://healthcenter.people.com.cn/hospital/attach/20166/1467774197812.jpg">
					</div>
					<div class="col-md-9"></div>
				</div>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade active in" id="home">
						<p>医院</p>
					</div>
					<div class="tab-pane fade" id="orderNotice">
						<p>预约须知.</p>
					</div>
					<div class="tab-pane fade" id="notice">
						<p>医院通知</p>
					</div>
					<div class="tab-pane fade" id="about">
						<p>医院简介.</p>
					</div>
					<div class="tab-pane fade" id="equipment">
						<p>医院设备.</p>
					</div>
					<div class="tab-pane fade" id="honor">
						<p>医院荣誉.</p>
					</div>
				</div>
			</div>
		</div>
		<!-- /. PAGE INNER  -->
	</div>
	<!-- /. PAGE WRAPPER  -->

</body>
<!-- Javascript -->
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/bootstrap/js/jquery.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
</html>