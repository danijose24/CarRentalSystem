/**
 * 
 */
package model;

/**
 * @author ideas2it
 *
 */
public class Car {
	private String id;
	private String makeId;
	private String carType;
	private String carNumber;
	/**
	 * @param id
	 * @param makeId
	 * @param carType
	 * @param carNumber
	 */
	public Car(String id, String makeId, String carType, String carNumber) {
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
	public String getCarType() {
		return carType;
	}
	/**
	 * @param carType the carType to set
	 */
	public void setCarType(String carType) {
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
}