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
	 * @param carId
	 * @param makeId
	 * @param type
	 * @param carNumber
	 */
	public Car(String id, String makeId, String carType, String carNumber) {
		super();
		this.id = id;
		this.makeId = makeId;
		this.carType = carType;
		this.carNumber = carNumber;
	}
	/**
	 * @return the carId
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param carId the carId to set
	 */
	public void setid(String id) {
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
	 * @return the type
	 */
	public String getCarType() {
		return carType;
	}
	/**
	 * @param type the type to set
	 */
	public void setCarType(String CarType) {
		this.carType = CarType;
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
