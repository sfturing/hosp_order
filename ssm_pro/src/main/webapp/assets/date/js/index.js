// 按钮点击事件
$(function() {
	var Datepicker = function(div, y, m, d) {
		var _this = this;
		this.info_ul = div.find('.order-info-div .oid-ul');
		this.PArr = []; // 预约信息数组
		this.yuyue_td = null; // 临时保存数据操作行
		this.y = y;
		this.m = m;
		this.d = d;
		this.om = m;
		this.div = div;
		this.div.width(800);
		// var months = ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月',
		// '十月', '十一月', '十二月'];

		// 检查当月天数
		function checkLength(y, m) {
			var len = 31;
			var day31 = [ 1, 3, 5, 7, 8, 10, 12 ];
			var str31 = day31.join(",");
			var regExp = eval("/" + (m + 1) + ",|," + (m + 1) + ",|," + (m + 1)
					+ "/g");
			// 判断每个月有多少天
			if (str31.search(regExp) == -1) {
				len = 30;
			}
			if (m == 1) {
				if (y % 4 == 0) {
					if (y % 100 == 0 && y % 400 != 0) {
						len = 28;
					} else
						len = 29;
				} else
					len = 28;
			}
			return len;
		}

		// 创建table数据
		this.createTableNum = function() {
			var table = $('<table></table>');
			table.addClass('date-table');

			var info_tr = $('<tr class="info-title-tr">'
					+ '<td colspan="5"><span class="year-span"></span>年<span class="month-span"></span>月预定信息</td>'
					+ '<td style="text-align: right;" colspan="1"><a class="lastM" href="#">上月</a></td>'
					+ '<td style="text-align: right;" colspan="1"><a class="nextM" href="#">下月</a></td></tr>');

			var week_tr = $('<tr class="week-tr">' + '<td>星期日</td>'
					+ '<td>星期一</td>' + '<td>星期二</td>' + '<td>星期三</td>'
					+ '<td>星期四</td>' + '<td>星期五</td>' + '<td>星期六</td></tr>');

			var plus_tr = $('<tr class="date-plus-tr"><td colspan="7">'
					+ '<label for="shang">上:</label>'
					+ '<input class="s" type="checkbox" id="Checkbox2" checked="" />'
					+ '<label for="zhong">中:</label>'
					+ '<input class="z" type="checkbox" id="Checkbox3" checked="" />'
					+ '<label for="xia">下:</label>'
					+ '<input class="x" type="checkbox" id="Checkbox4" checked="" />'
					+ '<!--<span class="yibeiyuyue-span">已被预约</span>-->'
					+ '<a href="#" class="confirm-anchor">确定</a></td></tr>');

			table.append(info_tr);
			table.append(week_tr);
			table.append(plus_tr);
			this.div.prepend(table);

			for (var i = 0; i < 6; i++) {
				var tr = $('<tr class="date-tr"></tr>');
				for (var j = 0; j < 7; j++) {
					var td = $('<td></td>');
					tr.append(td);
				}
				table.append(tr);
			}
			this.table = table;
			this.td = this.table.find(
					'tr:not(.date-plus-tr):not(.info-title-tr):not(.week-tr)')
					.children('td');

			// table头部信息
			var mSpan = this.table.find('.month-span');
			var ySpan = this.table.find('.year-span');
			ySpan.text(this.y);
			mSpan.text(this.m);

			// 点击下月按钮事件
			this.table.find('.nextM').click(function() {
				if (_this.m == 12) {
					_this.m = 1;
					_this.y = _this.y + 1;
				} else
					_this.m++;

				mSpan.text(_this.m);
				ySpan.text(_this.y);
				_this.initial();

			});
			// 点击上月按钮事件
			this.table.find('.lastM').click(function() {
				if (_this.m == 1) {
					_this.m = 12;
					_this.y = _this.y - 1;
				} else
					_this.m--;

				mSpan.text(_this.m);
				ySpan.text(_this.y);
				_this.initial();
			});
		}

		// 清空table
		this.initialTable = function() {
			this.div.find('table').remove();
			this.createTableNum();
		}

		// 添加日期
		this.dateScale = function(y, m, d) {
			var date = new Date();
			date.setFullYear(y, m - 1, _this.d);
			var y = date.getFullYear();
			var m = date.getMonth();
			var fdate = new Date();
			fdate.setFullYear(y, m, 1);
			var fd = fdate.getDay();
			var dayLength = checkLength(y, m);

			for (var i = 0; i < dayLength; i++) {
				this.td.eq(i + fd).attr('id',
						'd-' + y + '-' + (m + 1) + '-' + (i + 1));
				this.td.eq(i + fd).html('<span>' + (i + 1) + '</span>');
				if (i == _this.d - 1 && _this.d != null && m == (_this.om - 1)) {
					this.td.eq(i + fd).append('<span class="today">今天</span>');
				}
			}
		}

		// 开始执行
		this.initial();
	};
	// 运行控件
	Datepicker.prototype.initial = function() {
		this.initialTable();
		this.dateScale(this.y, this.m, this.d);

		var i = this.PArr.length;
		while (i--)
			this.setKeyuyue(this.PArr[i].date, this.PArr[i].p);
	}
	// 指定可预约日期
	Datepicker.prototype.setKeyuyue = function(date, p) {
		var _this = this;
		var _id = 'd-' + date;
		var _td = $('#' + _id);
		if (!_td.size())
			return false;
		p.s = p.s == 'true' ? true : p.s;
		p.z = p.z == 'true' ? true : p.z;
		p.x = p.x == 'true' ? true : p.x;
		if (p.s == false && p.z == false && p.x == false) {
			_td.addClass('yuyueyiman-td');
			_td.append('<div class="yuyueyiman-div">预约已满</div>');
			return false;
		} else {
			_td.addClass('keyuyue-td');
			_td.append('<div class="keyuyue-div">可预约</div>');
		}
		_td
				.on(
						'click',
						function() {
							if (_this.yuyue_td != null) {
								$('.clone').remove();
								if (_this.yuyue_td.attr('id') == _id) {
									_this.yuyue_td = null;
									return false;
								}
							}
							var cloneTr = $('.date-plus-tr').clone();
							cloneTr.addClass('clone');

							if (p.s) {
								cloneTr.find('.s')
										.prop('checked', ''/* p.s */);
							} else {
								cloneTr
										.find('.s')
										.replaceWith(
												'<span class="yibeiyuyue-span">已被预约</span>');
							}
							if (p.z) {
								cloneTr.find('.z')
										.prop('checked', ''/* p.z */);
							} else {
								cloneTr
										.find('.z')
										.replaceWith(
												'<span class="yibeiyuyue-span">已被预约</span>');
							}
							if (p.x) {
								cloneTr.find('.x')
										.prop('checked', ''/* p.x */);
							} else {
								cloneTr
										.find('.x')
										.replaceWith(
												'<span class="yibeiyuyue-span">已被预约</span>');
							}
							_td.parent('tr').after(cloneTr);
							cloneTr.show();

							// 临时值保存为当前td;
							_this.yuyue_td = _td;

							// 添加弹出行的确定按钮事件
							cloneTr
									.find('.confirm-anchor')
									.on(
											'click',
											function() {
												/*
												 * 添加按钮事件
												 * 
												 */

												var s = cloneTr.find('.s');
												var z = cloneTr.find('.z');
												var x = cloneTr.find('.x');
												var date = _td.attr('id')
														.substring(2)
														.split('-');

												var returnValue = date[0]
														+ ', ' + date[1] + ', '
														+ date[2] + ', '
														+ s.prop('checked')
														+ ', '
														+ z.prop('checked')
														+ ', '
														+ x.prop('checked');
												// alert(returnValue);

												if (s.prop('checked')
														|| z.prop('checked')
														|| x.prop('checked')) {
													var str = '';
													if (s.prop('checked')) {
														str = '上午';
													}
													if (z.prop('checked')) {
														str += '中午';
													}
													if (x.prop('checked')) {
														str += '下午';
													}

													if (str.substring(
															str.length - 1,
															str.length) == '，') {
														str = str.substring(0,
																str.length - 1);
													}
													alert(date);
													_this.info_ul
															.append('<li><p class="oid-'
																	+ date
																			.join('-')
																	+ '">您已成功预约：'
																	+ date[0]
																	+ '年'
																	+ date[1]
																	+ '月'
																	+ date[2]
																	+ '日 '
																	+ str
																	+ '</p></li>');
													// intoTempArr.push(new
													// specialDate(date.join('-'),
													// {s: str[0], z: str[1], x:
													// str[2]}));

													/*
													 * var dp = new
													 * Datepicker($('.a'), 2015,
													 * 5, 16); dp.PArr.push(new
													 * specialDate('2015-5-17', {
													 * 's': false, 'z': false,
													 * 'x': false }));
													 * dp.initial();
													 */
												}

												_this.yuyue_td = null;
												cloneTr.remove();
												$(this).unbind();
											});
							return false;
						});
	}

	// 预约信息类
	var specialDate = function(date, p) {
		var d = date.split('-');
		this.y = d[0];
		this.m = d[1];
		this.d = d[2];
		this.date = date;
		this.p = p;
	}

	var intoTempArr = [];
	var myDate = new Date();
	var today = addDate(myDate, 0);
	var year = today.substring(0, 4);
	var month = today.substring(5, 6);
	var day = today.substring(7, 8);
	var dp = new Datepicker($('.a'), year, month, day);
	dp.PArr.push(new specialDate(addDate(myDate, 1), {
		's' : false,
		'z' : false,
		'x' : false
	}));
	dp.PArr.push(new specialDate(addDate(myDate, 2), {
		's' : false,
		'z' : true,
		'x' : false
	}));
	dp.PArr.push(new specialDate(addDate(myDate, 3), {
		's' : false,
		'z' : false,
		'x' : false
	}));
	dp.PArr.push(new specialDate(addDate(myDate, 4), {
		's' : false,
		'z' : true,
		'x' : true
	}));
	dp.PArr.push(new specialDate(addDate(myDate, 5), {
		's' : false,
		'z' : true,
		'x' : true
	}));
	dp.PArr.push(new specialDate(addDate(myDate, 6), {
		's' : true,
		'z' : true,
		'x' : true
	}));
	dp.PArr.push(new specialDate(addDate(myDate, 7), {
		's' : false,
		'z' : true,
		'x' : false
	}));
	dp.PArr.push(new specialDate(addDate(myDate, 8), {
		's' : false,
		'z' : true,
		'x' : false
	}));
	dp.PArr.push(new specialDate(addDate(myDate, 9), {
		's' : false,
		'z' : true,
		'x' : false
	}));
	dp.initial();

});
function addDate(date, days) {
	var d = new Date(date);
	d.setDate(d.getDate() + days);
	var m = d.getMonth() + 1;
	return d.getFullYear() + '-' + m + '-' + d.getDate();
}