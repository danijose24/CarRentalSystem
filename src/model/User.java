package model;

public class User {
    private int userId;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String address;
    
    public User(int userId, String name, String phone, String email, String password, String address) {
    	this.userId = userId;
    	this.name = name;
    	this.phone = phone;
    	this.email = email;
    	this.password = password;
    	this.address = address;
    }
    
    public void setUserId(int userId) {
    	this.userId = userId;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public void setAddress(String address) {
    	this.address = address;
    }
    
    public int getUserId() {
    	return userId;
    }

    public String getName() {
    	return name;
    }
    
    public String getPhone() {
    	return phone;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public String getAddress() {
    	return address;
    }
}
