package utils;
import cars.Car;
import cars.MinibusCar;

//import com.google.gson.*;




import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONReader implements DataReader {
    private String path;
  /*  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    Gson gson = new Gson();
    List<Car> carsFromJSON = new ArrayList<>();
*/

    public JSONReader (String path){
        this.path = path;
    }

    @Override
    public List<Car> readData() {


        return null;
    }


}
