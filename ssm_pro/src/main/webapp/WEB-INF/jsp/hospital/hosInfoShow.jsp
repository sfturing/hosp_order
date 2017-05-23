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
					<li class=""><a href="#about" data-toggle="tab"
						aria-expanded="false">医院简介</a></li>
					<li class=""><a href="#equipment" data-toggle="tab"
						aria-expanded="false">医院设备</a></li>
					<li class=""><a href="#honor" data-toggle="tab"
						aria-expanded="false">医院荣誉</a></li>
				</ul>
				<div class="col-md-12">
					<div class="col-md-3">
						<p class="text-left">${hos.hospitalName }</p>
					</div>
					<div class="col-md-5">
						<p class="text-right">
							<font color="#eb6864">等级：</font>三级甲等
						</p>
					</div>
					<div class="col-md-2">
						<p class="text-right">
							<font color="#eb6864">区域：</font>和平区
						</p>
					</div>
					<div class="col-md-2">
						<p class="text-right">
							<font color="#eb6864">类型：</font>综合医院
						</p>
					</div>
				</div>
				<hr width="1300px" />
				<div class="col-md-12">
					<div class="col-md-3">
						<img alt="Bootstrap Thumbnail Third"
							src="http://healthcenter.people.com.cn/hospital/attach/20166/1467774197812.jpg">
					</div>
					<div class="col-md-4">
						<p class="text-left">
							<font color="#eb6864">院长姓名：</font>孙士濠
						</p>
						<p class="text-left">
							<font color="#eb6864">建院年份：</font>1949
						</p>
						<p class="text-left">
							<font color="#eb6864">科室数量：</font>12
						</p>
						<p class="text-left">
							<font color="#eb6864">医保人数：</font>1111
						</p>
					</div>
					<div class="col-md-5">
						<p class="text-left">
							<font color="#eb6864">病床数量：</font>212
						</p>
						<p class="text-left">
							<font color="#eb6864">年门诊量：</font>11123
						</p>
						<p class="text-left">
							<font color="#eb6864">是否医保：</font>是
						</p>
						<p class="text-left">
							<font color="#eb6864">医院网址：<a href="www.baidu.com">www.baidu.com</a></font>
						</p>
					</div>
				</div>
				<hr width="1300px" />

				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade active in text-left" id="home">
						<div class="col-md-12">
							<div class="col-md-3">
								<p class="text-left">门诊科室</p>
							</div>
						</div>
						<hr width="1300px">
						<table class="table table-striped table-hover ">
							<thead>
								<tr>
									<th>门诊科室</th>
									<th>科室名称</th>
									<th>科室人数</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td><a href="www.baidu.com">血液科</a></td>
									<td>20</td>
								</tr>
								<tr>
									<td>2</td>
									<td>Column content</td>

									<td>Column content</td>
								</tr>
								<tr>
									<td>3</td>
									<td>Column content</td>

									<td>Column content</td>
								</tr>
								<tr>
									<td>4</td>
									<td>Column content</td>

									<td>Column content</td>
								</tr>
								<tr>
									<td>5</td>
									<td>Column content</td>

									<td>Column content</td>
								</tr>
								<tr>
									<td>6</td>
									<td>Column content</td>

									<td>Column content</td>
								</tr>
								<tr>
									<td>7</td>
									<td>Column content</td>

									<td>Column content</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="tab-pane fade text-left" id="orderNotice">
						<div class="col-md-12 ">
							<div class="col-md-2">
								<p class="text-left">预约须知</p>
							</div>
						</div>
						<hr width="1300px">
						<p>
							<br> <strong>电话预约挂号：022-022（24小时）<br>
								网络预约挂号：http://www.sfturing.cn
							</strong><br> <br>
							根据卫生部8月5日通知和卫生局8月20日工作部署，医院名称已完成电话、网络预约挂号的流程建设，现将预约挂号、取号有关事项公布如下，请您认真阅读预约须知：<br>
							<br> <strong>一、预约时间范围：</strong><br>
							1、您可预约7天内（试点）日间的副教授、主治医师和住院医师等号源。节假日不安排预约号（含周六、周日）。<br>
							2、每天早8:30分开始放号;下午14:00停止次日预约挂号。<br> 3、周五14:00停挂至下周一。<br>
							<br> <strong>二、预约实名制：</strong><br>
							统一平台电话预约和网上预约挂号均采取实名制注册预约，请您如实提供就诊人员的真实姓名、有效证件号（身份证、军官证、护照）、性别、电话、手机号码、病案号或协和就诊卡条形码上的ID号等有效基本信息。<br>
							<br> <strong>三、预约取号：</strong><br>
							1、预约成功后，请患者于就诊当日携带有效证件、预约识别码及协和医院就诊卡到医院挂号窗口验证预约信息（核对与预约登记实名信息一致的本人有效证件和预约识别码）和取号，如验证不符则医院不能提供相应的诊疗服务。如果没有协和医院就诊卡者，请先办好就诊卡后再取号。<br>
							2、取号时间：上午就诊患者，就诊当日早9：00以前取号。下午就诊患者，就诊当日下午12:00-13:30之间取号。过时未取号者，预约作废。<br>
							3、取号地点：地址<br> <br> <strong>四、医生停诊：</strong><br>
							如遇特殊情况医生停诊，给您造成的不便敬请谅解。医生临时停诊，工作人员将会用电话方式及时通知您，请配合更改就诊日期或更换其他医生，请您保持电话畅通。<br>
							<br> <strong>五、取消预约：</strong><br>
							挂出的预约号如办理退号，至少在就诊前一工作日14:00前通过网站或者电话凭预约识别码进行取消。<br> <br>
							<strong>六、爽约处理：</strong><br> 1、如预约成功后患者未能按时就诊且不办理取消预约号视为爽约。<br>
							2、一年内（自然年）无故爽约累计达到3次的爽约用户将自动进入系统爽约名单，此后3个月内将取消其预约挂号资格；一年内（自然年）累计爽约6次，取消6个月的预约挂号资格。<br>
							<br> <strong>七、其它注意事项：</strong><br> 1、注意事项一。<br>
							2、注意事项而。<br> <br> <strong>交通指南：</strong><br> 乘车路线：<br>
							交通指南 <br> <br> <br> 医院名称<br>
						</p>
					</div>
					<div class="tab-pane fade text-left" id="notice">
						<div class="col-md-12 ">
							<div class="col-md-2">
								<p class="text-left">医院通知</p>
							</div>
						</div>
						<hr width="1300px">
						<table class="table table-striped table-hover ">
							<thead>
								<tr>
									<th>医院通知</th>
									<th>通知名称</th>
									<th>通知时间</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>Column content</td>
									<td>Column content</td>
								</tr>
								<tr>
									<td>2</td>
									<td>Column content</td>

									<td>Column content</td>
								</tr>
								<tr>
									<td>3</td>
									<td>Column content</td>

									<td>Column content</td>
								</tr>
								<tr>
									<td>4</td>
									<td>Column content</td>

									<td>Column content</td>
								</tr>
								<tr>
									<td>5</td>
									<td>Column content</td>

									<td>Column content</td>
								</tr>
								<tr>
									<td>6</td>
									<td>Column content</td>

									<td>Column content</td>
								</tr>
								<tr>
									<td>7</td>
									<td>Column content</td>

									<td>Column content</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="tab-pane fade text-left" id="about">
						<div class="col-md-12 ">
							<div class="col-md-2">
								<p class="text-left">医院简介</p>
							</div>
						</div>
						<hr width="1300px">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中国医学科学院北京协和医学院血液学研究所血液病医院创建于1957年，创办人为**血液学家、教育家邓家栋教授，其前身是中国人民解放军第十三军医学校(后改变为中国人民解放军259医院)，1958年划归卫生部管理，更名为中国医学科学院输血及血液学研究所并设附属医院，1970年迁往四川简阳县组成中国医学科学院分院，1979年回迁天津，1987更名为中国医学科学院中国协和医科大学血液学研究所血液病医院。所院成立50年来，本着“严谨、博精、创新、奉献”的协和精神，成为我国**的集医疗、科研、教学、产业于一体的**科研型血液病专业医疗机构，在血液学及相关领域的研究、血液病防治、新药研制、人才培养等方面取得了许多突出的成就，在国内外享有较高的声誉。 


							所院占地面积4万平方米，建筑面积4.7万平方米，网络设施先进。拥有一支阵容整齐、结构合理、学术精湛、锐意创新的科研医疗队伍，职工795人，其中专业技术人员676人，正**职称23人、副**职称64人；博士生导师10名、硕士生导师22名，有突出贡献专家4人，长江学者特聘教授2人，国家杰出青年基金获得者2人，入选国家百千万人才工程2人，中国医学科学院名医1人，天津市卫生行业“十佳”医务工作者2人。


							所院是实验血液学国家重点实验室、国家干细胞工程技术研究中心的依托单位，内科学(血液病)、药物药理学、细胞分子生物学的全国重点学科点，是国家药物临床试验机构，是世界血友病联盟国家成员单位(中国)的执行部门，是卫生部国家核事故医学应急中心临床一部，承办《中华血液学杂志》的编辑、出版和发行工作。 


							血液病医院是三级甲等专科医院，有病床520张，设有贫血诊疗中心、白血病诊疗中心、干细胞移植中心、淋巴瘤诊疗中心、儿科血液病诊疗中心、MDS诊疗中心、血栓止血诊疗中心、血液病急救中心、综合医疗中心、血液病专家会诊中心和临床检测中心，向国内外患者提供高水平服务和临床科研工作。对常见血液病，特别是恶性血液病的诊断治疗处于国内**水平。成人急性髓系白血病完全缓解率在80%以上，五年无病生存率达50%以上；急性再生障碍性贫血的5年生存率达70%以上，重型再生障碍性贫血ATG联合免疫治疗的有效率80%。自1987年率先在国内完成**例自体骨髓造血干细胞移植以来，移植病人560余例,长期存活(＞5年)率在50%以上。儿童血液病主要病种疗效达国际先进水平，儿童急性淋巴细胞白血病5年的无病生存率为75%～80%，儿童急性髓系白血病5年的无病生存率为40%～60%，其中急性早幼粒细胞白血病5年的无病生存率为85%。实验检测中心有临床检验、生化、免疫、细菌、出凝血、溶血、细胞形态、组织化学、染色体、细胞培养、流式细胞术分析、分子生物学、核医学、病理13个专业实验室，开展400余项检验项目，涵盖了辅助血液病诊断的检测。专家会诊中心有数名国内外知名的血液病专家应诊，对特殊血液病、疑难重症血液病提出诊断、治疗方案及预后咨询。医院年门诊量4万余人次。


							血液学研究所设有造血干细胞、止血血栓与血管、药理及药物学、细胞分子生物学、免疫与生物治疗和血液肿瘤分子生物学6个学科，主要研究方向为造血组织干细胞生物学及可塑性研究、造血调控及血液血管生成调控分子的基础与应用基础、正常与病理造血细胞和免疫细胞的生长发育，特别是恶性血液病的发病机制等。建立了干细胞库技术平台，干细胞临床移植技术平台，抗体制备技术平台，基因工程药物GMP中试平台，高通量药物筛选技术平台，SPF级实验动物技术平台等共用技术平台。


							国家设立基金项目以来，所院承担科研项目399项，其中包括国家攻关、863、973、攀登计划、杰出青年基金、自然科学基金144项，省部级课题176项。获得省部级以上成果奖130项，发明专利24项，出版专著80部，共发表论文4332篇，其中SCI收录论文从1997年开始统计共206篇。


							所院设有博士点4个，已毕业博士研究生131名，在读博士研究生79名；硕士点8个，毕业硕士生164名，在读硕士生196名；博士后流动站已培养国内外数名博士后研究人员。所院接待来自全国各地的进修生1600余人，为我国培养了大量血液病研究、治疗的骨干力量。


							所院积极开展国际交流与合作，与美国国立卫生研究院心肺血液研究所、法国血管与血液学研究所、加拿大Calgary大学Foothills医院血友病中心、香港科技大学等有良好的科研及人员交流合作关系。


							所院的科技成果转化工作也取得显著进步。以干细胞相关技术和单克隆抗体制备技术组成的干细胞产品产业化项目，被列为天津市重大产业化项目、国家高新技术产品产业化示范项目。2001年以技术成果出资，与企业合作，组建了“协和干细胞基因工程有限公司”，建立了符合国际规范标准的“天津市脐带血造血干细胞库”，通过了卫生部的执业验收，得到了亚洲脐血库组织的认可。


							面对新机遇和挑战，我们将加强所院的内涵建设，创造一个和谐稳定的所院环境，加强科学创新体系建设，培养造就一个高水平的创新团队，使所院科研、医疗和教学水平进一步提高，将所院建设成为国内**、国际知名的研究型血液病专科医院。所院全体职工时刻以“严谨、博精、创新、奉献”的协和精神，全心全意为病人提供更加优质高效服务，为血液学事业的发展而努力。.</p>
					</div>
					<div class="tab-pane fade text-left" id="equipment">
						<div class="col-md-12 ">
							<div class="col-md-2">
								<p class="text-left">医院设备</p>
							</div>
						</div>
						<hr width="1300px">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;全身X线计算机断层摄影机、发射型计算机断层摄影机、医用直线加速器、放疗计划系统、全身CT、头颅CT、ECT、彩色多普勒心脏诊察仪、放疗计划治疗系统等.</p>
					</div>
					<div class="tab-pane fade text-left" id="honor">
						<div class="col-md-12 ">
							<div class="col-md-2">
								<p class="text-left">医院荣誉</p>
							</div>
						</div>
						<hr width="1300px">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1、医院获得“天津市基本医疗保险诚信建设单项管理先进单位”，获奖金10万元。

							2、药剂科团支部获得“天津市学校系统**团支部”称号； 3、移植中心获得“天津市‘五一’劳动奖状；

							4、杨仁池同志获得“天津市‘五一’劳动奖章； 5、常子奎同志获得“天津市劳动模范”称号；

							6、王建祥、韩明哲二同志获得“医保诚信建设先进个人”称号； 7、张磊同志获得“天津市新长征突击手”称号；

							8、马双同志获得“天津市教卫系统**组工干部”称号； 9、赵纯同志获得“天津市科技统计工作先进个人”称号；

							10、李庆华同志获得国家“留学回国人员择优资助”； 11、刘雪梅同志获得“天津市统计局劳资统计先进个人

							12、王庭顺同志获得“天津市公安局文保系统个人三等功”；.</p>
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
</html>