/**
 * 
 */
package model;

/**
 * @author ideas2it
 *
 */
public class Make {
	private String makeId;
	private String name;
	private int rate;
	
	public Make(String makeId, String name, int rate) {
		super();
		this.makeId = makeId;
		this.name = name;
		this.rate = rate;
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
	
	

}
