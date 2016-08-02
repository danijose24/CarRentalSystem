package com.i2i.service;

import java.util.List;
import java.util.Set;

import com.i2i.model.User;
import com.i2i.dao.UserDao;
import com.i2i.exception.UserDefinedException;

/**
 * <p>
 * The UserService class is used to gets the output from UserDao class and returns to the Controller.
 * Inputs also passes through this class to UserDao.
 * </p>
 *
 * @author Sudhakar
 * @created 25-07-2016
 */
public class UserService {
    UserDao userDao = new UserDao();

    /**
	 * <p>
	 * The add user method is used to add user details to the database,
	 * here we create an object for an user using User model.
	 * user Object is passed as a parameter to UserDao class to insert into the database.
	 * </p>
	 * @param name         
	 *         name should be in string.
	 * @param phoneNumber
	 *         phoneNumber should be in string.
	 * @param email
	 *         email should be in string.
	 * @param password
	 *         password should be in string.
	 * @param address
	 *         address should be in string.
	 * @throws UserDefinedException
	 *          If there is failed in inserting operation.           
	 */
	public void addUser(User user) throws UserDefinedException {
	    System.out.println("enter into service");
	    java.sql.Time createdAt = new java.sql.Time(new java.util.Date().getTime());
        user.setCreatedAt(createdAt);
        System.out.println(user);
	    userDao.insertUser(user);
	}

    /**
	 * <p>
	 * This method is used to find particular user by using userId. 
	 * </p>
	 * @param userId
	 *         used to find User
	 * @return User 
	 *         returns the User object to Controller class.
	 * @throws UserDefinedException 
	 *         If there is failed to find user details.                        
	 */
    public User findUserById(int userId) throws UserDefinedException {
	     return userDao.findUser(userId);
	 }
    /**
     * <p>
	 * This method is used to remove particular user by using userId. 
	 * </p>
	 * @param userId
	 *         used to remove user
	 * @return boolean 
	 *         returns true if the user details is removed.
	 * @throws UserDefinedException 
	 *         If there is failed to remove user details.                        
	 */
	 public boolean removeUserById(int userId) throws UserDefinedException {
	     return userDao.deleteUser(userId);
	 }
    /**
	 * <p>
	 * This method is used to display all the user details. 
	 * </p>
	 * @return List<User> 
	 *         returns list of users to the controller.
	 * @throws UserDefinedException 
	 *         If there is failed to display all users details.                        
	 */
	 public List<User> totalUsersDetails() throws UserDefinedException {
	     return userDao.retrieveUserDetails();
	 }

	/**
	 * <p>
	 * This method is used to update particular user by using userId. 
	 * </p>
	 * @param userId
	 *         used to find User
	 * @param name         
	 *         name should be in String.
	 * @param phoneNumber
	 *         phoneNumber should be in String.
	 * @param email
	 *         email should be in String.
	 * @param password
	 *         password should be in String.
	 * @param address
	 *         address should be in String.
	 * @return boolean 
	 *         returns true if the user details is updated.
	 * @throws UserDefinedException 
	 *         if there is failed in updating user details.                        
	 */
	 public boolean updateUserById(int userId,String name, String phoneNumber, String email, String password, String address) throws UserDefinedException {
	     User user = findUserById(userId);
	     user.setName(name);
	     user.setPhoneNumber(phoneNumber);
	     user.setEmail(email);
	     user.setPassword(password);
	     user.setAddress(address);
	     return userDao.updateUser(user);
	 }
	 
	 public User findUser(User user) throws UserDefinedException{
		 return userDao.searchUser(user);
	 }
}
