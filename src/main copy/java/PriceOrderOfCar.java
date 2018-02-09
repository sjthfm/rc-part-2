import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author sjthome
 * Send all values as double to string, and let the tree map sort out the prices from low to high for you.
 * 	Print out as well. Admittedly should've used bubble sort but this wasn't specified.
 */
public class PriceOrderOfCar {
	ArrayList<VehicleStat> vehicles;
	TreeMap<Double, String> test = new TreeMap<Double, String>();
	/** insert vehicle array */
	public PriceOrderOfCar(ArrayList<VehicleStat> vehicles) {
		this.vehicles = vehicles;
		System.out.print("\ncar prices \n\n");
		this.storePrices();
	}

	/** A tree map sorts out these values by default, so post in price and just print it out value to key
	 * instead of key to value. Some sort of sort (i.e. bubble) would've done also, but this is somewhat
	 * easier... */
	public void storePrices() {
		for (int i = 0; i != vehicles.size(); i++) {
			test.put(Double.parseDouble(vehicles.get(i).getPrice()), vehicles.get(i).getName());
		}
		this.printInOrder();
	}

	StringBuilder returnPrices = new StringBuilder();

	public void printInOrder() {
		for (Double key : test.keySet()) {
			String value = test.get(key).toString();
			System.out.println(value + " = =  " + key);
			returnPrices.append(value + " = " + key + " <br />");
		}
	}

	/** returns all of the prices as a string, this is for rest api though. */
	public String returnPrices() {
		return returnPrices.toString();
	}
}
