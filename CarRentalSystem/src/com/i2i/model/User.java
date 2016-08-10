package com.i2i.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.sql.Timestamp;
import java.util.HashSet;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id")
    private int id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="phoneNumber")
    private String phoneNumber;
	
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Column(name="address")
    private String address;
    
    @Column(name="createdAt")
    private Timestamp createdAt;
    
    @OneToMany(mappedBy="user")
    private Set<Booking> bookings = new HashSet<Booking>();
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Role> roles = new HashSet<Role>();

    /**
	 * @param id
	 * @param name
	 * @param phoneNumber
	 * @param email
	 * @param password
	 * @param address
	 */
	public User(String name, String phoneNumber, String email,
			String password, String address, Timestamp createdAt) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.address = address;
		this.createdAt = createdAt;
	}

	public User() {	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the bookings
	 */
	public Set<Booking> getBookings() {
		return bookings;
	}

	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", password="
				+ password + ", address=" + address + ", createdAt=" + createdAt + ", bookings=" + bookings + ", roles="
				+ roles + "]";
	}
    
}
