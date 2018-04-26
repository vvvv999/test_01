package utils;
import cars.*;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBReader implements DataReader {

    static final String DB_URL = "jdbc:mysql://localhost:3306/taxistation?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "root";

    @Override
    public  List<Car> readData() {
        Connection conn = null;
        Statement stmt;
        List<Car> carsFromDB = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLNonTransientConnectionException e){
                System.err.println("Database is not found");


            }


            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM carslist";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                short year = (short)rs.getInt("year");
                String carID = rs.getString("carid");
                short numberOfPassengers = (short) rs.getInt("numofpassengers");
                String trunkSize = rs.getString("trunksize");
                double fuelConsumption = rs.getDouble("fuelconsumption");
                double value = rs.getDouble("value");

                if (numberOfPassengers == 4 && trunkSize.equals("small")){
                    carsFromDB.add(new SedanCar(brand, model, year, carID,
                            numberOfPassengers, fuelConsumption, value));
                }

                else if (numberOfPassengers == 4 && trunkSize.equals("medium")){
                    carsFromDB.add(new WagonCar(brand, model, year, carID,
                            numberOfPassengers, fuelConsumption, value));
                }

                else if (numberOfPassengers > 4 && numberOfPassengers < 9 && trunkSize.equals("medium")){
                    carsFromDB.add(new MinivanCar(brand, model, year, carID,
                            numberOfPassengers, fuelConsumption, value));
                }

                else if (numberOfPassengers > 8 && trunkSize.equals("big")){
                    carsFromDB.add(new MinibusCar(brand, model, year, carID,
                            numberOfPassengers, fuelConsumption, value));
                }
                else{
                    System.out.println(brand + " " + model + " ("+carID+") was not added to the cars list. Consider checking your input.");
                }

            }

        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        return carsFromDB;
    }

}
