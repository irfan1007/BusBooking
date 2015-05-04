package com.busbooking.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
	private static final String TIME_FORMAT = "HH:MM aa";
	private static final String DATE_FORMAT = "MM/dd/yyyy";
	private static  SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	private static  SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);

	public static String getDateStr(){
		return dateFormat.format(Calendar.getInstance().getTime());
	}
	
	public static String getDateStr(Date date){
		return dateFormat.format(date);
	}
	
	
	public static String getTimeStr(){
		timeFormat = new SimpleDateFormat(TIME_FORMAT);
		return timeFormat.format(Calendar.getInstance().getTime());
	}
}
