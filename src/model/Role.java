/**
 * 
 */
package model;

public class Role {
    private int roleId;
    private String name;
    /**
	 * @param roleId
	 * @param name
	 */
	public Role(int roleId, String name) {
		super();
		this.roleId = roleId;
		this.name = name;
	}
	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
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
