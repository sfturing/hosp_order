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

</head>
<body>
	<jsp:include page="../include/head.jsp" />
	<jsp:include page="../include/menu.jsp" />
	<div id="page-wrapper" style="margin-top: 50px;">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<p class="text-left">预约医院列表</p>
					<hr />
					<form class="form-search form-horizontal" id="setchInfo"
						action="<c:url value='/orderHos/1' />" method="post">
						<fieldset>
							<label for="select" class="col-lg-2 control-la	bel text-left">&nbsp;&nbsp;&nbsp;&nbsp;地区:</label>
							<label for="select" class="col-lg-4 control-la	bel text-left">&nbsp;&nbsp;医院信息:</label>
							<!-- <label for="select" class="col-lg-4 control-la	bel text-left">医院名称:</label> -->
							<div class="col-md-12">
								<div class="col-md-2" data-toggle="distpicker">
								<input id="province" name="province" type="hidden" value="${province }"/>
								<input id="city" name="city" type="hidden" value="${city }"/>
								<input id="district" name="district" type="hidden" value="${district }"/>
									<select id="provinceInfo" name="provinceInfo"
										style="margin-bottom: 6px;" class="col-md-2 form-control"
										data-province="---- 选择省 ----"></select><select id="cityInfo"
										name="cityInfo" style="margin-bottom: 6px;"
										class="col-md-2 form-control" data-city="---- 选择市 ----"></select>
									<select id="districtInfo" name="districtInfo"
										style="margin-bottom: 6px;" class="col-md-2 form-control"
										data-district="---- 选择区 ----"></select>
								</div>
								<div class="col-md-2">
									<select style="margin-bottom: 6px;"
										class="col-md-2 form-control" id="hospitalGrade"
										name="hospitalGrade">
										<option value="默认" selected="selected">请选择医院等级</option>
										<c:forEach var="grade" items="${hospGrade }"
											varStatus="status">
											<c:choose>
												<c:when test="${commonCondition.hospitalGrade == grade }">
													<option value="${grade }" selected="selected">${grade }</option>
												</c:when>
												<c:otherwise>
													<option value="${grade }">${grade }</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select> <select style="margin-bottom: 6px;"
										class="col-md-2 form-control" id="hospNature"
										name="hospitalNature">
										<option value="默认">请选择医院类型</option>
										<c:forEach var="nature" items="${hospNature }"
											varStatus="status">
											<c:choose>
												<c:when test="${commonCondition.hospitalNature == nature }">
													<option value="${nature }" selected="selected">${nature }</option>
												</c:when>
												<c:otherwise>
													<option value="${nature }">${nature }</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select> <input class="col-md-3 form-control" id="hospitalName"
										name="hospitalName" type="text" placeholder="医院名称"
										value="${commonCondition.hospitalName }">
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
								<div class="col-md-4 text-left">
									<span class="label label-primary">${commonCondition.province }</span>
									<span class="label label-primary">${commonCondition.city }</span>
									<span class="label label-primary">${commonCondition.district	 }</span>
								</div>
								<div class="col-md-4 text-right">
									<button type="submit" class="btn btn-primary " id="serchHosp">search
									</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
			<hr />
			<br /> <br />
			<c:forEach var="hos" items="${hospital }" varStatus="status">
				<%-- <c:forEach var="i" begin="1" end="9" varStatus="status"> --%>
				<div class="col-md-3">
					<div class="thumbnail" style="width: 300px; height: 400px;">
						<div>
							<img alt="Bootstrap Thumbnail Third" src="${hos.hospitalImg}"
								height="200" width="200" />
						</div>
						<div class="caption">
							<p>${hos.hospitalName}</p>
							<%-- <p>
								<span class="glyphicon glyphicon-earphone "></span>&nbsp;&nbsp;:&nbsp;${hos.hospitalPhone}
							</p> --%>
							<p>
								<span class="glyphicon glyphicon-home"></span>&nbsp;${hos.hospitalAddress}
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
					href="javascript:void(0);" onclick="tijiao('${pages.nextPage }')">&raquo;</a></li>
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
<script src="${mybasePath}assets/js/distpicker.js"></script>
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
		return false;
	}
</script>
<script type="text/javascript">
	$(function() {
		$('#serchHosp').click(function() {
			var provinceInfo = $("#provinceInfo").val();
			$("#province").attr("value",'');
			$("#province").attr("value",provinceInfo);
			var cityInfo = $("#cityInfo").val();
			$("#city").attr("value",'');
			$("#city").attr("value",cityInfo);
			var districtInfo = $("#districtInfo").val();
			$("#district").attr("value",'');
			$("#district").attr("value",districtInfo);
			$('#setchInfo').submit();
			return false;
		});
	});
</script>
</html>