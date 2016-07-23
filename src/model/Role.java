/**
 * 
 */
package model;

public class Role {
    private int id;
    private String name;
    /**
	 * @param roleId
	 * @param name
	 */
	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * @return the roleId
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int id) {
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
    
    
}
