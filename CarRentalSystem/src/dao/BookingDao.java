package dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Booking;
import model.Car;
import model.User;
import exception.UserDefinedException;

/**
 *<h1>BookingDao</h1>
 * <p>
 * The class BookingDao is the derived class of GenericDao.
 * This class handles the hibernate operations for different booking methods.
 * </p>
 *
 * @author sudhakar
 * @version 1.0
 * @created 25-07-2016
 */
public class BookingDao extends GenericDao {
	
	/**
	 * <p>
	 * The method insert Booking is used to insert the booking details to the database.
	 * </p>
	 * @param Booking booking 
	 *         booking object should be in Booking type. 
	 * @throws UserDefinedException
	 *          If there is any exception occurs in inserting the booking details through session object.
	 */
	public void insertBooking(Booking booking) throws UserDefinedException {
	    Transaction transaction = null;
		Session session = openSession();
	    try {
	        transaction = session.beginTransaction();
	        session.save(booking);
	        transaction.commit();
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Booking details added Failed!...",e);
	    } finally {
	        closeSession(session);
	    }
	}

	/**
	 * <p>
	 * The method find Booking is used to find the particular booking details from the database.
	 * </p>
	 * @param int bookingId
	 *             bookingId should be in integer type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in finding the booking details through session object.     
	 * @return booking
	 *          returns the booking object to BookingService.
	 *
	 */
	public Booking findBooking(int bookingId) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = openSession();
	    Booking booking;
	    try {
	        transaction = session.beginTransaction();
	        booking = (Booking)session.get(Booking.class, bookingId);
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to find for this booking Id: "+bookingId, e);
	    } finally {
	        closeSession(session);
	    }
	    return booking;
	}

	/**
	 * <p>
	 * The method delete Booking is used to delete the particular booking details from the database.
	 * </p>
	 * @param int bookingId
	 *             bookingId should be in integer type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in deleting the booking details through session object.     
	 * @return boolean
	 *          returns true if the Booking object is deleted from the database.
	 *
	 */
	public boolean deleteBooking(int bookingId) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = openSession();
	    try {
	        transaction = session.beginTransaction();
	        Booking booking = (Booking)session.get(Booking.class, bookingId); 
	        session.delete(booking);
	        transaction.commit();
	        return true;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to delete for this booking Id: "+bookingId, e);
	    } catch (IllegalArgumentException e) {
	        throw new UserDefinedException("The booking Id "+bookingId+" is not available", e);
	    } finally {
	        closeSession(session);
	    }
	}
 
	/**
     * <p>
     * The retrieve Booking Details method is used to retrieve all bookings from the database.
     * </p>   
     * @return List<Booking>
     *          returns the list of bookings to BookingService.  
     * @throws UserDefinedException
     *          If there is any exception occurs in retrieve booking Details.
     */
	public List<Booking> retrieveBookingDetails() throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = openSession();
	    try {
	        transaction = session.beginTransaction();
	        List<Booking> bookings = session.createQuery("FROM Booking").list();
	        return bookings;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Booking details can not be Displayed!...",e);
	    } finally {
	        closeSession(session);
	    }
    }

	/**
	 * <p>
	 * The method update Booking is used to update the particular booking details from the database.
	 * </p>
	 * @param Booking booking
	 *         booking object should be in Booking type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in updating the booking details through session object.     
	 * @return boolean
	 *          returns true if the booking object is updated from the database.
	 *
	 */
	public boolean updateBooking(Booking booking) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = openSession();
	    try {
	        transaction = session.beginTransaction();
	        session.update(booking); 
	        transaction.commit();
	        return true;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Could not update for this booking", e);
	    } finally {
	        closeSession(session);
	    }
	}
	
    /**
	 * <p>
	 * The method allocate User To Bookings is used to allocate a particular user to many bookings.
	 * </p>
	 * @param Booking booking
	 *
	 * @param User user
	 *
	 * @throws UserDefinedException
	 *        If there is any exception occurs in allocating the user to bookings through session object.
	 */
	public void allocateUserToBookings(Booking booking, User user) throws UserDefinedException {
		Transaction transaction = null;
		Session session = openSession();
        try {
            transaction = session.beginTransaction();
            booking.setUser(user);
            session.update(booking);
            transaction.commit();
        } catch (HibernateException e) {
            throw new UserDefinedException("User could not assign for this Booking", e);
        } finally {
            closeSession(session);
        }
	}
	
    /**
	 * <p>
	 * The method allocate Car To Bookings is used to allocate a particular Car to many bookings.
	 * </p>
	 * @param Booking booking
	 *
	 * @param Car car
	 *
	 * @throws UserDefinedException
	 *        If there is any exception occurs in allocating the car to bookings through session object.
	 */
	public void allocateCarToBookings(Booking booking, Car car) throws UserDefinedException {
		Transaction transaction = null;
		Session session = openSession();
        try {
            transaction = session.beginTransaction();
            booking.setCar(car);
            session.update(booking);
            transaction.commit();
        } catch (HibernateException e) {
            throw new UserDefinedException("Car could not assign for this Booking", e);
        } finally {
            closeSession(session);
        }
	}
}
