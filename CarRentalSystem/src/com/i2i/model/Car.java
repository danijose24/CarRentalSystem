/**
 * 
 */
package com.i2i.model;

import java.util.HashSet;
import java.util.Set;

import com.i2i.model.Booking;
/**
 * @author sudhakar
 *
 */
public class Car {
	private int id;
	private int carType;
	private String carNumber;
	private Make make;
    private Set<Booking> bookings = new HashSet<Booking>();

	/**
	 * @param id
	 * @param makeId
	 * @param carType
	 * @param carNumber
	 */
	public Car(int carType, String carNumber) {
		this.carType = carType;
		this.carNumber = carNumber;
	}
	
	public Car() {}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the carType
	 */
	public int getCarType() {
		return carType;
	}
	/**
	 * @param carType the carType to set
	 */
	public void setCarType(int carType) {
		this.carType = carType;
	}
	/**
	 * @return the carNumber
	 */
	public String getCarNumber() {
		return carNumber;
	}
	/**
	 * @param carNumber the carNumber to set
	 */
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	/**
	 * @return the bookings
	 */
	public Set<Booking> getBookings() {
		return bookings;
	}
	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
	/**
	 * @return the make
	 */
	public Make getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(Make make) {
		this.make = make;
	}
}
