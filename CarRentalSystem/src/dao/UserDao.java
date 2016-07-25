package dao;

import java.util.List;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;
import exception.UserDefinedException;

public class UserDao extends GenericDao {

	public void insertUser(User user) throws UserDefinedException {
	    Transaction transaction = null;
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

	public User findUser(int userId) throws UserDefinedException {
	    Transaction transaction = null;
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

	public boolean deleteUser(int userId) throws UserDefinedException {
	    Transaction transaction = null;
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
 
	public List<User> retrieveUserDetails() throws UserDefinedException {
	    Transaction transaction = null;
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

	public boolean updateUser(User user) throws UserDefinedException {
	    Transaction transaction = null;
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

	/*public void allocateProjectToStudents(Student student, Project project) throws UserDefinedException {
	    Transaction transaction = null;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        student.setProject(project);
	        session.update(student);
	        transaction.commit();
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Project could not assign for this Student", e);
	    } finally {
	        closeSession();
	    }
    }*/
}