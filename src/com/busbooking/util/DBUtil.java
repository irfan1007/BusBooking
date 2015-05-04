package com.busbooking.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.busbooking.model.BookingInfo;
import com.busbooking.model.Bus;
import com.busbooking.model.Passenger;

public class DBUtil {

	private final static String FILE_PATH = "\\resources\\database\\bus_availibility.csv";
	private final static String USER_FILE_PATH = "\\resources\\database\\user.csv";
	private final static String NEW_LINE = "\n";
	private final static String COMMA = ",";

	private static Map<Integer, Bus> DB = new HashMap<Integer, Bus>(25000);
	private static Map<String, List<Passenger>> USER_DB = new HashMap<String, List<Passenger>>();
	private static String path;

	public static void loadDB(String path) {
		DBUtil.path = path;
		try {
			readDB();
			readUserDB();
		} catch (Exception e) {

		}
		if (DB != null && DB.isEmpty()) {

			Calendar CALENDAR = Calendar.getInstance();
			CALENDAR.setTime(new Date());
			int busId = 1;

			for (String fromCity : BookingInfo.CITIES) {
				for (String toCity : BookingInfo.CITIES) {
					if (!fromCity.equals(toCity)) {
						int max_days = 180;
						while (max_days >= 0) {
							CALENDAR.add(Calendar.DATE, (180 - max_days));
							int operatorIndex = 1;
							while (operatorIndex < 4) {
								StringBuffer line = new StringBuffer(100);
								line.append(busId);
								line.append(COMMA);
								busId++;
								line.append(DateTimeUtil.getDateStr(CALENDAR
										.getTime()));
								line.append(COMMA);
								line.append(fromCity);
								line.append(COMMA);
								line.append(toCity);
								line.append(COMMA);
								line.append("Operator-" + operatorIndex);
								line.append(COMMA);
								operatorIndex++;
								line.append("50");
								line.append(COMMA);
								int i = new Random().nextInt(200) + 300;
								line.append(i);
								line.append(NEW_LINE);
								Bus bus = new Bus();
								bus.setBusId(busId);
								bus.setDate(DateTimeUtil.getDateStr(CALENDAR
										.getTime()));
								bus.setFromCity(fromCity);
								bus.setToCity(toCity);
								bus.setOperatorName("Operator-" + operatorIndex);
								bus.setSeatsAvailable(50);
								bus.setPrice(i);
								DB.put(bus.getBusId(), bus);
							}
							CALENDAR.setTime(new Date());
							max_days--;
						}
					}
				}
			}
			saveDB();
		}
	}

	private static void saveDB() {
		FileOutputStream fileOut = null;
		ObjectOutputStream out = null;
		try {
			fileOut = new FileOutputStream(path+FILE_PATH);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(DB);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
				if (fileOut != null)
					fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	@SuppressWarnings("unchecked")
	private static boolean readDB() {
		boolean result = false;
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(path+FILE_PATH));
			try {
				DB = (Map<Integer, Bus>) objectInputStream.readObject();
				result = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} catch (IOException i) {
			i.printStackTrace();
		} finally {
			try {
				if (objectInputStream != null)
					objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return result;

	}

	private static void saveUserDB() {
		FileOutputStream fileOut = null;
		ObjectOutputStream out = null;
		try {
			fileOut = new FileOutputStream(path+USER_FILE_PATH);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(USER_DB);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
				if (fileOut != null)
					fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	@SuppressWarnings("unchecked")
	private static boolean readUserDB() {
		boolean result = false;
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(path+USER_FILE_PATH));
			try {
				USER_DB = (Map<String, List<Passenger>>) objectInputStream
						.readObject();
				result = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} catch (IOException i) {
			i.printStackTrace();
		} finally {
			try {
				if (objectInputStream != null)
					objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return result;

	}

	public static Map<Integer, Bus> getBusList() {
		return Collections.unmodifiableMap(DB);
	}

	public static List<Passenger> getAllBookings() {
		List<Passenger> list = new ArrayList<Passenger>();
		for (List<Passenger> templist : USER_DB.values()) {
			list.addAll(templist);
		}
		return list;
	}

	public static List<Passenger> getUserBookings(String username) {
		return USER_DB.get(username);
	}

	public static void updateDB(int busId, int seats, boolean isCancel) {
		Bus bus = DB.get(busId);
		bus.setSeatsAvailable(isCancel ? bus.getSeatsAvailable() + seats : bus
				.getSeatsAvailable() - seats);
		DB.put(busId, bus);
		saveDB();
	}

	public static void updateUserDB(Passenger passenger, boolean isCancel) {
		String userName = passenger.getUserName();
		if (USER_DB.containsKey(userName)) {
			if (isCancel) {
				USER_DB.get(userName).remove(passenger);
			} else {
				USER_DB.get(userName).add(passenger);
			}
		} else {
			List<Passenger> list = new ArrayList<Passenger>();
			list.add(passenger);
			USER_DB.put(userName, list);
		}
		saveUserDB();
	}
}
