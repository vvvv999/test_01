package taxistation;

import cars.Car;
import cars.WagonCar;
import cars.SedanCar;
import utils.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaxiStation {

    protected List<Car> carsList = new ArrayList<>();


    //read from file
    public void readFromFile(String path) {
       // carsList = readFromFile.readDataFromFIle(path);
        carsList = Stream.concat(carsList.stream(), readFromFile.readDataFromFIle(path).stream()).collect(Collectors.toList());
            }

    //read from database

    public void readFromDB(){
       // carsList = readDataFromDB.readFromDB();
        carsList = Stream.concat(carsList.stream(), readDataFromDB.readFromDB().stream()).collect(Collectors.toList());
    }

    //write to file
    public void writeToFile(String path) {

        writeToFile.writeDataToFile(carsList, path);

    }

    //for testing purposes
    public void addDefaultCars() {
        Car car1 = new WagonCar("Mercedes", "w123", (short) 1990,
                "prr123", (short)4, 34.3,12000);
        carsList.add(car1);
        Car car2 = new SedanCar("Ford", "focus", (short) 2000,
                "prr23123", (short)4,25, 12000.2);
        carsList.add(car2);

        for (Car car : carsList) {
            System.out.println(car);
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
//find a car by year and value within specific range
    public void findCarByAttributes() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Finding cars by year and value ranges");
        System.out.println("Enter min year");
        int yearMin = Integer.parseInt(reader.readLine());
        System.out.println("Enter max year");
        int yearMax = Integer.parseInt(reader.readLine());
        System.out.println("Enter min value");
        int valueMin = Integer.parseInt(reader.readLine());
        System.out.println("Enter max value");
        int valueMax = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println("Cars found:");
        for (Car car : carsList){
            if (car.getYear() >= yearMin && car.getYear() <= yearMax
                    && car.getValue() >= valueMin && car.getValue() <= valueMax){
                System.out.println(car);
            }
        }




    }
}





