package utils;
import cars.Car;

import java.io.*;
import java.util.List;

public class TextFileWriter {
    private String path;

    public TextFileWriter(String path){

        this.path = path;
    }

    public  void writeData(List<Car> list){
        File fileToWrite = new File(path);
        boolean isFileExists = fileToWrite.isFile();
        boolean FileNotEmpty = fileToWrite.length() > 0;
        final String SEPARATOR = ",";
        try {

            FileWriter writer = new FileWriter(path, true);
            if(isFileExists && FileNotEmpty){
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
            if((list.size()-1) != list.indexOf(car)) {        //to escape unnecessary line break in the end of the file
                writer.append("\n");
            }
          //  bw.flush();
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
