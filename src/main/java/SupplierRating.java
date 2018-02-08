import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author sjthome
 * Organise the supplier rating per vehicle and (presumably) exclude lower rated suppliers in favour
 * of a higher rating should one be provided by a different supplier.
 * 
 * i.e. Hertz 8.9 > Sixt 8.2 > Europcar 8.0, therefore Hertz will be shown.
 */
public class SupplierRating {
	private ArrayList<VehicleStat> vehicles;
	private Object[] vehicleNames;
	private HashMap<String, VehicleStat> supplierVehicles = new HashMap<String, VehicleStat>();
	private TreeMap<String, String> organisedRatingMap = new TreeMap<String, String>();

	public SupplierRating(ArrayList<VehicleStat> vehicles) {
		this.vehicles = vehicles;
		this.getVehicleNames();
		this.getVehicles();
		this.getRawRatings();
		this.printInOrder();
	}
	
	public void getVehicleNames() {
	    Set<String> vehicleNames = new HashSet<String>();
		for (int i = 0; i != vehicles.size(); i++) {   
			vehicleNames.add(vehicles.get(i).getName());
		}
		this.vehicleNames = vehicleNames.toArray();
	}
	
	
	
	public void getVehicles() {
		for (int i = 0; i != vehicles.size(); i++) {
			supplierVehicles.put(vehicles.get(i).getSupplier()+" "+vehicles.get(i).getName(), vehicles.get(i));
		}		
	}
	
	public void getRawRatings() {
		String currentRating, SuppRating, CarName, currentCar;
		for (int j = 0; j != vehicleNames.length; j++) {
			currentCar=vehicleNames[j].toString();
			currentRating = "0";
		for (int i = 0; i != vehicles.size(); i++) {	
			SuppRating = supplierVehicles.get(vehicles.get(i).getSupplier()+" "+vehicles.get(i).getName()).getRating();
			CarName    = supplierVehicles.get(vehicles.get(i).getSupplier()+" "+vehicles.get(i).getName()).getName();
			if (Double.parseDouble(SuppRating) > Double.parseDouble(currentRating) && currentCar.equals(CarName)) {
				currentRating = SuppRating;
			//	System.out.println(vehicles.get(i).getName() + " "+ vehicles.get(i).getCarType() + " "+ vehicles.get(i).getSupplier() + " "+ vehicles.get(i).getRating());
			//	organisedRatingMap.put(vehicles.get(i).getName() + " " + vehicles.get(i).getCarType() + " " + currentRating, vehicles.get(i).getSupplier());
				organisedRatingMap.put(currentRating + " " + vehicles.get(i).getName() + " " + vehicles.get(i).getCarType() + " " + vehicles.get(i).getSupplier() + " " + currentRating, vehicles.get(i).getName());
			}
		  }
		}
	//	System.out.println(test);
	}

	StringBuilder ratings = new StringBuilder();

	public void printInOrder() {
		for (String key : organisedRatingMap.keySet()) {
		//	String value = test.get(key).toString();
			System.out.println(key.substring(4, key.length())); // I could've added this to any type of data set and then printed from there if it was required.
			ratings.append(key.substring(4, key.length())+" <br />");
		}
	}

	public String returnRatings() {
		return ratings.toString();
	}
}
