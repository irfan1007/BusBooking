package com.busbooking.service;

import java.util.ArrayList;
import java.util.List;

import com.busbooking.model.BookingInfo;
import com.busbooking.model.Bus;
import com.busbooking.model.Passenger;
import com.busbooking.util.DBUtil;
import com.busbooking.util.DateTimeUtil;

public class BusService {

	public static List<Bus> search(BookingInfo bookingQuery) {
		if (bookingQuery == null) {
			return null;
		}
		List<Bus> matchedBusList = new ArrayList<Bus>();

		for (Bus bus : DBUtil.getBusList().values()) {
			if (!matchedBusList.contains(bus)
					&& bus.getFromCity().equals(bookingQuery.getFromCity())
					&& bus.getToCity().equals(bookingQuery.getToCity())
					&& bus.getDate().equals(
							DateTimeUtil.getDateStr(bookingQuery.getDate()))) {
				matchedBusList.add(bus);
			}
		}
		return matchedBusList;
	}

	
	public static void updateBooking(Passenger passenger, boolean isCancel) {
		DBUtil.updateDB(passenger.getBusId(), passenger.getPassengerCount(),isCancel);
		DBUtil.updateUserDB(passenger,isCancel);
	}
}
