<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约科室列表</title>
<!-- CSS -->
<jsp:include page="../include/headtag.jsp" />
<!-- <link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500"> -->
<link rel="stylesheet" href="${mybasePath}assets/css/style.css">
</head>
<body>
	<jsp:include page="../include/head.jsp" />
	<jsp:include page="../include/menu.jsp" />
	<div id="page-wrapper" style="margin-top: 50px;">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<p class="text-left">预约科室列表</p>
					<hr />
					<form class="form-search form-horizontal" id="setchInfo"
						action="<c:url value='/orderOffice/1' />" method="post">
						<fieldset>

							<label for="select" class="col-lg-4 control-la	bel text-left">&nbsp;&nbsp;科室信息:</label>
							<!-- <label for="select" class="col-lg-4 control-la	bel text-left">医院名称:</label> -->
							<div class="col-md-12">
								<div class="col-md-2">

									<input class="col-md-3 form-control" id="hospitalName"
										name="hospitalName" type="text" placeholder="医院名称"
										value="${commonCondition.hospitalName }"
										style="margin-bottom: 6px;"> <input
										class="col-md-3 form-control" id="officesName"
										name="officesName" type="text" placeholder="科室名称"
										value="${commonCondition.officesName }">
									<!-- <select style="margin-bottom:6px;" class="col-md-2 form-control" id="medicalnsuranceNum" name="medicalnsuranceNum">
										<option value="0" selected="selected">医院是否医保</option>
										<option value="医保">医保</option>
										<option value="非医保">非医保</option>

									</select> -->
								</div>

								<!-- <div style="margin-bottom:50px;" class="col-md-4">
									<input class="col-md-3 form-control" id="hospitalName" name="hospitalName"
										type="text">
								</div> -->
							</div>
							<div class="col-md-6 text-right">
								<div class="col-md-4 text-left"></div>
								<div class="col-md-4 text-right">
									<button type="submit" class="btn btn-primary " id="serchOffice">search
									</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
			<hr />
			<br /> <br />
			<c:forEach var="office" items="${officeRe }" varStatus="status">
				<%-- <c:forEach var="i" begin="1" end="9" varStatus="status"> --%>
				<div class="col-md-3">
					<div class="thumbnail" style="width: 300px; height: 200px;">
						<%-- <div>
							<img alt="Bootstrap Thumbnail Third"
								src="${hospitalRe[status.count-1].hospitalImg}" height="200"
								width="200" />
						</div> --%>
						<div class="caption">
							<h3>${office.officesName}</h3>
							<p>
								<span class="glyphicon glyphicon-home"></span>&nbsp;${office.hospitalName}
							</p>
							<p>

								<a class="btn btn-primary" href="#">预约</a> <a class="btn"
									href="<c:url value='/officeInfoShow/${office.id}' />">详细信息</a>

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
					href="javascript:void(0);" onclick="tijiao('${pages.nextPage }')">&raquo;</a></li>

				<li><input id="tijiaoInput" name="tijiaoInput" type="text"
					class="form-control col-md-1" style="width: 60px; height: 54.89px"></li>
				<li><a onclick="tijiaoInput()">Go</a></li>
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
		$("#setchInfo")
				.attr("action", "<c:url value='/orderOffice/"+url+"' />");
		$("#setchInfo").submit();
		return false;
	}
</script>
<script type="text/javascript">
	function tijiaoInput() {
		var url = $("#tijiaoInput").val();
		if (url == "") {
			alert("请输入翻页数目");
			$("#tijiaoInput").attr("value", "");
			return false;
		} else {
			var match = /^[1-9][0-9]*[0-9]*$/;
			if (!match.test(url)) {
				$("#tijiaoInput").val("");
				alert("请正确填写翻页数目");

				return false;
			}
		}
		$("#setchInfo")
				.attr("action", "<c:url value='/orderOffice/"+url+"' />");
		$("#setchInfo").submit();
		return false;
	}
</script>
<script type="text/javascript">
	$(function() {
		$('#serchOffice').click(function() {
			var provinceInfo = $("#provinceInfo").val();
			$("#province").attr("value", '');
			$("#province").attr("value", provinceInfo);
			var cityInfo = $("#cityInfo").val();
			$("#city").attr("value", '');
			$("#city").attr("value", cityInfo);
			var districtInfo = $("#districtInfo").val();
			$("#district").attr("value", '');
			$("#district").attr("value", districtInfo);
			$('#setchInfo').submit();
			return false;
		});
	});
</script>
</html>