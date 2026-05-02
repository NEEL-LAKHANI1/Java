package Assignment_2;

public class Main_Vehicle {
    public static void main(String[] args) {
        Vehicle[] garage = new Vehicle[5];

        garage[0] = new Vehicle();

        garage[1] = new Vehicle("Toyota", "Fortuner", "White", 4500000.0, "Diesel");
        garage[1].enginePower = 2.8f;
        garage[1].setNoOfCylinders(4);
        garage[1].setMfgCode("TOY7890");
        garage[1].speedLimit = 180.0f;
        garage[1].noOfWheels = 4;

        garage[2] = new Vehicle("Tesla", "Model 3", "Red", 6000000.0, "Electric");
        garage[2].enginePower = 350.0f;
        garage[2].setNoOfCylinders(0);
        garage[2].setMfgCode("TSL5566");
        garage[2].speedLimit = 250.0f;
        garage[2].noOfWheels = 4;
        garage[2].auto = true;

        garage[3] = new Vehicle("Ford", "Mustang", "Yellow", 7500000.0, "Petrol");
        garage[3].enginePower = 5.0f;
        garage[3].setNoOfCylinders(8);
        garage[3].setMfgCode("FRD9911");
        garage[3].speedLimit = 260.0f;
        garage[3].noOfWheels = 4;

        garage[4] = new Vehicle("Volvo", "XC90", "Grey", 9500000.0, "Diesel");
        garage[4].enginePower = 2.0f;
        garage[4].setNoOfCylinders(4);
        garage[4].setMfgCode("VOL2233");
        garage[4].speedLimit = 210.0f;
        garage[4].noOfWheels = 4;

        printTable(garage);
    }

    public static void printTable(Vehicle[] vehicles) {
        String separator = "+------------+------------+--------+--------------+-------+--------+-------+-----+------------+-------+-----------------+";
        String header    = "| Brand      | Model      | Color  | Price        | Auto  | Wheels | Power | Cyl | MFG Code   | Limit | Efficiency      |";

        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);

        for (Vehicle v : vehicles) {
            System.out.printf("| %-10s | %-10s | %-6s | %-12.2f | %-5b | %-6d | %-5.1f | %-3d | %-10s | %-5.1f | %-15s |\n",
                    v.brandName,
                    v.modelName,
                    v.color,
                    v.price,
                    v.auto,
                    v.noOfWheels,
                    v.enginePower,
                    v.getNoOfCylinders(),
                    v.getMfgCode() != null ? v.getMfgCode() : "N/A",
                    v.speedLimit,
                    calculateEfficiencyLabel(v));
        }
        System.out.println(separator);
    }

    private static String calculateEfficiencyLabel(Vehicle v) {
        float base = 15.0f;
        String type = (v.fuelType != null) ? v.fuelType.toLowerCase() : "petrol";

        if (type.equals("diesel")) return String.format("%.1f km/l", base * 1.2f);
        if (type.equals("electric")) return String.format("%.1f km/kWh", base * 5.0f);
        return String.format("%.1f km/l", base);
    }
}
