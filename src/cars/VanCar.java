package cars;

public class VanCar extends Car {
    protected final String trunkSize = "Big";

    public VanCar (String brand, String model, short year, String carID,
                         double fuelConsumption, boolean isPremiumClass,  double value){

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.carID = carID;
        this.fuelConsumption = fuelConsumption;
        this.value = value;
        this.isPremiumClass = isPremiumClass;
        this.info = "This is a van car";
    }

}
