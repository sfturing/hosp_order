<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帮助中心</title>
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
					<h3 class="text-left">帮助中心</h3>
				</div>
			</div>
			<hr />
			<ul class="nav nav-tabs">
				<li class="active"><a href="#common" data-toggle="tab">常见问题</a></li>
				<li><a href="#complaint" data-toggle="tab">帐号申诉</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> 预约指南 <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#order" data-toggle="tab">预约挂号须知总则</a></li>
						<li class="divider"></li>
						<li><a href="#netbooking" data-toggle="tab">网站预约挂号流程</a></li>
						<li class="divider"></li>
						<li><a href="#appoint" data-toggle="tab">如何查询/取消预约</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> 帐号指南 <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#howsign" data-toggle="tab">如何注册</a></li>
						<li class="divider"></li>
						<li><a href="#howlogin" data-toggle="tab">如何登陆</a></li>
						<li class="divider"></li>
						<li><a href="#account" data-toggle="tab">帐号管理</a></li>
					</ul></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade active in text-left" id="common">
					<div class="col-md-12 ">
						<div class="col-md-2">
							<p class="text-left">问题列表</p>
						</div>
					</div>
					<br /> <br />
					<hr width="1300px">

					<dl id="idl">
						<dt id="dt1" style="margin:10px 0px 10px 20px;">1、用户注册信息提交后是否还可以修改?</dt>
						<dd style="display: none; margin-left: 40px;">注册ID的实名信息，需要人工审核后可以修改，请谨慎填写</dd>
						<div
							style="border-bottom: 1px dashed #ccc; width: 1300px; margin-left: 20px;"></div>
						<dt id="dt2" style="margin:10px 0px 10px 20px;">2、用户资料发生变更如何修改?</dt>
						<dd style="display: none; margin-left: 40px;">
							用户注册成功后，由于用户的有些资料信息发生改变，需要对用户的资料进行修改(譬如手机号码等)，在个人信息修改页面，如原注册手机号有效，用户可选择在线自助修改手机号，修改其它资料信息均由工作人员协助修改，请按照页面提示引导完成修改事宜。
							用户资料修改注意几下几点：
							①请保证您的统一平台账户信息真实有效，如用错误信息，或虚假信息预约挂号，不仅在就诊当日影响您取号就诊，同时也会影响到您今后的预约行为。
							②注册用户如名下存在未就诊的预约号源时，不能修改注册信息，请先取消所有当前有效预约号源或等约成号源过期的次日后再申请修改。
							③用户如修改本人注册姓名、有效证件号、手机号，须在线提出申请，并同时提供本人的有效证件复印件，以便工作人员核实信息，我们将在 5
							个工作日内协助处理完成，并以电话或短信方式通知到您，请保持电话畅通。 ④ 统一平台不支持同时修改姓名和证件号码的申请。 ⑥
							如遇"无法登录"等特殊情况，用户可在线申诉，或拨打010-114协助解决。
							⑦为保证注册用户信息安全，申请人工协助处理修改注册信息或注销时，须提供用户本人注册时的有效证件复印件，敬请理解！</dd>
						<div
							style="border-bottom: 1px dashed #ccc; width: 1300px; margin-left: 20px;"></div>
						<dt id="dt3" style="margin:10px 0px 10px 10px;">3、用户注册信息提交后是否还可以修改?</dt>
						<dd style="display: none; margin-left: 40px;">注册ID的实名信息，需要人工审核后可以修改，请谨慎填写</dd>
					</dl>
				</div>
				<div class="tab-pane fade" id="complaint">
					<p>Raw denim you probably haven't heard of them jean shorts
						Austin. Nesciunt tofu stumptown aliqua, retro synth master
						cleanse. Mustache cliche tempor, williamsburg carles vegan
						helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher
						synth. Cosby sweater eu banh mi, qui irure terry richardson ex
						squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis
						cardigan american apparel, butcher voluptate nisi qui.</p>
				</div>
				<div class="tab-pane fade" id="order">
					<p>intro</p>
				</div>
				<div class="tab-pane fade" id="netbooking">
					<p>Etsy mixtape wayfarers, ethical wes anderson tofu before
						they sold out mcsweeney's organic lomo retro fanny pack lo-fi
						farm-to-table readymade. Messenger bag gentrify pitchfork tattooed
						craft beer, iphone skateboard locavore carles etsy salvia banksy
						hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify
						squid 8-bit cred pitchfork.</p>
				</div>
				<div class="tab-pane fade" id="appoint">
					<p>Trust fund seitan letterpress, keytar raw denim keffiyeh
						etsy art party before they sold out master cleanse gluten-free
						squid scenester freegan cosby sweater. Fanny pack portland seitan
						DIY, art party locavore wolf cliche high life echo park Austin.
						Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out
						farm-to-table VHS viral locavore cosby sweater.</p>
				</div>
				<div class="tab-pane fade" id="howsign">
					<p>Trust fund seitan letterpress, keytar raw denim keffiyeh
						etsy art party before they sold out master cleanse gluten-free
						squid scenester freegan cosby sweater. Fanny pack portland seitan
						DIY, art party locavore wolf cliche high life echo park Austin.
						Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out
						farm-to-table VHS viral locavore cosby sweater.</p>
				</div>
				<div class="tab-pane fade" id="howlogin">
					<p>Trust fund seitan letterpress, keytar raw denim keffiyeh
						etsy art party before they sold out master cleanse gluten-free
						squid scenester freegan cosby sweater. Fanny pack portland seitan
						DIY, art party locavore wolf cliche high life echo park Austin.
						Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out
						farm-to-table VHS viral locavore cosby sweater.</p>
				</div>
				<div class="tab-pane fade" id="account">
					<p>Trust fund seitan letterpress, keytar raw denim keffiyeh
						etsy art party before they sold out master cleanse gluten-free
						squid scenester freegan cosby sweater. Fanny pack portland seitan
						DIY, art party locavore wolf cliche high life echo park Austin.
						Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out
						farm-to-table VHS viral locavore cosby sweater.</p>
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
	$("#idl dt").click(function() {
		var me = $(this);
		me.nextUntil("dt").toggle();
	});
</script>
</html>