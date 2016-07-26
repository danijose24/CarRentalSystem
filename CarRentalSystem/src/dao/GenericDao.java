package dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import exception.UserDefinedException;

/**
 * <h1>GenericDao</h1>
 * <p>
 * The class Generic Dao is the Base class for UserDao, BookingDao, CarDao, MakeDao.
 * The class Generic Dao is used to get connnection for session fatory.
 * And this class is used to close the connection.
 * </p>
 *
 * @author sudhakar
 * @version 1.0
 * @created 25-07-2016
 */
public class GenericDao {
	
    protected static SessionFactory sessionFactory; 
	static {
		getConnction();
	}
   /**
    * The method getConnection is used to get the session factory connection.
    *
    */
    public static void getConnction() {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            System.out.println(sessionFactory);
        } catch (Throwable ex) { 
            System.out.println("Failed to Create SessionFactory object." + ex);
            System.out.println(ex); 
        }
    }
    /**
    * The method open session is used to open the session.
    *
    */
    public Session openSession() throws UserDefinedException {
        try {
            if (null != sessionFactory) {
                return sessionFactory.openSession();
            } else {
                throw new UserDefinedException("Failed to open the session factory");
            }
        } catch (HibernateException e) {
            throw new UserDefinedException("Failed to open the session factory", e);
        }
    }
    /**
    * The method close session is used to close the session.
    *
    */
    public void closeSession(Session session) {
        try {
            session.close();
        } catch (HibernateException e) {
            System.out.println("Can't able to Close the Session...");
        }
    }
}

