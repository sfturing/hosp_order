<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系我们</title>
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
				<div class="col-md-12">
					<h3 class="text-left">个人中心</h3>
				</div>
			</div>
			<hr />
			<ul class="nav nav-tabs">
				<li class="active"><a href="#order" data-toggle="tab">预约信息</a></li>
				<li><a href="#userInfo" data-toggle="tab">个人信息</a></li>
				<li><a href="#myFavourite" data-toggle="tab">我的收藏</a></li>

			</ul>
			<br>
			<div id="myTabContent" class="tab-content">
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
								<th>订单创建时间</th>
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
									<td><c:if test="${orderRecords.isFinish ==0 }">
											<c:if test="${orderRecords.isCancel ==0 }">
												<c:if test="${orderRecords.isSuccess ==0 }">
													<c:if test="${orderRecords.orderVer ==1 }">订单已提交(待审核)</c:if>
												</c:if>
											</c:if>
										</c:if> <c:if test="${orderRecords.isFinish ==0 }">
											<c:if test="${orderRecords.isCancel ==0 }">
												<c:if test="${orderRecords.isSend ==0 }">
													<c:if test="${orderRecords.isSuccess ==1 }">
														<font color="#eb6468">预约成功(待通知)</font>
													</c:if>
												</c:if>
											</c:if>
										</c:if> <c:if test="${orderRecords.isFinish ==0 }">
											<c:if test="${orderRecords.isCancel ==0 }">
												<c:if test="${orderRecords.isSend ==1 }">
													<c:if test="${orderRecords.isSuccess ==1 }">
														<font color="#eb6468">预约成功(已通知)</font>
													</c:if>
												</c:if>
											</c:if>
										</c:if> <c:if test="${orderRecords.isCancel ==1 }">
											<font color="#000">已取消</font>

										</c:if> <c:if test="${orderRecords.isFinish ==1 }">
											<font color="#eb6468">订单已完成</font>
										</c:if></td>
									<td>${orderRecords.createTime }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="tab-pane fade text-left" id="userInfo">
					<div class="panel panel-primary text-left">
						<div class="panel-heading">
							<h3 class="panel-title">个人信息</h3>
						</div>
						<div class="panel-body">
							<div class="col-md-12">
								<div class="col-md-12">
									<h3>姓名：${commonUser.userName }&nbsp;</h3>
								</div>
							</div>
							<div class="col-md-12 text-left">
								<div class="col-md-12 text-left">
									<div
										style="width: 70px; height: 36px; margin: 0px 0px 0px 0px; float: left;">
										<h3>性别：</h3>
									</div>
									<div
										style="width: 70px; height: 36px; margin-top: 15px; float: left;">

										<select style="margin-bottom: 6px;"
											class="col-md-2 form-control" id="userSex" name="userSex">
											<option value="${commonUser.userSex }" selected="selected">${commonUser.userSex }</option>
											<c:if test="${commonUser.userSex=='男' }">
												<option value="女">女</option>
											</c:if>
											<c:if test="${commonUser.userSex=='女' }">
												<option value="男">男</option>
											</c:if>
										</select>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3">
									<h3>手机号：${commonUser.userMobile }</h3>
								</div>
								<div class="col-md-3">
									<h3>
										<a href="/ssm_pro/modifiPhone">修改手机号码</a>
									</h3>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-12">
									<h3>邮箱：${commonUser.userEmail }</h3>
									<div class="alert alert-dismissible alert-warning">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<strong>请注意!</strong> 用户邮箱将作为通知依据 ，更改邮箱请进行申诉.）
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-12">
									<h3>身份证：${commonUser.userIdenf }</h3>
									<div class="alert alert-dismissible alert-warning">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<strong>请注意!</strong> 用户身份证将作为认证 ，更改身份证请进行申诉.）
									</div>
								</div>
							</div>
							<div class="col-md-12 text-left">
								<div class="col-md-12">
									<button class="btn btn-primary btn-lg" id="updateSexButton"
										name="updateSexButton">保存信息</button>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="tab-pane fade" id="myFavourite">
					<div class="panel panel-primary ">
						<div class="panel-heading text-left">
							<h3 class="panel-title">我的收藏</h3>
						</div>
						<div class="panel-body">
							<c:if test="${hospitals==null }">
							<div class="col-md-12 text-left">
								<p>暂无收藏记录</p></div>
							</c:if>
							<c:forEach var="hos" items="${hospitals }" varStatus="status">
								<%-- <c:forEach var="i" begin="1" end="9" varStatus="status"> --%>
								<div class="col-md-3">
									<div class="thumbnail" style="width: 300px; height: 400px;">
										<div>
											<img alt="请检查网络，图片加载出现了一点小问题" src="${hos.hospitalImg}"
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

												<c:if test='${hos.isOpen=="1" }'>
													<a class="btn btn-primary"
														href="<c:url value='/hosInfoShow/${hos.id}' />">现在预约</a>
												</c:if>
												<c:if test='${hos.isOpen=="0" }'>
													<a class="btn btn-default disabled" href="#">未开通</a>
													<a class="btn "
														href="<c:url value='/hosInfoShow/${hos.id}' />">详细信息</a>
												</c:if>

											</p>
										</div>
									</div>
								</div>

							</c:forEach>
						</div>

					</div>
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
	$(function() {
		$("#updateSexButton")
				.click(
						function() {
							$
									.post(
											"/ssm_pro/updateSex",
											{
												'userSex' : $("#userSex").val()
											},
											function(result) {
												if (result.userSexInfo != "") {

													if (result.userSexInfo == "男") {
														alert("修改成功");
														var userSexInfo = '<option value="男">男</option>';
														userSexInfo += '<option value="女">女</option>'
														$(
																"select[name='userSex']")
																.empty()
																.append(
																		userSexInfo);
													} else {
														alert("修改成功");
														var userSexInfo = '<option value="女">女</option>';
														userSexInfo += '<option value="男">男</option>';
														$(
																"select[name='userSex']")
																.empty()
																.append(
																		userSexInfo);
													}
													/* var noticeTypes = '<option value="-1">请选择</option>';
													$.each(result.noticeTypes, function(i,item){
														
														noticeTypes += '<option value="'+item.id+'">'+item.dictionaryValue+'</option>';
													});
													
													$("select[name='noticeTypeId']").empty().append(noticeTypes); */
												}
											});
						});
	});
</script>
</html>