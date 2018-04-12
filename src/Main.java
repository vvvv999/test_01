import taxistation.TaxiStation;
import utils.*;

public class Main {
    public static void main(String[] args) {
        TaxiStation station1 = new TaxiStation();
       // station1.addDefaultCars();
        station1.readFromFile("src/1.csv");



        station1.readFromDB();
        station1.writeToFile("src/2.csv");





      //  System.out.println(station1.carTotalValue());
        /*
        try {
            station1.findCarByAttributes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
      /* List<Car> sortedCarList = station1.sortCarsList();
        for (Car car : sortedCarList){
           System.out.println(car);

       }
       */
    }
}
