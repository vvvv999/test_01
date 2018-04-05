import taxistation.TaxiStation;

public class Main {
    public static void main(String[] args) {
        TaxiStation station1 = new TaxiStation();
        station1.addDefaultCars();
        System.out.println(station1.carTotalValue());

    }


}
