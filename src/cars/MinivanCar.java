package cars;

public class MinivanCar extends Car {

    public MinivanCar (String brand, String model, short year, String carID, short numberOfPassengers,
                       double fuelConsumption, double value) {

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.carID = carID;
        this.numberOfPassengers = numberOfPassengers;
        this.trunkSize = "medium";
        this.fuelConsumption = fuelConsumption;
        this.value = value;

    }

}
