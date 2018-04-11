package cars;


public class MinibusCar extends Car {

    public MinibusCar (String brand, String model, short year, String carID, short numberOfPassengers,
                       double fuelConsumption, double value) {

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.carID = carID;
        this.numberOfPassengers = numberOfPassengers;
        this.trunkSize = "big";
        this.fuelConsumption = fuelConsumption;
        this.value = value;

    }

}
