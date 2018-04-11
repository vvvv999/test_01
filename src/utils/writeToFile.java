package utils;
import cars.Car;

import java.io.*;
import java.util.List;

public class writeToFile {

    public static void writeDataToFile(List<Car> list, String path ){
        boolean isFileExists = new File(path).isFile();
        final String SEPARATOR = ",";
        try {

            FileWriter writer = new FileWriter(path, true);
            if(isFileExists){
                writer.append("\n");
            }
            BufferedWriter bw = new BufferedWriter(writer);

            for (Car car : list){
            writer.append(car.getBrand());
            writer.append(SEPARATOR);
            writer.append(car.getModel());
            writer.append(SEPARATOR);
            writer.append(String.valueOf(car.getYear()));
            writer.append(SEPARATOR);
            writer.append(car.getCarID());
            writer.append(SEPARATOR);
            writer.append(String.valueOf(car.getNumberOfPassengers()));
            writer.append(SEPARATOR);
            writer.append(car.getTrunkSize());
            writer.append(SEPARATOR);
            writer.append(String.valueOf(car.getFuelConsumption()));
            writer.append(SEPARATOR);
            writer.append(String.valueOf(car.getValue()));
            if((list.size()-1) != list.indexOf(car)) {        //to escape unnecessary line break at the end of the file
                writer.append("\n");
            }
            bw.flush();
            }

            bw.close();
            System.out.println("Data saved to the file successfully");
        }
        catch (IOException e) {
            System.out.println("Error occurred while writing to the file!");
            e.printStackTrace();
        }


    }

}
