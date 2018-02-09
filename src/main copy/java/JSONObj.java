import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONObj {
	
	private final String jsonURL = "http://www.rentalcars.com/js/vehicles.json";
	
	ArrayList<VehicleStat> vehicleStats = new ArrayList<VehicleStat>();
	
	public JSONObj() {
		this.downloadJSON();
	}

	/** Contacts the rental cars website and asks for the json file.
	 * If the http response is code 200, proceeds to
	 * download the json and separate the array out into
	 * useful informative parts.
	 *
	 * It then puts them into individual objects in which we can store
	 * and access all of the information readily and easily
	 *
	 *
	 * If HTTPCODE != 200 then returns error message */
	public void downloadJSON() {
	    try {
			URL url = new URL(jsonURL);
		    HttpURLConnection request = (HttpURLConnection) url.openConnection();
		    request.connect();
		    		    
		    if (request.getResponseCode() == 200) {
		    	BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		        String inputLine;
		        
		        StringBuilder serverReply = new StringBuilder();
		        while ((inputLine = in.readLine()) != null)
		        	serverReply.append(inputLine);
		        in.close();
		        
		        String reply 		= serverReply.toString();
		        
		        System.out.println(reply);
		        
		        JSONParser parser 	= new JSONParser();
		        Object obj 			= parser.parse(reply);
		        JSONObject jsonObject = (JSONObject) obj;	
		        
		        
		        Object searchArrayObj = parser.parse(jsonObject.get("Search").toString());
		        
		        JSONObject jSearchArrayObj = (JSONObject) searchArrayObj;	 // contents of vehicle list array
		        
		        log(jSearchArrayObj.get("VehicleList").toString());
		        
		        Object vehicleListObj = parser.parse(jSearchArrayObj.get("VehicleList").toString());
		        
		        JSONArray arrOfVehicles = (JSONArray) vehicleListObj;	 // contents of vehicle list array

		        
		        for (int i = 0; i != arrOfVehicles.size(); i++) {
			        log(arrOfVehicles.get(i).toString());
			        
			        JSONObject indivVehicle = (JSONObject) arrOfVehicles.get(i);
			        
			        String SIPP 	= ((String)indivVehicle.get("sipp"));
			        String Price 	= ((String)indivVehicle.get("price").toString());
			        String Supplier = ((String)indivVehicle.get("supplier"));
			        String Name 	= ((String)indivVehicle.get("name"));
			        String Rating 	= ((String)indivVehicle.get("rating").toString());
			        
			        VehicleStat vehicleInfo = new VehicleStat(SIPP, Price, Supplier, Name, Rating);
			        
			        vehicleStats.add(vehicleInfo);
		        }
		        
		      
		    } else {
		    	log("Rental Cars returned code: " + request.getResponseCode());
		    }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<VehicleStat> returnArrayOfVehicles() {
		return vehicleStats;
	}
	
	private void log(String message) {
		System.out.println(message);
	}
	
}
