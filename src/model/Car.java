/**
 * 
 */
package model;

/**
 * @author ideas2it
 *
 */
public class Car {
	private String carId;
	private String makeId;
	private String type;
	private String carNumber;
	/**
	 * @param carId
	 * @param makeId
	 * @param type
	 * @param carNumber
	 */
	public Car(String carId, String makeId, String type, String carNumber) {
		super();
		this.carId = carId;
		this.makeId = makeId;
		this.type = type;
		this.carNumber = carNumber;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
