import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class VehicleScore {
	private ArrayList<VehicleStat> vehicles;
	private Object[] vehicleNames;
	private TreeMap<String, String> organisedRatingMap = new TreeMap<String, String>();
	private TreeMap<String, String> organisedRatingMap2 = new TreeMap<String, String>();

	public VehicleScore(ArrayList<VehicleStat> vehicles) {
		this.vehicles = vehicles;
		System.out.println();
		this.getRawRatings();
		this.printInOrder();
	}
	/** un-necessary but possibly useful in the future  */
	public void getVehicleNames() {
	    Set<String> vehicleNames = new HashSet<String>();
		for (int i = 0; i != vehicles.size(); i++) {   
			vehicleNames.add(vehicles.get(i).getName());
		}
		this.vehicleNames = vehicleNames.toArray();
	}
	

	/** Rates the car based on arbitrary character values... */
	public void getRawRatings() {
		String CarName, Supplier;
				
		for (int i = 0; i != vehicles.size(); i++) {	
			double carScore = 0;
			double sumOfScores = 0;
			CarName = vehicles.get(i).getName();
			
			if (vehicles.get(i).returnSIPPByIndex(2) == 'M') {
				carScore = carScore+ 1;
			} else {
				carScore = carScore+ 5;
			}
			
			if (vehicles.get(i).returnSIPPByIndex(3) == 'R') {
				carScore = carScore+ 2;
			} 
			
			
			Supplier = vehicles.get(i).getRating();
			
			
			sumOfScores = Double.parseDouble(vehicles.get(i).getRating()) + carScore;

			if (sumOfScores >= 10) {
				organisedRatingMap2.put(String.valueOf(sumOfScores)+" "+i, CarName + " - " + carScore + " - " + Supplier + " - " + sumOfScores);
			} else {
				organisedRatingMap.put(String.valueOf(sumOfScores)+" "+i, CarName + " - " + carScore + " - " + Supplier + " - " + sumOfScores);
			}
		  }
		
	}

	private ArrayList<String> printArr = new ArrayList<String>();
	/** Used two maps because one started to get confused about how to sort
	 *  the values correctly, hence the if in getRawRatings placing > 10s in a different
	 *  map... */
	public void printInOrder() {
		for (String key : organisedRatingMap.keySet()) {
			String value = organisedRatingMap.get(key).toString();
			System.out.println(value);
			printArr.add(value);

		}
		for (String key : organisedRatingMap2.keySet()) {
			String value = organisedRatingMap2.get(key).toString();
			System.out.println(value);

			printArr.add(value);
		}
	}
	/** rest api: basically print in order... */
	public String outputArray() {
		StringBuilder sb = new StringBuilder();
		for(String elem : printArr){
			sb.append(elem+" <br />"+System.lineSeparator());
		}
		return sb.toString();
	}

}
