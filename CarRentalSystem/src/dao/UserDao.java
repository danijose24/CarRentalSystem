package dao;

import java.util.List;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;
import exception.UserDefinedException;

/**
 *<h1>UserDao</h1>
 * <p>
 * The class UserDao is the derived class of GenericDao.
 * This class handles the hibernate operations for different user methods.
 * </p>
 *
 * @author sudhakar
 * @version 1.0
 * @created 25-07-2016
 */
public class UserDao extends GenericDao {

	/**
	 * <p>
	 * The method insert User is used to insert the user details to the database.
	 * </p>
	 * @param User user 
	 *         user object should be in User type. 
	 * @throws UserDefinedException
	 *          If there is any exception occurs in inserting the user details through session object.
	 */
	public void insertUser(User user) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = null;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        session.save(user);
	        transaction.commit();
	    } catch (HibernateException e) {
	        throw new UserDefinedException("User details added Failed!...",e);
	    } finally {
	        closeSession();
	    }
	}

	/**
	 * <p>
	 * The method find User is used to find the particular user details from the database.
	 * </p>
	 * @param int userId
	 *             userId should be in integer type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in finding the user details through session object.     
	 * @return user
	 *          returns the user object to UserService.
	 *
	 */
	public User findUser(int userId) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = null;
	    User user;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        user = (User)session.get(User.class, userId);
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to find for this user Id: "+userId, e);
	    } finally {
	        closeSession();
	    }
	    return user;
	}

    /**
	 * <p>
	 * The method delete User is used to delete the particular user details from the database.
	 * </p>
	 * @param int userId
	 *             userId should be in integer type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in deleting the user details through session object.     
	 * @return boolean
	 *          returns true if the User object is deleted from the database.
	 *
	 */
	public boolean deleteUser(int userId) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = null;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        User user = (User)session.get(User.class, userId); 
	        session.delete(user);
	        transaction.commit();
	        return true;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to delete for this user Id: "+userId, e);
	    } catch (IllegalArgumentException e) {
	        throw new UserDefinedException("The user Id "+userId+" is not available", e);
	    } finally {
	        closeSession();
	    }
	}
 
    /**
     * <p>
     * The retrieve User Details method is used to retrieve all users from the database.
     * </p>   
     * @return List<User>
     *          returns the list of users to UserService.  
     * @throws UserDefinedException
     *          If there is any exception occurs in retrieve user Details.
     */
	public List<User> retrieveUserDetails() throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = null;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        List<User> users = session.createQuery("FROM User").list();
	        return users;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("User details can not be Displayed!...",e);
	    } finally {
	        closeSession();
	    }
    }

    /**
	 * <p>
	 * The method update User is used to update the particular user details from the database.
	 * </p>
	 * @param User user
	 *         user object should be in User type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in updating the user details through session object.     
	 * @return boolean
	 *          returns true if the user object is updated from the database.
	 *
	 */
	public boolean updateUser(User user) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = null;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        session.update(user); 
	        transaction.commit();
	        return true;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Could not update for this user", e);
	    } finally {
	        closeSession();
	    }
	}
}