package com.busbooking.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import com.busbooking.controller.DefaultController;

public class BookingInfo {

	public static Set<String> CITIES = new TreeSet<String>();
	static {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(DefaultController.realPath
					+ "/resources/database/cities.properties"));
			
			Enumeration<Object> elements = p.keys();
			while (elements.hasMoreElements()) {
				CITIES.add((String) elements.nextElement());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private final int bookingId;

	public BookingInfo(int bookingId) {
		this.bookingId = bookingId;
	}

	public BookingInfo() {
		this.bookingId = 0;
	}

	private String fromCity;
	private String toCity;
	private Date date;
	private String time;
	private String busInfo;
	private boolean isSuccess;
	private User user;

	public String getFromCity() {

		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date time) {
		this.date = time;
	}

	public String getBusInfo() {
		return busInfo;
	}

	public void setBusInfo(String busInfo) {
		this.busInfo = busInfo;
	}

	public int getBookingId() {
		return bookingId;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public static class BookingBuilder {
		BookingInfo bookingInfo;

		public BookingBuilder(int bookingId) {
			bookingInfo = new BookingInfo(bookingId);
		}

		public BookingInfo user(User user) {
			bookingInfo.setUser(user);
			return bookingInfo;
		}

		public BookingInfo date(Date date) {
			bookingInfo.setDate(date);
			return bookingInfo;
		}

		public BookingInfo fromCity(String city) {
			bookingInfo.setFromCity(city);
			return bookingInfo;
		}

		public BookingInfo toCity(String city) {
			bookingInfo.setToCity(city);
			return bookingInfo;
		}

		public BookingInfo busInfo(String bus) {
			bookingInfo.setBusInfo(bus);
			return bookingInfo;
		}

		public BookingInfo time(String time) {
			bookingInfo.setTime(time);
			return bookingInfo;
		}

		public BookingInfo success(boolean success) {
			bookingInfo.setSuccess(success);
			return bookingInfo;
		}
	}
}
