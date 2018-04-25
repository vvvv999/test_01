package taxistation;

import cars.Car;
import cars.WagonCar;
import cars.SedanCar;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import exceptions.NegativeValueNotAllowedException;
import utils.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaxiStation {

    private List<Car> carsList = new ArrayList<>();

    //read data from file/db/json
    public void loadData(DataReader readerObject) {

        carsList = Stream.concat(carsList.stream(), readerObject.readData().stream()).collect(Collectors.toList());

    }


    public void carsToJson() {
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
    public void sortCarsList() {

        Collections.sort(carsList, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return ((int) Math.round(100.0 * (o1.getFuelConsumption() - o2.getFuelConsumption())));
            }
        });


    }

    //find a car by year and value within specific range
    public void findCarByAttributes() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int yearMax;

        int x = 1;
        System.out.println("Finding cars by year and value ranges");
        do {

            System.out.println("Enter min year");
            try {

                int yearMin = Integer.parseInt(reader.readLine());
                if (yearMin < 0) {
                    throw new NegativeValueNotAllowedException();
                }
                System.out.println("Enter max year");
                yearMax = Integer.parseInt(reader.readLine());
                if (yearMax < 0) {
                    throw new NegativeValueNotAllowedException();
                }
                System.out.println("Enter min value");
                int valueMin = Integer.parseInt(reader.readLine());
                if (valueMin < 0) {
                    throw new NegativeValueNotAllowedException();
                }
                System.out.println("Enter max value");
                int valueMax = Integer.parseInt(reader.readLine());
                if (valueMax < 0) {
                    throw new NegativeValueNotAllowedException();
                }
                System.out.println("Cars found:");
                for (Car car : carsList) {
                    if (car.getYear() >= yearMin && car.getYear() <= yearMax
                            && car.getValue() >= valueMin && car.getValue() <= valueMax) {
                        System.out.println(car);
                    }

                }
                x = 2;
            } catch (NegativeValueNotAllowedException e) {

            } catch (NumberFormatException e) {
                System.out.println("Incorrect input format. Only positive numbers are allowed here");
            } catch (IOException e) {
                e.printStackTrace();
            }


        } while (x == 1);

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
    private boolean verifyInput(String string) {
        if(Integer.valueOf(string) < 0) {

        }
    }

*/
}





