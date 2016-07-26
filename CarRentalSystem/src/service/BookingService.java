package service;

import java.util.List;
import java.util.Set;
import java.util.Date;

import model.Booking;
import model.User;
import model.Car;
import dao.BookingDao;
import dao.CarDao;
import exception.UserDefinedException;

/**
 * <p>
 * The BookingService class is used to gets the output from BookingDao class and returns to the Controller.
 * Inputs also passes through this class to BookingDao.
 * </p>
 *
 * @author Sudhakar
 * @created 25-07-2016
 */
public class BookingService {
	BookingDao bookingDao = new BookingDao();
    /**
	 * <p>
	 * The add booking method is used to add booking details to the database,
	 * here we create an object for booking using Booking model.
	 * booking Object is passed as a parameter to BookingDao class to insert into the database.
	 * </p>
	 * @param userId         
	 *         userId should be in int.
	 * @param carId
	 *         carId should be in String.
     * @param pickupDate
	 *         pickupDate should be in Date.
	 * @param dropDate
	 *         dropDate should be in Date.
	 * @param amount
	 *         amount should be in int.
	 * @throws UserDefinedException
	 *          If there is failed in inserting operation.           
	 */
    public void addBooking(int userId, String carId, Date pickupDate,
			Date dropDate, int amount) throws UserDefinedException {
	    Booking booking = new Booking(userId, carId, pickupDate, dropDate, amount);
	    bookingDao.insertBooking(booking);
	}

    /**
	 * <p>
	 * This method is used to find particular booking by using bookingId. 
	 * </p>
	 * @param bookingId
	 *         bookingId should be in int.
	 * @return Booking 
	 *         returns the Booking object to Controller class.
	 * @throws UserDefinedException 
	 *         If there is failed to find booking details.                        
	 */
    public Booking findBookingById(int bookingId) throws UserDefinedException {
	     return bookingDao.findBooking(bookingId);
	 }
     /**
      * <p>
	  * This method is used to remove particular booking by using bookingId. 
	  * </p>
	  * @param bookingId
	  *         used to remove booking
	  * @return boolean 
	  *         returns true if the booking details is removed.
	  * @throws UserDefinedException 
	  *         If there is failed to remove booking details.                        
	  */
	 public boolean removeBookingById(int bookingId) throws UserDefinedException {
	     return bookingDao.deleteBooking(bookingId);
	 }
     /**
      * <p>
	  * This method is used to display all the booking details. 
	  * </p>
	  * @return List<Booking> 
	  *         returns list of bookings to the controller.
	  * @throws UserDefinedException 
	  *         If there is failed to display all booking details.                        
	  */
	 public List<Booking> totalBookingDetails() throws UserDefinedException {
	     return bookingDao.retrieveBookingDetails();
	 }
	 /**
	  * <p>
	  * This method is used to update particular booking by using bookingId. 
	  * </p>
	  * @param bookingId
	  *         used to find booking
	  * @param userId         
	  *         userId should be in int.
	  * @param carId
	  *         carId should be in String.
	  * @param pickupDate
	  *         pickupDate should be in Date.
	  * @param dropDate
	  *         dropDate should be in Date.
	  * @param amount
	  *         amount should be in int.
  	  * @return boolean 
	  *         returns true if the booking details is updated.
	  * @throws UserDefinedException 
	  *         If there is failed in updating booking details.                        
	  */
	 public boolean updateBookingById(int bookingId, int userId, String carId, Date pickupDate,
				Date dropDate, int amount) throws UserDefinedException {
	     Booking booking = findBookingById(bookingId);
	     booking.setUserId(userId);
	     booking.setCarId(carId);
	     booking.setPickupDate(pickupDate);
	     booking.setDropDate(dropDate);
	     booking.setAmount(amount);
	     return bookingDao.updateBooking(booking);
	 }
	 
	 /**
      * <p>
	  * The method assign User To Bookings is used to assign a particular user to many bookings.
	  * </p>
	  * @param set<Booking> bookings
	  *
	  * @param User user
	  *
	  */
	 public void assignUserToBookings(Set<Booking> bookings, User user) throws UserDefinedException {
        for (Booking booking : bookings) {
            bookingDao.allocateUserToBookings(booking, user);
        }
     }
	 /**
      * <p>
	  * The method assign Car To Bookings is used to assign a particular car to many Bookings.
	  * </p>
	  * @param set<Booking> bookings
	  *
	  * @param Car car
	  *
	  */
	 public void assignCarToBookings(Set<Booking> bookings, Car car) throws UserDefinedException {
        for (Booking booking : bookings) {
        	bookingDao.allocateCarToBookings(booking, car);
        }
     }
}