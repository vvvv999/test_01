package cars;


public class HatchbackCar extends Car {

    public HatchbackCar (String brand, String model, short year, String carID,
                         double fuelConsumption, boolean isPremiumClass, double value){

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.carID = carID;
        this.fuelConsumption = fuelConsumption;
        this.value = value;
        this.isPremiumClass = isPremiumClass;
        this.info = "This is a hatchback car";
    }

}
