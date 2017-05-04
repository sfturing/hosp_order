package cn.sfturing.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * 时间工具类
 * 所有跟时间相关的工具集合
 * @author Administrator
 *
 */
@Component
public class DateUtil {
	private static final Logger log = LoggerFactory.getLogger(DateUtil.class);
	
	/**
	 * 时间格式
	 * @author Administrator
	 *
	 */
	public enum DateFormat{
		YYYY_MM_DD_HH_mm_ss("yyyy-MM-dd HH:mm:ss"),
		YYYY_MM_DD("yyyy-MM-dd"),
		YYYYMMDDHHMMSS("yyyyMMddHHmmss");
		
		private String value;
		DateFormat(String value){
			this.value = value;
		}
		
		public String getValue(){
			return this.value;
		}
	}
	/**
	 * 当前时间
	 * @param format
	 * @return
	 */
	public String getCurrentTime(DateFormat format){
		
		Date date = new Date();// 当前日期
		SimpleDateFormat sdf = new SimpleDateFormat(format.getValue());// 格式化对象
		return sdf.format(date);
	}
	
	/**
	 * 格式化时间
	 * @param format
	 * @return
	 */
	public String getFormatTime(String time, DateFormat format){
		
		SimpleDateFormat sdf = new SimpleDateFormat(format.getValue());// 格式化对象
		
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date!=null?sdf.format(date):time;
	}
	
	/**
	 * 过去时间
	 * @param time
	 * @return
	 */
	public boolean isPassedTime(String time){
		boolean result = false;
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat.YYYY_MM_DD_HH_mm_ss.getValue());
		try {
			
			Date date = sdf.parse(time);
			result = date.getTime() <= new Date().getTime();
		} catch (ParseException e) {
			
			log.error("please parse correct format time {}", time);
		}
		
		return result;
	}
	
	/**
	 * 时间相减  开始时间 paramSystemTime 系统时间
	 * 
	 * @return 时间相减工具方法 Second(秒) 
	 */
	public int timeSubtractionSecond(String paramSystemTime,String startTime) {
		int resultTime = 0;// 结果时间
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat.YYYY_MM_DD_HH_mm_ss.getValue());// 格式化对象
		Calendar calSystem = Calendar.getInstance();// 系统时间
		Calendar calStart = Calendar.getInstance();// 开始时间
		try {
			calSystem.setTime(sdf.parse(paramSystemTime));
			calStart.setTime(sdf.parse(startTime));
			long l=calStart.getTimeInMillis()-calSystem.getTimeInMillis();
			resultTime=new Long(l/1000).intValue();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("时间相减  开始时间 paramSystemTime 系统时间 {},{}", paramSystemTime + startTime);
		}
		
		return resultTime;
	}
	
	/**
	 * 在日期上减去天数
	 * @param date
	 * @param dateFormat
	 * @param numDay
	 * @return
	 */
	public String subDayOfMonth(String date, DateFormat dateFormat, int numDay){
		
		SimpleDateFormat df = new SimpleDateFormat(dateFormat.getValue());
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(df.parse(date));
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - numDay);
			
			return df.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.print(e);
			return null;
		}
	}
	
	/**
	 * 日期加上天数
	 * @param date
	 * @param dateFormat
	 * @param numDay
	 * @return
	 */
	public String addDayOfMonth(String date, DateFormat dateFormat, int numDay){
		
		SimpleDateFormat df = new SimpleDateFormat(dateFormat.getValue());
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(df.parse(date));
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + numDay);
			
			return df.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.print(e);
			return null;
		}
	}
	
	/**
	 * 在日期上减去秒
	 * @param date
	 * @param dateFormat
	 * @param numDay
	 * @return
	 */
	public String subSecondOfDay(String date, DateFormat dateFormat, int second){
		
		SimpleDateFormat df = new SimpleDateFormat(dateFormat.getValue());
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(df.parse(date));
			c.set(Calendar.SECOND, c.get(Calendar.SECOND) - second);
			
			return df.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.print(e);
			return null;
		}
	}
	
	public String getDate(){
		//获得日期
		Calendar ca = Calendar.getInstance();
		String year = String.valueOf(ca.get(Calendar.YEAR));//获取年份
		String month = String.valueOf(ca.get(Calendar.MONTH)+1);//获取月份 
		if(ca.get(Calendar.MONTH) < 10){
			month = "0" + month;
		}
		String day = String.valueOf(ca.get(Calendar.DATE));//获取日
		if(ca.get(Calendar.DATE) < 10){
			day = "0" + day;
		}
		String date = year + month + day;
		
		return date;
	}
	
	/**
	 * 日期减月数
	 * @param date
	 * @param dateFormat
	 * @param monthNum
	 * @return
	 */
	public String subMonth(String date, DateFormat dateFormat, int monthNum){
		
		SimpleDateFormat df = new SimpleDateFormat(dateFormat.getValue());
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(df.parse(date));
			c.set(Calendar.MONTH, c.get(Calendar.MONTH) - monthNum);
			
			return df.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.print(e);
			return null;
		}
	}
	
	/**
	 * 两个日期之间相差的月数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int betweenDurations(String startDate, String endDate){
		
		int month = 0;
		int day = 0;
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat.YYYY_MM_DD.getValue());
		Calendar startCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		try {
			startCalendar.setTime(sdf.parse(startDate));
			endCalendar.setTime(sdf.parse(endDate));
			
			month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
			day = endCalendar.get(Calendar.DAY_OF_MONTH) - startCalendar.get(Calendar.DAY_OF_MONTH);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("date format exception, start date " + startDate + ", end date " + endDate);
		}
		
		if(day > 0){
			month = month + 1;
		}
		
		return month;
	}
	
	/**
	 * 时间相差天数
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public int betweenDays(String startTime,String endTime) {
		
		int seconds = timeSubtractionSecond(startTime, endTime);
		return seconds/60/60/24;
	}

}

