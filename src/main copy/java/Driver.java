import java.util.ArrayList;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

//@RestController
//@EnableAutoConfiguration
public class Driver {

/*	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/vehiclescore")
	String vehicleScore() {
		vehicleScore.printInOrder();
		return vehicleScore.outputArray();
	}

	@RequestMapping("/carsipp")
	String carSIPP() {
		return carSIPP.returnCarSpecs();
	}

	@RequestMapping("/carprices")
	String carPrices() {
		return priceOrder.returnPrices();
	}

	@RequestMapping("/supplierrating")
	String supRating() {
		return supRating.returnRatings();
	}
*/
	private static PriceOrderOfCar 	priceOrder; // Prints out order of cars by price

	private static CarSIPP 			carSIPP; //specification of the vehicles based on their SIPP

	private static SupplierRating 	supRating;

	private static VehicleScore   	vehicleScore;


	public static void main(String[] args) throws Exception {
		JSONObj jObj = new JSONObj();

		ArrayList<VehicleStat> vehicles = jObj.returnArrayOfVehicles(); // returns an array of vehicle stats

		priceOrder = new PriceOrderOfCar(vehicles); // Prints out order of cars by price

		carSIPP    = new CarSIPP(vehicles); //specification of the vehicles based on their SIPP
		System.out.println(carSIPP.returnCarSpecs());
		supRating   = new SupplierRating(vehicles);

		vehicleScore= new VehicleScore(vehicles);

	//	SpringApplication.run(Driver.class, args);
	}

}
