/**
 * 
 */
package com.i2i.model;

public class UserRole {
	private int userId;
	private int roleId;
	/**
	 * @param userId
	 * @param roleId
	 */
	public UserRole(int userId, int roleId) {
		this.userId = userId;
		this.roleId = roleId;
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
        
    
}
