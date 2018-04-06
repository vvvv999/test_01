package taxistation;

import cars.Car;
import cars.HatchbackCar;
import cars.SedanCar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaxiStation {
    private String name;
    protected List<Car> carsList = new ArrayList<>();


    //for testing purposes
    public void addDefaultCars() {
        Car car1 = new HatchbackCar("Mercedes", "w123", (short) 1990,
                "prr123", 34.3, false, 12000);
        carsList.add(car1);
        Car car2 = new SedanCar("Ford", "focus", (short) 2000,
                "prr23123", 25, false, 15000);
        carsList.add(car2);

        for (Car car : carsList) {
            System.out.println(car);;
        }
        System.out.println();
    }


    // find total value of Taxi Station cars
    public double carTotalValue() {
        double totalValue = 0.0;
        for (Car car : carsList) {
            totalValue += car.getValue();
        }
        return totalValue;
    }

//sort cars list
    public List<Car> sortCarsList() {

        List<Car> sortedCarsList = carsList;
        Collections.sort(sortedCarsList, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return ((int) Math.round(100.0 * (o1.getFuelConsumption() - o2.getFuelConsumption())));
            }
        });
        return sortedCarsList;

    }
//find a car by year and value specific range
    public Car findCarByAttributes() {


        return null;
    }
}





