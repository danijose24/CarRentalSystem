package dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Make;
import exception.UserDefinedException;

public class MakeDao extends GenericDao {
	
	public void insertMake(Make make) throws UserDefinedException {
	    Transaction transaction = null;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        session.save(make);
	        transaction.commit();
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Make details added Failed!...",e);
	    } finally {
	        closeSession();
	    }
	}

	public Make findMake(int makeId) throws UserDefinedException {
	    Transaction transaction = null;
	    Make make;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        make = (Make)session.get(Make.class, makeId);
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to find for this Make Id: "+makeId, e);
	    } finally {
	        closeSession();
	    }
	    return make;
	}

	public boolean deleteMake(int makeId) throws UserDefinedException {
	    Transaction transaction = null;
	    try {
	        openSession();
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
	        closeSession();
	    }
	}
 
	public List<Make> retrieveMakeDetails() throws UserDefinedException {
	    Transaction transaction = null;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        List<Make> makes = session.createQuery("FROM Make").list();
	        return makes;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Make details can not be Displayed!...",e);
	    } finally {
	        closeSession();
	    }
    }

	public boolean updateMake(Make make) throws UserDefinedException {
	    Transaction transaction = null;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        session.update(make); 
	        transaction.commit();
	        return true;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to update for this make", e);
	    } finally {
	        closeSession();
	    }
	}
}
