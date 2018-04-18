package utils;
import cars.*;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONReader implements DataReader {
    private String path;
    private List<Car> carsFromJSON = new ArrayList<>();

    public JSONReader (String path){
        this.path = path;
    }

    @Override
    public List<Car> readData() {

        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader(path));
            MyPojoClass[] cars = gson.fromJson(reader, MyPojoClass[].class);
            reader.close();
            for (MyPojoClass car : cars){
                if (car.getNumberOfPassengers() == 4 && car.getTrunkSize().equals("small")){
                    carsFromJSON.add(new SedanCar(car.getBrand(), car.getModel(), car.getYear(), car.getCarID(),
                            car.getNumberOfPassengers(), car.getFuelConsumption(), car.getValue()));
                }

                else if (car.getNumberOfPassengers() == 4 && car.getTrunkSize().equals("medium")){
                    carsFromJSON.add(new WagonCar(car.getBrand(), car.getModel(), car.getYear(), car.getCarID(),
                            car.getNumberOfPassengers(), car.getFuelConsumption(), car.getValue()));
                }

                else if (car.getNumberOfPassengers() > 4 && car.getNumberOfPassengers() < 9 && car.getTrunkSize().equals("medium")){
                    carsFromJSON.add(new MinivanCar(car.getBrand(), car.getModel(), car.getYear(), car.getCarID(),
                            car.getNumberOfPassengers(), car.getFuelConsumption(), car.getValue()));
                }

                else if (car.getNumberOfPassengers() > 8 && car.getTrunkSize().equals("big")){
                    carsFromJSON.add(new MinibusCar(car.getBrand(), car.getModel(), car.getYear(), car.getCarID(),
                            car.getNumberOfPassengers(), car.getFuelConsumption(), car.getValue()));
                }
                else{
                    System.out.println(car.getBrand() + " " + car.getModel() + " ("+car.getCarID()+") was not added to the cars list. Consider checking your input");
                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return carsFromJSON;
    }

    public class MyPojoClass {

        @SerializedName("brand")
        @Expose
        private String brand;
        @SerializedName("model")
        @Expose
        private String model;
        @SerializedName("year")
        @Expose
        private short year;
        @SerializedName("carID")
        @Expose
        private String carID;
        @SerializedName("numberOfPassengers")
        @Expose
        private short numberOfPassengers;
        @SerializedName("trunkSize")
        @Expose
        private String trunkSize;
        @SerializedName("fuelConsumption")
        @Expose
        private Double fuelConsumption;
        @SerializedName("value")
        @Expose
        private Double value;

        public String getBrand() {
            return brand;
        }
        public void setBrand(String brand) {
            this.brand = brand;
        }
        public String getModel() {
            return model;
        }
        public void setModel(String model) {
            this.model = model;
        }
        public short getYear() {
            return year;
        }
        public void setYear(short year) {
            this.year = year;
        }
        public String getCarID() {
            return carID;
        }
        public void setCarID(String carID) {
            this.carID = carID;
        }
        public short getNumberOfPassengers() {
            return numberOfPassengers;
        }
        public void setNumberOfPassengers(short numberOfPassengers) {
            this.numberOfPassengers = numberOfPassengers;
        }
        public String getTrunkSize() {
            return trunkSize;
        }
        public void setTrunkSize(String trunkSize) {
            this.trunkSize = trunkSize;
        }
        public Double getFuelConsumption() {
            return fuelConsumption;
        }
        public void setFuelConsumption(Double fuelConsumption) {
            this.fuelConsumption = fuelConsumption;
        }
        public Double getValue() {
            return value;
        }
        public void setValue(Double value) {
            this.value = value;
        }

    }
}
