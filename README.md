# ssm_pro

### bug
因为时间预约信息是假数据，控制预约日历显示的代码在[data/index.js](https://github.com/sfturing/hosp_order/blob/master/ssm_pro/src/main/webapp/assets/date/js/index.js)，因为js写的有点bug出现不能显示的问题。
如果想要试试日历显示效果请修改代码.
var dp = new Datepicker($('.a'), year, month, day);日期改为今天日期。例如. var dp = new Datepicker($('.a'),'1996', '03', '10');



医院预约挂号系统，实现基本预约挂号，预留后台管理系统接口，时间数据为假数据。

提供医生科室医生查询。

使用ssm框架，maven管理依赖jar包


项目以做学习交流为目的。因为项目经验不足，项目可能会有很多潜在的问题，希望多多指教。如果觉得不错，请为它[STAR](https://github.com/sfturing/hosp_order/stargazers)！


目前邮箱暂停注册完善服务，可自行更换邮箱发送,项目目前暂停更新，感谢大家支持。


项目暂停维护。




