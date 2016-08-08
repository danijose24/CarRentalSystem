package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.i2i.model.Car;
import com.i2i.model.Make;
import com.i2i.exception.UserDefinedException;

/**
 *<h1>CarDao</h1>
 * <p>
 * The class CarDao is the derived class of GenericDao.
 * This class handles the hibernate operations for different car methods.
 * </p>
 *
 * @author sudhakar
 * @version 1.0
 * @created 25-07-2016
 */
@Repository("carDao")
public class CarDao extends GenericDao {
	
	/**
	 * <p>
	 * The method insert Car is used to insert the car details to the database.
	 * </p>
	 * @param Car car 
	 *         car object should be in Car type. 
	 * @throws UserDefinedException
	 *          If there is any exception occurs in inserting the car details through session object.
	 */
	public void insertCar(Car car) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = openSession();
	    try {
	        transaction = session.beginTransaction();
	        session.save(car);
	        transaction.commit();
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Car details added Failed!...",e);
	    } finally {
	        closeSession(session);
	    }
	}

	/**
	 * <p>
	 * The method find Car is used to find the particular car details from the database.
	 * </p>
	 * @param int carId
	 *             carId should be in integer type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in finding the car details through session object.     
	 * @return car
	 *          returns the car object to CarService.
	 *
	 */
	public Car findCar(int carId) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = openSession();
	    Car car;
	    try {
	        transaction = session.beginTransaction();
	        car = (Car)session.get(Car.class, carId);
	        transaction.commit();
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to find for this car Id: "+carId, e);
	    } finally {
	        closeSession(session);
	    }
	    return car;
	}

	/**
	 * <p>
	 * The method delete Car is used to delete the particular car details from the database.
	 * </p>
	 * @param int carId
	 *             carId should be in integer type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in deleting the car details through session object.     
	 * @return boolean
	 *          returns true if the Car object is deleted from the database.
	 *
	 */
	public boolean deleteCar(int carId) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = openSession();
	    try {
	        transaction = session.beginTransaction();
	        Car car = (Car)session.get(Car.class, carId); 
	        session.delete(car);
	        transaction.commit();
	        return true;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to delete for this car Id: "+carId, e);
	    } catch (IllegalArgumentException e) {
	        throw new UserDefinedException("The car Id "+carId+" is not available", e);
	    } finally {
	        closeSession(session);
	    }
	}
 
	/**
     * <p>
     * The retrieve Car Details method is used to retrieve all cars from the database.
     * </p>   
     * @return List<Car>
     *          returns the list of cars to CarService.  
     * @throws UserDefinedException
     *          If there is any exception occurs in retrieve car Details.
     */
	public List<Car> retrieveCarDetails() throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = openSession();
	    try {
	        transaction = session.beginTransaction();
	        List<Car> cars = session.createQuery("FROM Car").list();
	        transaction.commit();
	        return cars;
	    } catch (HibernateException e) {
	    	e.printStackTrace();
	        throw new UserDefinedException("Car details can not be Displayed!...",e);
	    } finally {
	        closeSession(session);
	    }
    }

	/**
	 * <p>
	 * The method update Car is used to update the particular car details from the database.
	 * </p>
	 * @param Car car
	 *         car object should be in Car type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in updating the car details through session object.     
	 * @return boolean
	 *          returns true if the car object is updated from the database.
	 *
	 */
	public boolean updateCar(Car car) throws UserDefinedException {
	    Transaction transaction = null;
	    Session session = openSession();
	    try {
	        transaction = session.beginTransaction();
	        session.update(car); 
	        transaction.commit();
	        return true;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to update for this car", e);
	    } finally {
	        closeSession(session);
	    }
	}
	
	/**
	 * <p>
	 * The method allocate Make To Cars is used to allocate a particular Make to many cars.
	 * </p>
	 * @param Car car
	 *         car object should be in Car type.
	 * @param Make make
	 *         make object should be in Make type.
	 * @throws UserDefinedException
	 *        If there is any exception occurs in allocating the make to cars through session object.
	 */
	public void allocateMakeToCars(Car car, Make make) throws UserDefinedException {
		Transaction transaction = null;
		Session session = openSession();
        try {
            transaction = session.beginTransaction();
            car.setMake(make);
            session.update(car);
            transaction.commit();
        } catch (HibernateException e) {
            throw new UserDefinedException("Make could not assign for this car", e);
        } finally {
            closeSession(session);
        }
	}
}
