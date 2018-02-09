public class VehicleStat {
	
	private String SIPP, Supplier, Name, Rating, Price, carType;
	private char[] SplitSIPP;
	
	/** I couldn't use a hash map to store all of the values uniquely, so a class
	 * to hold the variables seemed suitable per car. This has allowed
	 * for a much cleaner programming interface*/
	public VehicleStat(String SIPP,String Price,String Supplier,String Name,String Rating) {
		this.setSIPP(SIPP);
		this.setPrice(Price);
		this.setSupplier(Supplier);
		this.setName(Name);
		this.setRating(Rating);
		
		setSplitSIPP(SIPP.toCharArray());
	}

	/** Getters and setters, as per java 101 */
	public String getSIPP() {
		return SIPP;
	}

	public void setSIPP(String sIPP) {
		SIPP = sIPP;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getSupplier() {
		return Supplier;
	}

	public void setSupplier(String supplier) {
		Supplier = supplier;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}

	public char[] getSplitSIPP() {
		return SplitSIPP;
	}
	
	public char returnSIPPByIndex(int index) {
			return SplitSIPP[index];
	}

	public void setSplitSIPP(char[] splitSIPP) {
		SplitSIPP = splitSIPP;
	}
	
	public void setCarType (String carType) {
		this.carType = carType;
	}
	public String getCarType () {
		return carType;
	}
}
