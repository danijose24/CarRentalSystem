/**
 * 
 */
package model;

import java.util.HashSet;
import java.util.Set;
import model.Car;

/**
 * @author sudhakar
 *
 */
public class Make {
	private String id;
	private String name;
	private int rate;
    private Set<Car> cars = new HashSet<Car>();

	/**
	 * @param id
	 * @param name
	 * @param rate
	 */
	public Make(String id, String name, int rate) {
		this.id = id;
		this.name = name;
		this.rate = rate;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the rate
	 */
	public int getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}
	/**
	 * @return the cars
	 */
	public Set<Car> getCars() {
		return cars;
	}
	/**
	 * @param cars the cars to set
	 */
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
}
