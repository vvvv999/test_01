import cars.Car;
import taxistation.TaxiStation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaxiStation station1 = new TaxiStation();
        station1.addDefaultCars();
      //  System.out.println(station1.carTotalValue());


        List<Car> sortedCarList = station1.sortCarsList();


        for (Car car : sortedCarList){
            System.out.println(car);
        }
    }
}
