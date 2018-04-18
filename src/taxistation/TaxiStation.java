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

    private List<Car> carsList = new ArrayList<>();

    //read data from file/db/json
    public void loadData(DataReader readerObject ) {

        carsList = Stream.concat(carsList.stream(), readerObject.readData().stream()).collect(Collectors.toList());

    }


    public void carsToJson(){
        JSONWriter.carToJSON(carsList);
    }



    public void saveData(TextFileWriter writerObject) {
        writerObject.writeData(carsList);
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





