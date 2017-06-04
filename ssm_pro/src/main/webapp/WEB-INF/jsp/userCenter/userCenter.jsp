<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系我们</title>
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
					<h3 class="text-left">个人中心</h3>
				</div>
			</div>
			<hr />
			<ul class="nav nav-tabs">
				<li class="active"><a href="#order" data-toggle="tab">预约信息</a></li>
				<li><a href="#partener" data-toggle="tab">个人信息</a></li>
				<li><a href="#statement" data-toggle="tab">我的收藏</a></li>
				<li><a href="#service" data-toggle="tab">我的评论</a></li>

			</ul>
			<div class="tab-pane fade active in text-left" id="order">
				<div class="col-md-12">
					<!-- <div class="col-md-3"> -->
					<p class="text-left">
						<font color="#eb6864">我的预约</font>
					</p>
					<!-- </div> -->
				</div>

				<table class="table table-striped table-hover ">
					<thead>
						<tr>
							<th>订单</th>
							<th>就诊日期</th>
							<th>就诊时间段</th>
							<th>医院</th>
							<th>科室</th>
							<th>医生</th>
							<th>订单状态</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="orderRecords" items="${orderRecords }"
							varStatus="status">
							<tr>
								<td>${ status.index + 1}</td>
								<%-- <td><a href="<c:url value='/officeInfoShow/${off.id}' />">${orderRecords.transactDate }</a></td> --%>
								<td>${orderRecords.transactDate }</td>
								<td>${orderRecords.transactTime }</td>
								<td>${orderRecords.hospitalName }</td>
								<td>${orderRecords.officesName }</td>
								<td>${orderRecords.doctorName }</td>
								<td><c:if test="${orderRecords.orderVer ==1 }">订单已提交(待审核)</c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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