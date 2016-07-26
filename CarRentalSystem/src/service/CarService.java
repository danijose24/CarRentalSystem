package service;


import java.util.List;
import java.util.Set;

import model.Car;
import model.Make;
import dao.CarDao;
import exception.UserDefinedException;

/**
 * <p>
 * The CarService class is used to gets the output from CarDao class and returns to the Controller.
 * Inputs also passes through this class to CarDao.
 * </p>
 *
 * @author Sudhakar
 * @created 25-07-2016
 */
public class CarService {
    CarDao carDao = new CarDao();
    /**
     * <p>
     * The add car method is used to add car details to the database,
	 * here we create an object for an car using Car model.
	 * car Object is passed as a parameter to CarDao class to insert into the database.
	 * </p>
	 * @param id         
	 *         id should be in string.
	 * @param carType
	 *         carType should be in int.
	 * @param carNumber
	 *         carNumber should be in string.
	 * @throws UserDefinedException
	 *          If there is failed in inserting operation.           
	 */
	public void addCar(String id, int carType, String carNumber) throws UserDefinedException {
		    Car car = new Car(id, carType, carNumber);
		    carDao.insertCar(car);
	}

	/**
	 * <p>
	 * This method is used to find particular car by using carId. 
	 * </p>
	 * @param carId
	 *         used to find car
	 * @return Car 
	 *         returns the Car object to Controller class.
	 * @throws UserDefinedException 
	 *         If there is failed to find car details.                        
	 */
	public Car findCarById(String carId) throws UserDefinedException {
	    return carDao.findCar(carId);
	}
    /**
     * <p>
	 * This method is used to remove particular car by using carId. 
     * </p>
	 * @param carId
	 *         used to remove car
	 * @return boolean 
	 *         returns true if the car details is removed.
	 * @throws UserDefinedException 
	 *         If there is failed to remove car details.                        
	 */
	 public boolean removeCarById(int carId) throws UserDefinedException {
	     return carDao.deleteCar(carId);
	 }
    /**
	 * <p>
	 * This method is used to display all the car details. 
	 * </p>
	 * @return List<Car> 
	 *         returns list of cars to the controller.
	 * @throws UserDefinedException 
	 *         If there is failed to display all cars details.                        
	 */
	 public List<Car> totalCarsDetails() throws UserDefinedException {
	     return carDao.retrieveCarDetails();
	 }

	/**
	 * <p>
	 * This method is used to update particular car by using carId. 
	 * </p>
	 * @param carId
	 *         used to find car
	 * @param makeId         
	 *         makeId should be in String.
	 * @param carType
	 *         carType should be in int.
	 * @param carNumber
	 *         carNumber should be in String.
	 * @return boolean 
	 *         returns true if the car details is updated.
	 * @throws UserDefinedException 
	 *         if there is failed in updating car details.                        
	 */
	 public boolean updateCarById(String carId, int carType, String carNumber) throws UserDefinedException {
	     Car car = findCarById(carId);
	     car.setCarType(carType);
	     car.setCarNumber(carNumber);
	     return carDao.updateCar(car);
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
	 public void assignMakeToCars(Set<Car> cars, Make make) throws UserDefinedException {
        for (Car car : cars) {
        	carDao.allocateMakeToCars(car, make);
	       }
    }
	 
}
