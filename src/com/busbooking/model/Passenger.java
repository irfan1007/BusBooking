package com.busbooking.model;

import java.io.Serializable;

public class Passenger implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7788285425331250345L;
	public static int counter = 1;
	private int bookingId = 0;
	private int busId;
	private int passengerCount;
	private String passengerName;
	private String passengerAge;
	private String passengerPay;
	private String fromCity;
	private String toCity;
	private String date;
	private String userName;
	
	public Passenger(){
		bookingId = counter++;
	}
	
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
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getPassengerCount() {
		return passengerCount;
	}
	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(String passengerAge) {
		this.passengerAge = passengerAge;
	}
	public String getPassengerPay() {
		return passengerPay;
	}
	public void setPassengerPay(String passengerPay) {
		this.passengerPay = passengerPay;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
