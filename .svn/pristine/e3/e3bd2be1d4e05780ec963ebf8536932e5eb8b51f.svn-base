package com.steward.commons;

import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间工具
 * 
 * @author mastercheng
 *
 */
public class DateUtils {

	public static final String LONG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 
	 * @param time
	 * @param pattern
	 * @return
	 */
	public static Date String2Date(String time, String pattern) {
		if (StringUtils.isNotEmpty(time)) {
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.US);
				return simpleDateFormat.parse(time);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param date
	 * @param years
	 * @param months
	 * @param days
	 * @return
	 */
	public static Date getAfterDate(Date date,Integer years,Integer months,Integer days){
		
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		if (years != null) {
			calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)+years);
		}
		if (months != null) {
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+months);
		}
		if (days != null) {
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)+days);
		}
		return calendar.getTime();
	}
	
}
