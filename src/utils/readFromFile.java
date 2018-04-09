package utils;
import cars.Car;
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
            String[] cars = line.split(splitBy);


        }

        } catch (IOException e) {
            e.printStackTrace();
        }



        return carsFromFile;
    }

}
