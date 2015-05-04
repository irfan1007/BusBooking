package com.busbooking.model;

import java.io.Serializable;


public class Bus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3271060942618856965L;
	public enum BUS_TYPE{
		SLEEPER,SEMI_SLEEPER,SITTING;
	}
	
	private int busId;
	private int seatsAvailable;
	private BUS_TYPE type ;
	private String operatorName;
	private double price;
	private String fromCity;
	private String toCity;
	private String date;
	
	public int getBusId() {
		return busId;
	}
	public BUS_TYPE getType() {
		return type;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public void setType(BUS_TYPE type) {
		this.type = type;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((fromCity == null) ? 0 : fromCity.hashCode());
		result = prime * result
				+ ((operatorName == null) ? 0 : operatorName.hashCode());
		result = prime * result + ((toCity == null) ? 0 : toCity.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (fromCity == null) {
			if (other.fromCity != null)
				return false;
		} else if (!fromCity.equals(other.fromCity))
			return false;
		if (operatorName == null) {
			if (other.operatorName != null)
				return false;
		} else if (!operatorName.equals(other.operatorName))
			return false;
		if (toCity == null) {
			if (other.toCity != null)
				return false;
		} else if (!toCity.equals(other.toCity))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return " Bus Id : "+busId+" , From : "+fromCity+" , To : "+toCity+" , Date : "+date+ " , Operator : "+operatorName;
	}
}
