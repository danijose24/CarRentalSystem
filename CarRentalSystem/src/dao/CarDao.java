package dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Transaction;

import model.Car;
import exception.UserDefinedException;

public class CarDao extends GenericDao {
	
	public void insertCar(Car car) throws UserDefinedException {
	    Transaction transaction = null;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        session.save(car);
	        transaction.commit();
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Car details added Failed!...",e);
	    } finally {
	        closeSession();
	    }
	}

	public Car findCar(int carId) throws UserDefinedException {
	    Transaction transaction = null;
	    Car car;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        car = (Car)session.get(Car.class, carId);
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to find for this car Id: "+carId, e);
	    } finally {
	        closeSession();
	    }
	    return car;
	}

	public boolean deleteCar(int carId) throws UserDefinedException {
	    Transaction transaction = null;
	    try {
	        openSession();
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
	        closeSession();
	    }
	}
 
	public List<Car> retrieveCarDetails() throws UserDefinedException {
	    Transaction transaction = null;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        List<Car> cars = session.createQuery("FROM Car").list();
	        return cars;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Car details can not be Displayed!...",e);
	    } finally {
	        closeSession();
	    }
    }

	public boolean updateCar(Car car) throws UserDefinedException {
	    Transaction transaction = null;
	    try {
	        openSession();
	        transaction = session.beginTransaction();
	        session.update(car); 
	        transaction.commit();
	        return true;
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to update for this car", e);
	    } finally {
	        closeSession();
	    }
	}
}
