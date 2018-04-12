package utils;
import cars.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class readFromFile {

    public static List<Car> readDataFromFIle(String fileAddress){
        List<Car> carsFromFile = new ArrayList<>();
         String line;
         String splitBy = ",";
        try {


            BufferedReader reader = new BufferedReader(new FileReader(fileAddress));
        while ((line = reader.readLine()) != null ){
            String[] carAttributes = line.split(splitBy);

            String brand = carAttributes[0];
            String model = carAttributes[1];
            short year = Short.parseShort(carAttributes[2]);
            String carID = carAttributes[3];
            short numberOfPassengers = Short.parseShort(carAttributes[4]);
            String trunkSize = carAttributes[5];
            double fuelConsumption = Double.parseDouble(carAttributes[6]);
            double value = Double.parseDouble(carAttributes[7]);

            if (numberOfPassengers == 4 && trunkSize.equals("small")){
                carsFromFile.add(new SedanCar(brand, model, year, carID,
                        numberOfPassengers, fuelConsumption, value));
            }

            else if (numberOfPassengers == 4 && trunkSize.equals("medium")){
                carsFromFile.add(new WagonCar(brand, model, year, carID,
                        numberOfPassengers, fuelConsumption, value));
            }

            else if (numberOfPassengers > 4 && numberOfPassengers < 9 && trunkSize.equals("medium")){
                carsFromFile.add(new MinivanCar(brand, model, year, carID,
                        numberOfPassengers, fuelConsumption, value));
            }

            else if (numberOfPassengers > 8 && trunkSize.equals("big")){
                carsFromFile.add(new MinibusCar(brand, model, year, carID,
                        numberOfPassengers, fuelConsumption, value));
            }
            else{
                System.out.println(carAttributes[0] + " " + carAttributes[1] + " ("+carAttributes[3]+") was not added to the cars list. Consider checking your input");
            }

        }
        System.out.println("Data was successfully read from the file");
        } catch (IOException e) {
            e.printStackTrace();
        }



        return carsFromFile;
    }

}
