/**
 * 
 */
package model;

import java.util.HashSet;
import java.util.Set;
import model.Booking;
/**
 * @author sudhakar
 *
 */
public class Car {
	private String id;
	private String makeId;
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
	public Car(String id, String makeId, int carType, String carNumber) {
		this.id = id;
		this.makeId = makeId;
		this.carType = carType;
		this.carNumber = carNumber;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the makeId
	 */
	public String getMakeId() {
		return makeId;
	}
	/**
	 * @param makeId the makeId to set
	 */
	public void setMakeId(String makeId) {
		this.makeId = makeId;
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