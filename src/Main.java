import taxistation.TaxiStation;
import utils.*;

public class Main {
    public static void main(String[] args) {
        TaxiStation station1 = new TaxiStation();

        DataReader dbReader = new DBReader();
        DataReader txtReader = new TextFileReader("src/1.csv");
       station1.loadData(dbReader);
       station1.loadData(txtReader);

       TextFileWriter txtWriter = new TextFileWriter("src/2.csv");
       station1.saveData(txtWriter);

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
      /* List<Car> sortedCarList = station1.sortCarsList();
        for (Car car : sortedCarList){
           System.out.println(car);

       }
       */
    }
}
