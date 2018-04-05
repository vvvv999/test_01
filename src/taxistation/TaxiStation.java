package taxistation;

import cars.Car;
import cars.HatchbackCar;

import java.util.ArrayList;
import java.util.List;

public class TaxiStation {
    private String name;
    protected List<Car> carsList = new ArrayList<>();


    //for testing purposes
    public void addDefaultCars(){
        Car car1 = new HatchbackCar("Mercedes", "w123", (short)1990,
                "prr123", 34.3, false, 12000);
        carsList.add(car1);
    }


    public double carTotalValue() {
        double totalValue = 0.0;
        for (Car car: carsList){
           totalValue += car.getValue();
        }
        return totalValue;
    }

}
