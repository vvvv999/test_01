package cars;

public class SedanCar extends Car {

    public SedanCar (String brand, String model, short year, String carID, short numberOfPassengers,
                         double fuelConsumption, double value){

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.carID = carID;
        this.numberOfPassengers = numberOfPassengers;
        this.trunkSize = "small";
        this.fuelConsumption = fuelConsumption;
        this.value = value;

    }
}
