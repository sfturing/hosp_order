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
					<p class="text-left">预约医院列表</p>
					<div class="col-md-12">
						<form class="form-search" id="setchInfo"
							action="<c:url value='/orderHos/1' />"></form>
					</div>
				</div>
			</div>
			<hr />
			<br /> <br />
			<c:forEach var="hos" items="${hospital }" varStatus="status">
				<%-- <c:forEach var="i" begin="1" end="9" varStatus="status"> --%>
				<div class="col-md-3">
					<div class="thumbnail">
						<img alt="Bootstrap Thumbnail Third"
							src="http://yyk.99.com.cn/Images/NoPicture.jpg">
						<div class="caption">
							<p>${hos.hospitalName}</p>
							<%-- <p>
								<span class="glyphicon glyphicon-earphone "></span>&nbsp;&nbsp;:&nbsp;${hos.hospitalPhone}
							</p> --%>
							<p>
								<span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;:&nbsp;${hos.hospitalAddress}
							</p>
							<p>
								<a class="btn btn-primary" href="#">预约</a> <a class="btn"
									href="<c:url value='/hosInfoShow/${hos.id}' />">详细信息</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<c:if test="${pages.totalPage > 0}">
			<ul class="pagination pagination-lg">
				<li <c:if test="${pages.currentPage < 1}">class="disabled"</c:if>><a
					href="#">&laquo;</a></li>
				<c:forEach begin="${pages.pageNumStart }" end="${pages.pageNumEnd }"
					varStatus="status">
					<li
						<c:if test="${status.index == pages.currentPage }">class="active"</c:if>>
						<a href="javascript:void(0);" onclick="tijiao('${status.index }')">
							${status.index } </a>
					</li>
				</c:forEach>
				<li
					<c:if test="${pages.currentPage> pages.totalPage}">class="disabled"</c:if>><a
					href="#">&raquo;</a></li>
				<li class="disabled"><a>共${pages.totalPage}页${pages.totalRecord}条记录</a>
			</ul>
		</c:if>
		<!-- /. PAGE INNER  -->
	</div>
	<!-- /. PAGE WRAPPER  -->

</body>
<!-- Javascript -->
<script src="${mybasePath}assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${mybasePath}assets/bootstrap/js/jquery.min.js"></script>
<script src="${mybasePath}assets/js/jquery.backstretch.min.js"></script>
<!--不需要背景 <script src="assets/js/scripts.js"></script> -->
<!-- <script type="text/javascript">
	jQuery(document).ready(function() {
	
    $.backstretch("assets/img/backgrounds/1.jpg");
    
    });
    </script> -->
<script type="text/javascript">
	function tijiao(url) {
		$("#setchInfo").attr("action", "<c:url value='/orderHos/"+url+"' />");
		$("#setchInfo").submit();
	}
</script>
</html>