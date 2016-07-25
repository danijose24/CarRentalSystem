package dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import exception.UserDefinedException;

/**
 * @author sudhakar
 *
 */
public class GenericDao {
	
    protected static SessionFactory sessionFactory; 
	protected Session session;
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
    public void openSession() throws UserDefinedException {
        try {
            if (null != sessionFactory) {
                session = sessionFactory.openSession();
            }
        } catch (HibernateException e) {
            throw new UserDefinedException("Failed to open the session factory", e);
        }
    }
    /**
    * The method close session is used to close the session.
    *
    */
    public void closeSession() {
        try {
            session.close();
        } catch (HibernateException e) {
            System.out.println("Can't able to Close the Session...");
        }
    }
}

