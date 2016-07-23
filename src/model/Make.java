/**
 * 
 */
package model;

/**
 * @author ideas2it
 *
 */
public class Make {
	private String id;
	private String name;
	private int rate;
	
	/**
	 * @param makeId
	 * @param name
	 * @param rate
	 */
	public Make(String id, String name, int rate) {
		super();
		this.id = id;
		this.name = name;
		this.rate = rate;
	}

	/**
	 * @return the makeId
	 */
	
	public String getId() {
		return id;
	}
	
	/**
	 * @param makeId the makeId to set
	 */
	public void setid(String id) {
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
	
	

}
