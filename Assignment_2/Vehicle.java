package Assignment_2;

public class Vehicle{
    
    public String brandName;
    public String modelName;
    public String color;
    public double price;
    public boolean auto;
    public int noOfWheels;
    public float enginePower;
    private int noOfCylinders;
    private String mfgCode;
    public float speedLimit;
    public String fuelType;

    public String getMfgCode()
    {
        return mfgCode;
    }
    public void setMfgCode(String mCode)
    {
        mfgCode = mCode;
    }

    public int getNoOfCylinders()
    {
        return noOfCylinders;
    }
    public void setNoOfCylinders(int nCylinders)
    {
        noOfCylinders = nCylinders;
    }

    public Vehicle()
    {
        brandName="Honda";
        modelName="Accord";
        price=3400000.55;
        color="Blue";
        mfgCode="HON1234";
        noOfCylinders=4;
        noOfWheels=4;
        auto = true;
        enginePower=3.5f;
        fuelType="Petrol";
    }
    public Vehicle(String bName, String nName, String c, double p, String fType)
    {
        brandName= bName;
        modelName= nName;
        color = c;
        price = p;
        fuelType = fType;
    }
    public Vehicle(String c, double p, boolean a)
    {
        color=c;
        price=p;
        auto=a;
    }
    public Vehicle(Vehicle v)
    {
        brandName=v.brandName;
        modelName=v.modelName;
        price=v.price;
        color = v.color;
        mfgCode=v.mfgCode;
        auto=v.auto;
        noOfCylinders=v.noOfCylinders;
        enginePower=v.enginePower;
        noOfWheels=v.noOfWheels;
        fuelType=v.fuelType;
    }

    public void start(int initSp)
    {
        System.out.println("I've started with an initial speed of"+initSp);
    }
    public void drive()
    {
        System.out.println("Lets go! drive safe.");
    }
    public void stop()
    {
        System.out.println("That was nice ride!");
    }

    public float calculateMileage(float dist, float unitOfFuel)
    {
        return dist/unitOfFuel;
    }

    public void displayFuelEfficiency() {
        float baseEfficiency = 15.0f;
        float finalEfficiency;

        switch(fuelType.toLowerCase()) {
            case "petrol":
                finalEfficiency = baseEfficiency;
                System.out.println(brandName + " " + modelName + " (Petrol) Efficiency: " + finalEfficiency + " km/l");
                break;
            case "diesel":
                finalEfficiency = baseEfficiency * 1.2f;
                System.out.println(brandName + " " + modelName + " (Diesel) Efficiency: " + finalEfficiency + " km/l (Highly Efficient)");
                break;
            case "electric":
                finalEfficiency = baseEfficiency * 5.0f;
                System.out.println(brandName + " " + modelName + " (EV) Efficiency: " + finalEfficiency + " km/kWh (Eco-Friendly)");
                break;
            default:
                System.out.println("Unknown fuel type. Efficiency cannot be determined.");
        }
    }

    public float changeSpeed(int curSp)
    {
        if (curSp<=this.speedLimit)
            System.out.println("you are in the ideal speed range.");
        else
            System.out.println("SLOW DOWN!");

        return curSp;
    }
}
