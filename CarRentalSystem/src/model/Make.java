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
}
