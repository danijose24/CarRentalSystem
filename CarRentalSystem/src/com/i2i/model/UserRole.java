/**
 * 
 */
package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserRole")
public class UserRole {
	
	@Id
	@GeneratedValue
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "roleId")
	private int roleId;
	
	public UserRole() {}
	
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
