package com.busbooking.service;

import java.util.Date;

import com.busbooking.model.BookingInfo;
import com.busbooking.model.Bus;
import com.busbooking.model.User;

public interface BookingManager {

	BookingInfo doBooking(User user, Bus bus,String fromCity,String toCity, Date date);
	
	boolean cancelBooking(int bookingId);
	
	BookingInfo updateBooking(int bookingId, Bus bus,String fromCity,String toCity, Date date);
}
