package dao;

import java.util.List;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Booking;
import exception.UserDefinedException;

public class BookingDao extends GenericDao {
	
	public void insertBooking(Booking booking) throws UserDefinedException {
	    Transaction transaction = null;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        session.save(booking);
	        transaction.commit();
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Booking details added Failed!...",e);
	    } finally {
	        closeSession();
	    }
	}

	public Booking findBooking(int bookingId) throws UserDefinedException {
	    Transaction transaction = null;
	    Booking booking;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        booking = (Booking)session.get(Booking.class, bookingId);
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to find for this booking Id: "+bookingId, e);
	    } finally {
	        closeSession();
	    }
	    return booking;
	}

	public boolean deleteBooking(int bookingId) throws UserDefinedException {
	    Transaction transaction = null;
	    try {
	        openSession();
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
	        closeSession();
	    }
	}
 
	public List<Booking> retrieveBookingDetails() throws UserDefinedException {
	    Transaction transaction = null;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        List<Booking> bookings = session.createQuery("FROM Booking").list();
	        return bookings;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Booking details can not be Displayed!...",e);
	    } finally {
	        closeSession();
	    }
    }

	public boolean updateBooking(Booking booking) throws UserDefinedException {
	    Transaction transaction = null;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        session.update(booking); 
	        transaction.commit();
	        return true;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Could not update for this booking", e);
	    } finally {
	        closeSession();
	    }
	}
}
