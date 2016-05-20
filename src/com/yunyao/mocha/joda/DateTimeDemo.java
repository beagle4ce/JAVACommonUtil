package com.yunyao.mocha.joda;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * 
 * @author gf
 * 强大的日期, 时间工具类, 大大的简化了日期, 时间操作
 *
 */
public final class DateTimeDemo {
	
	@Test
	public void dateTime() {
		// 固定时间点
		Date _20150101 = new DateTime(2015, 1, 1, 0, 0, 0).toDate();
		System.out.println(DateFormatUtils.format(_20150101, "yyyy-MM-dd HH:mm:ss"));
		
		// 今天零点
		Date today1 = new DateTime().withTimeAtStartOfDay().toDate();
		System.out.println(DateFormatUtils.format(today1, "yyyy-MM-dd HH:mm:ss"));
		// 今天固定时间点
		Date today2 = new DateTime().withTime(12, 0, 0, 0).toDate();
		System.out.println(DateFormatUtils.format(today2, "yyyy-MM-dd HH:mm:ss"));
		
		// 十天前
		Date past10day = new DateTime().withTime(12, 0, 0, 0).minusDays(10).toDate();
		System.out.println(DateFormatUtils.format(past10day, "yyyy-MM-dd HH:mm:ss"));
		
		// 一月前
		Date past1month = new DateTime().withTime(12, 0, 0, 0).minusMonths(1).toDate();
		System.out.println(DateFormatUtils.format(past1month, "yyyy-MM-dd HH:mm:ss"));
		
		// 不好用
		Date __20150101 = DateTime.parse("2015-01-01").toDate();
		System.out.println(DateFormatUtils.format(__20150101, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void get() {
		DateTime now = new DateTime();
		// 位于本周第几天
		System.out.println(now.getDayOfWeek());
		// 位于本月第几天
		System.out.println(now.getDayOfMonth());
		// 位于本年第几天
		System.out.println(now.getDayOfYear());
		
		// 几点
		System.out.println(now.getHourOfDay());
		// 几分
		System.out.println(now.getMinuteOfHour());
		// 几秒
		System.out.println(now.getSecondOfMinute());
	}
	
	@Test
	public void compare() {
		DateTime tomorrow = new DateTime().plusDays(1);
		
		System.out.println(tomorrow.isAfterNow());
		
		System.out.println(tomorrow.isAfter(System.currentTimeMillis()));
	}
}
