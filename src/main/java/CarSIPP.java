import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author sjthome
 * Class that calculates the specification of vehicles based on SIPP codes and then outputs it.
 */
public class CarSIPP {
    ArrayList<VehicleStat> vehicles;
    HashMap<Character, String> SIPPTable = new HashMap<Character,String>();

    public CarSIPP(ArrayList<VehicleStat> vehicles) {
        this.vehicles = vehicles;
        this.populateSIPPTable();
        this.carSpecs();
    }

    StringBuilder sb = new StringBuilder();

    public String returnCarSpecs() {
        return sb.toString();
    }

    public void carSpecs() {
        sb.append("\n " +  "calculate the specification of the vehicles based on their SIPP" + "\n");

        for (int i = 0; i != vehicles.size(); i++) {
            sb.append(" <br />"+
                    vehicles.get(i).getName() + " - " +
                            vehicles.get(i).getSIPP() + " - "
            );

            String CarType = SIPPTable.get(vehicles.get(i).returnSIPPByIndex(0));


            if (vehicles.get(i).returnSIPPByIndex(1) == 'P') {
                sb.append(" Pick up - ");
            } else {
                String DoorsOrType = SIPPTable.get(vehicles.get(i).returnSIPPByIndex(1));
                sb.append(DoorsOrType + " - ");
                vehicles.get(i).setCarType(DoorsOrType);
            }

            if (vehicles.get(i).returnSIPPByIndex(2) == 'M') {
                sb.append(" Manual - ");
            } else {
                String Transmission = SIPPTable.get(vehicles.get(i).returnSIPPByIndex(2));
                sb.append(Transmission + " - ");
            }

            String FuelAndAC = SIPPTable.get(vehicles.get(i).returnSIPPByIndex(3));
            sb.append(FuelAndAC);
        }

        sb.append(" <br />"+"\n");
    }

    private void populateSIPPTable() {
        SIPPTable.put('M', "Mini");
        SIPPTable.put('E', "Economy");
        SIPPTable.put('C', "Compact");
        SIPPTable.put('I', "Intermediate");
        SIPPTable.put('S', "Standard");
        SIPPTable.put('F', "Full size");
        SIPPTable.put('P', "Premium");
        SIPPTable.put('L', "Luxury");
        SIPPTable.put('X', "Special");
        SIPPTable.put('B', "2 doors");
        SIPPTable.put('C', "4 doors");
        SIPPTable.put('D', "5 doors");
        SIPPTable.put('W', "Estate");
        SIPPTable.put('T', "Convertible");
        SIPPTable.put('F', "SUV");
        SIPPTable.put('V', "Passenger Van");
        SIPPTable.put('A', "Automatic");
        SIPPTable.put('N', "Petrol - no AC");
        SIPPTable.put('R', "Petrol - AC");
        SIPPTable.put('1', "Manual");
        SIPPTable.put('2', "Pick up");
        // 1 = manual for this purpose, it is still M in vehicle stats but this will not matter
        // in the for.
        // 2 = pick up for this purpose, same as above
    }

}
