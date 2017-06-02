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
					<div style="border-bottom: 1px solid #ccc;"></div>

					<dl id="idl">
						<c:forEach var="commonQA" items="${commonQA }" varStatus="status">
							<dt id="dt${commonQA.id }" style="margin: 10px 0px 10px 20px;">${commonQA.question }</dt>
							<dd style="display: none; margin-left: 40px;">${commonQA.answer }</dd>
							<div
								style="border-bottom: 1px dashed #ccc; width: 1300px; margin-left: 20px;"></div>
						</c:forEach>
					</dl>
				</div>
				<div class="tab-pane fade text-left" id="complaint">
					<div class="col-md-12 ">
						<div class="col-md-2">
							<p class="text-left solid">找回帐号</p>
						</div>
					</div>
					<br /> <br />
					<div style="border-bottom: 1px solid #ccc;"></div>
					<p>
						1、您可以邮件至<a href="mailto:sfturing@gmail.com">sfturing@gmail.com</a>平台服务邮箱备案，在邮件中需要提供本人手持有效证件的人证合一照片，并附带您需要修改的实名信息内容，以及本人联系方式，我们会在
						5个工作日内协助处理完成，并及时通知您。<br>
						2、邮件中请注明您遇到的问题和要修改的信息（如:姓名填写错误无法通过实名认证；手机号绑定错误找不到原绑定手机等。）<br>

						3、为确保您要求修改信息的真实性和准确性，请您本人手持身份证并拍摄一张您与身份证的人证合一照片（如下图所示），上传时请您保证证件号码的清晰。<br>
					</p>
					<a href="javascript:void(0);" class="help_rzhytp"><img
						src="http://img.bjguahao.gov.cn/ws/1.0/hs/images/rzhy.gif"
						name="hospitalImage"></a>
				</div>
				<div class="tab-pane fade text-left" id="order">
					<div class="col-md-12 ">
						<div class="col-md-2">
							<p class="text-left">挂号须知</p>
						</div>
					</div>
					<br /> <br />
					<div style="border-bottom: 1px solid #ccc;"></div>
					<p>
					<div class="help_right_content">
						为提高患者预约效率，改善患者预约体验，天津市卫生和计划生育委员会本着方便百姓就医的服务宗旨,建立天津市预约挂号统一平台（以下简称"统一平台"），为保证您预约挂号成功，请您认真阅读预约挂号服务须知：<br>
						预约电话：（天津用户）/022-（非天津用户），提供7X24小时服务。<br> 预约网址：<a
							href="http://www.sfturing.cn/" target="_blank">www.sfturing.cn</a><br>
						<strong>一、预约范围</strong><br>
						1.1统一平台不提供当日预约服务，用户可预约接入统一平台医院的大部分科室次日起至三个月内的就诊号源，统一平台按照医院、科室、职称、专业不点名预约。具体预约挂号周期和号源信息，以服务电话查询和网站公示为准。<br>
						1.2 每天可预约次日号源的服务时间截止到15:00前。（注：个别医院停止预约时间有所不同，具体以各家医院的个性化预约须知为准）<br>
						<strong>二、实名制注册预约</strong><br> 2.1
						统一平台电话预约和网上预约挂号采取实名制注册，用户首次预约必须注册就诊人的真实有效基本信息，包括就诊人员的真实姓名、有效证件号（身份证、军官证、护照、港澳通行证、台胞证）、性别、电话、手机号码等基本信息。<br>
						2.2 用户到医院取号就诊时须出示与预约登记实名信息一致的本人有效证件，否则医院不予办理挂号业务及诊疗服务。<br>
						2.3 统一平台电话注册和网站注册，1个手机号只能关联1个有效证件号（一个账号能够关联3个常用就诊人，包括自己在内都可以随时挂号）。<br>
						2.4 网站注册预约须要求用户准备好手机，"手机邮件验证"
						是网站注册预约流程的重要环节，没有通过验证，用户无法成功注册预约，故请务必填写真实有效的手机号码。<br> 2.5
						用户也可通过（非天津用户022-）电话服务热线进行人工注册、预约，拨打电话注册时需登记真实有效的手机号码或者座机号码。（建议使用手机号码注册预约，以便接收邮件通知和预约、查询使用；若用户想要使用统一平台预约功能则需要在平台上重新验证手机号并设计密码，完成大平台的验证登录流程，才能使用坐席的注册账号在统一平台上预约）<br>
						（ 详细了解"无身份证号，或者已经申报户口但还未办理身份证的患儿如何注册预约？" ）<br> <strong>三、账户信息管理</strong><br>
						3.1请保证您的统一平台账户信息真实有效，如用错误信息，或虚假信息预约挂号，不仅在就诊当日影响您取号就诊，同时也会影响到您今后的预约行为。<br>
						3.2注册用户如名下存在未就诊的预约号源时，无法申请修改注册信息，请先取消所有当前有效预约号源或等约成号源过期的次日后再申请修改。<br>
						3.3用户如修改本人注册姓名、有效证件号、手机号，须在线提出申请，须提供用户本人手持注册时的有效证件的人证合一，以便工作人员核实信息，我们将在5个工作日内协助处理完成，并以电话或邮件方式通知到您，请保持电话畅通。（注：如原注册手机号有效，用户可选择在线自助完成更换手机号的工作）<br>
						3.4 统一平台不支持同时修改姓名和证件号码的申请。（注：该申请等同于重新注册）<br> 3.5
						如遇"无法登录"等特殊情况，用户可在线申诉，或拨打022-协助解决。<br>
						3.6为保证注册用户信息安全，申请人工协助处理修改注册信息时，须提供用户本人手持注册时的有效证件的人证合一照片，请保证脸部和证件的清晰，敬请理解！<br>
						<strong>四、预约确认与就诊</strong><br>
						4.1通过网站或电话预约成功后，系统会自动下发预约成功邮件及唯一的8位数字识别码到用户注册手机上；如果电话注册的是座机电话，工作人员每次会通过口述方式把预约信息报给您听，请您做好记录保存。<br>
						4.2 预约成功后，请您妥善保存"预约成功邮件和预约识别码"，以便随时查询和取消预约信息之用，同时也是您用于取号就诊的凭证之一。<br>
						4.3
						如果您未收到或丢失"预约成功邮件和预约识别码"，可登录统一平台网站的"个人中心&gt;预约管理&gt;当前预约"中找到相应的订单查看详情，或者拨打客服电话协助查询，工作人员与您核实信息后，系统会重新为您发送约成邮件和识别码。<br>
						4.4成功预约挂号后，系统将自动保存用户预约记录。就诊当天，您需要在医院规定的取号时间之内，前往医院指定的地点取号就诊，并缴纳医院规定的医事服务费，逾期预约自动作废。具体取号时间和取号地点请查阅系统下发的预约成功通知邮件，或各家医院的个性化预约须知。<br>
						4.5本着方便患者的原则，个别医院开通了自助取号或分诊台先取号后缴费服务，具体取号流程和要求以医院现场公示为准。如患者就诊后未缴费，将被列入欠费名单，您将无法通过统一平台或在各医院进行任何形式的预约挂号和窗口挂号。<br>
						4.6 取号时需要提供以下重要凭证：<br> 4.6.1
						就诊当日取号时，就诊人需凭就诊人本人注册的有效证件原件、预约成功通知邮件和预约识别码至医院指定的挂号窗口取号（个别医院要求先办理就诊卡并关联社保卡后再取号，具体详见各家医院的个性化预约须知）；取号时医务人员将核对就诊者的身份信息和预约记录，如信息验证不符，则医院不能提供相应的诊疗服务。<br>
						4.6.2 "首都医科大学附属天津儿童医院（天津儿童医院）"和"首都儿科研究所附属儿童医院（儿研所）"预约取号比较特殊，①
						预约"天津儿童医院"，就诊当日须出示监护人注册时的有效证件取号就诊。同时，就诊当日必须带患儿就诊，否则此号源作废。②预约"儿研所"，就诊当日须出示患儿的有效证件（户口本/身份证/护照/港澳通行证/台胞证），及医保卡取号就诊。
						<br> <strong>五、查询、取消预约</strong><br> 5.1
						用户在医院规定的取消时限内可以取消预约号，超过退号截止时间系统将限制用户退号，一般截止时间为就诊日期的前一天下午15:00点，就诊当天不能取消当日预约号。（注：个别医院的预约取消截止时间有所不同，具体规则请关注各家医院的个性化预约须知）<br>
						5.2
						在医院规定的取消预约时限内，用户可登录统一平台网站的"个人中心"直接取消，或拨打客服电话进行查询/退号操作，退号时需凭"预约识别码"进行取消。<br>
						5.3
						如果您在就诊当天不能前往医院取号就诊，请提前退号，否则会因造成号源的浪费，影响其他患者的就诊而被记录爽约档案，由此会影响到您今后的预约行为，请您谅解。<br>
						<strong>六、预约限制</strong><br>
						为了防止号贩子倒号行为，满足绝大多数百姓的最大利益和公平性，统一平台采取了预约挂号限制。按照天津市卫生和计划生育委员会统一平台提供的预约挂号服务公约，同一患者实名（有效证件号）在同一就诊日、同一医院、同一科室只能预约1次；在同一就诊日的预约总量不可超过2次；在七日内的预约总量不可超过3次；在三个月内预约总量不可超过5次。<br>
						<strong>七、爽约的判定及处罚</strong><br> 7.1
						爽约是指用户未按医院规定的取号时间提前到医院指定的挂号窗口取号，且超过预约就诊时间未能按时就诊即视为爽约，该预约号源自动作废。如仍需就诊可重新预约或到医院挂号窗口挂号。<br>
						7.2
						一年内（自然年）无故爽约累计达到3次的爽约用户将自动进入系统爽约名单，此后3个月内将取消其预约挂号资格；一年内（自然年）累计爽约6次，取消6个月的预约挂号资格。<br>
						<strong>八、黑名单用户的判定及处罚</strong><br> 8.1 判定<br>
						<table class="help_right_content_table" cellpadding="0"
							cellspacing="0" border="0">
							<tbody>
								<tr>
									<td bgcolor="#e9e9f1">编号</td>
									<td bgcolor="#e9e9f1">定义范围</td>
									<td bgcolor="#e9e9f1" align="left">解释</td>
								</tr>
								<tr>
									<td>1</td>
									<td>注册环节</td>
									<td align="left">身份证号不符合规范；</td>
								</tr>
								<tr>
									<td>2</td>
									<td>预约环节</td>
									<td align="left">同一手机号在现有预约规则下3个月内预约大于15个号源（不含15个）；</td>
								</tr>
								<tr>
									<td>3</td>
									<td>取消环节</td>
									<td align="left">频繁取消，1个月内频繁取消大于15个号源（不含15个）；</td>
								</tr>
							</tbody>
						</table>
						8.2 黑名单用户处罚规则<br>
						<table class="help_right_content_table" cellpadding="0"
							cellspacing="0" border="0">
							<tbody>
								<tr>
									<td bgcolor="#e9e9f1" align="left">操作</td>
									<td bgcolor="#e9e9f1">权限</td>
								</tr>
								<tr>
									<td align="left">登录</td>
									<td>√</td>
								</tr>
								<tr>
									<td align="left">使用个人中心</td>
									<td>X</td>
								</tr>
								<tr>
									<td align="left">预约</td>
									<td>X</td>
								</tr>
								<tr>
									<td align="left">取消预约</td>
									<td>√</td>
								</tr>
								<tr>
									<td align="left">注册信息修改</td>
									<td>X</td>
								</tr>
							</tbody>
						</table>
						<strong>九、特别声明</strong><br> 9.1
						以上为统一平台服务总则，各家医院的特殊预约规则详见医院首页公示的"预约须知"。<br>
						9.2统一平台不收取医事服务费，各家医院仅收取与医生职称相对应的医事服务费，如与您预约时不符，则以当日医院挂号窗口为准。<br>
						9.3 用户如需医保报销，请预约医保限定的定点报销医院。<br> 9.4
						请不要随意向他人泄露自己的实名身份信息，由于统一平台对预约者实行实名身份信息绑定，这样做会导致您的实名身份信息进入管制名单而无法进行预约。<br>
						9.5 本服务为用户提供便捷的预约方式，不承诺所有用户随时都能约到指定的号，有不便之处敬请谅解，有任何好的建议也可以直接向我们反馈。<br>
					</div>
					</p>

				</div>
				<div class="tab-pane fade text-left" id="netbooking">
					<p>预约挂号模块完成之后 保留</p>
				</div>
				<div class="tab-pane fade" id="appoint">
					<p>保留.</p>
				</div>
				<div class="tab-pane fade text-left" id="howsign">
					<div class="col-md-12 ">
						<div class="col-md-2">
							<p class="text-left">注册问题</p>
						</div>
					</div>
					<br /> <br />
					<div style="border-bottom: 1px solid #ccc;"></div>
					<dl id="idl">
						<c:forEach var="signQA" items="${signQA }" varStatus="status">
							<dt id="dt${signQA.id }" style="margin: 10px 0px 10px 20px;">${signQA.question }</dt>
							<dd style="display: none; margin-left: 40px;">${signQA.answer }</dd>
							<div
								style="border-bottom: 1px dashed #ccc; width: 1300px; margin-left: 20px;"></div>
						</c:forEach>
					</dl>



				</div>
				<div class="tab-pane fade text-left" id="howlogin">
					<h3>如何登录</h3>
					<div class="help_right_content">
						1、网站预约挂号如何登录？ 进入天津市预约挂号统一平台网站首页，点击页面右上方的"登录"。<br>
						<p align="center">
							<img src="${mybasePath}assets/img/helpImg/login1.png">
						</p>
						<br> 2、登录， 1，如果没有注册，进入注册页面注册账号 2，邮箱作为唯一标识，请谨慎注册，更换邮箱需要联系客服。 <br>
						<p align="center">
							<img src="${mybasePath}assets/img/helpImg/login2.png">
						</p>
						<br> 3、新注册用户登陆后需要完善信息<br>
						<p align="center">
							<img src="${mybasePath}assets/img/helpImg/login3.png">
						</p>
						<br> 温馨提示：<br> ① 关于注册用户首次登录网上预约平台信息认证问题？<br>
						首次登录后需要完善个人信息，完善个人信息后方可预约挂号。<br> * 如果您信息显示已注册，请联系客服<br>

					</div>
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