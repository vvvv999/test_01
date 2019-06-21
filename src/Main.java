import taxistation.TaxiStation;
import utils.*;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//test
        TaxiStation station1 = new TaxiStation();
        station1.sortCarsList();
//      DataReader dbReader = new DBReader();
        DataReader txtReader = new TextFileReader();
        DataReader jsonReader = new JSONReader("res/JSONInput.json");
//      station1.loadData(dbReader);
        station1.loadData(txtReader);
        station1.loadData(jsonReader);
        station1.findCarByAttributes();


        TextFileWriter txtWriter = new TextFileWriter("res/TextOutput.csv");
        station1.saveData(txtWriter);


//      station1.sortCarsList();




        try {
            System.in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
     //   station1.carsToJson();
       /*
        station1.addDefaultCars();
        station1.readFromFile("src/1.csv");
        station1.readFromDB();z

 station1.writeToFile("src/2.csv");
*/



      //  System.out.println(station1.carTotalValue());
        /*
        try {
            station1.findCarByAttributes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */




    }
}
