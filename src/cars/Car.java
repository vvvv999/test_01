package cars;

public abstract class Car {

    protected String brand;
    protected String model;
    protected short year;
    protected String carID;
    protected double fuelConsumption;
    protected double value;



    //setters and getters

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

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setValue(double value) {
        this.value = value;
    }

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

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getValue() {
        return value;
    }


}
