/**
 * 
 */
package model;

import java.util.Date;

/**
 * @author sudhakar
 *
 */
public class Booking {
	private int id;
	private int userId;
	private String carId;
	private Date pickupDate;
	private Date dropDate;
	private int amount;
	private User user;
	private Car car;
	/**
	 * @param id
	 * @param userId
	 * @param carId
	 * @param pickupDate
	 * @param dropDate
	 * @param amount
	 */
	public Booking(int userId, String carId, Date pickupDate,
			Date dropDate, int amount) {
		this.userId = userId;
		this.carId = carId;
		this.pickupDate = pickupDate;
		this.dropDate = dropDate;
		this.amount = amount;
	}
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
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the carId
	 */
	public String getCarId() {
		return carId;
	}
	/**
	 * @param carId the carId to set
	 */
	public void setCarId(String carId) {
		this.carId = carId;
	}
	/**
	 * @return the pickupDate
	 */
	public Date getPickupDate() {
		return pickupDate;
	}
	/**
	 * @param pickupDate the pickupDate to set
	 */
	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}
	/**
	 * @return the dropDate
	 */
	public Date getDropDate() {
		return dropDate;
	}
	/**
	 * @param dropDate the dropDate to set
	 */
	public void setDropDate(Date dropDate) {
		this.dropDate = dropDate;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}
	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}
	
}
