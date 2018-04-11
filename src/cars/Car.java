package cars;

public abstract class Car {
//NOTE TO SELF check if access modifiers are correct
    protected String brand;
    protected String model;
    protected short year;
    protected String carID;
    protected short numberOfPassengers;
    protected String trunkSize;
    protected double fuelConsumption;
    protected double value;

    //setters

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setNumberOfPassengers(short numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void setTrunkSize(String trunkSize) {
        this.trunkSize = trunkSize;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setValue(double value) {
        this.value = value;
    }



    //getters

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public short getYear() {
        return year;
    }

    public String getCarID() {
        return carID;
    }

    public short getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public String getTrunkSize() {
        return trunkSize;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getValue() {
        return value;
    }


    }
