package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.i2i.model.Make;
import com.i2i.exception.UserDefinedException;

/**
 *<h1>MakeDao</h1>
 * <p>
 * The class MakeDao is the derived class of GenericDao.
 * This class handles the hibernate operations for different make methods.
 * </p>
 *
 * @author sudhakar
 * @version 1.0
 * @created 25-07-2016
 */
public class MakeDao extends GenericDao {
	
	/**
	 * <p>
	 * The method insert Make is used to insert the make details to the database.
	 * </p>
	 * @param Make make 
	 *         make object should be in Make type. 
	 * @throws UserDefinedException
	 *          If there is any exception occurs in inserting the make details through session object.
	 */
	public void insertMake(Make make) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = openSession();
	    try {
	        transaction = session.beginTransaction();
	        session.save(make);
	        transaction.commit();
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Make details added Failed!...",e);
	    } finally {
	        closeSession(session);
	    }
	}

	/**
	 * <p>
	 * The method find Make is used to find the particular make details from the database.
	 * </p>
	 * @param int makeId
	 *             makeId should be in integer type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in finding the make details through session object.     
	 * @return make
	 *          returns the make object to MakeService.
	 *
	 */
	public Make findMake(String makeId) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = openSession();
	    Make make;
	    try {
	        transaction = session.beginTransaction();
	        make = (Make)session.get(Make.class, makeId);
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to find for this Make Id: "+makeId, e);
	    } finally {
	        closeSession(session);
	    }
	    return make;
	}

	/**
	 * <p>
	 * The method delete Make is used to delete the particular make details from the database.
	 * </p>
	 * @param int makeId
	 *             makeId should be in integer type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in deleting the make details through session object.     
	 * @return boolean
	 *          returns true if the Make object is deleted from the database.
	 *
	 */
	public boolean deleteMake(String makeId) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = openSession();
	    try {
	        transaction = session.beginTransaction();
	        Make make = (Make)session.get(Make.class, makeId); 
	        session.delete(make);
	        transaction.commit();
	        return true;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to delete for this make Id: "+makeId, e);
	    } catch (IllegalArgumentException e) {
	        throw new UserDefinedException("The make Id "+makeId+" is not available", e);
	    } finally {
	        closeSession(session);
	    }
	}
 
	/**
     * <p>
     * The retrieve Make Details method is used to retrieve all makes from the database.
     * </p>   
     * @return List<Make>
     *          returns the list of makes to MakeService.  
     * @throws UserDefinedException
     *          If there is any exception occurs in retrieve make Details.
     */
	public List<Make> retrieveMakeDetails() throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = openSession();
	    try {
	        transaction = session.beginTransaction();
	        List<Make> makes = session.createQuery("FROM Make").list();
	        return makes;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Make details can not be Displayed!...",e);
	    } finally {
	        closeSession(session);
	    }
    }

	/**
	 * <p>
	 * The method update Make is used to update the particular make details from the database.
	 * </p>
	 * @param Make make
	 *         make object should be in Make type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in updating the make details through session object.     
	 * @return boolean
	 *          returns true if the make object is updated from the database.
	 *
	 */
	public boolean updateMake(Make make) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = openSession();
	    try {
	        transaction = session.beginTransaction();
	        session.update(make); 
	        transaction.commit();
	        return true;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to update for this make", e);
	    } finally {
	        closeSession(session);
	    }
	}
}
