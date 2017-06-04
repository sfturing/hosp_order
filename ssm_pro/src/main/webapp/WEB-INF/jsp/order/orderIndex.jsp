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
<link rel="stylesheet" href="${mybasePath}assets/date/css/index.css">
<script src="${mybasePath}assets/bootstrap/js/jquery.min.js"></script>
<script src="${mybasePath}assets/date/js/index.js"></script>
</head>
<body>
	<jsp:include page="../include/head.jsp" />
	<jsp:include page="../include/menu.jsp" />
	<div id="page-wrapper" style="margin-top: 50px;">
		<form class="form-search form-horizontal" id="setchInfo"
			action="<c:url value='/allHos/1' />"></form>
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h3 class="text-left">预约挂号</h3>
				</div>
			</div>
			<hr />
			<div class="a" style="width: 800px;">
				 <div class="order-info-div">
					
					<ol class="oid-ul"></ol>
					<!-- <input type="hidden" id="orderInfoValue"> -->
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

</html>