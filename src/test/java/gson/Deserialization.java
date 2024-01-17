package gson;

import PayloadManage.POJO.JSONArray.Employee;
import com.google.gson.Gson;

public class Deserialization {
    public static void main(String [] args){

        String jsonString = "{\n" +
                "  \"brand\": \"Ferrari\",\n" +
                "  \"model\": \"La Ferrari\",\n" +
                "  \"horsePower\": 718,\n" +
                "  \"topSpeed\": 350,\n" +
                "  \"isElectic\": false\n" +
                "}";

        Gson gson = new Gson();

        Supercar car = gson.fromJson(jsonString, Supercar.class);

        // User getters & setters to retrieve the values
        String brand = car.getBrand();
        String model = car.getModel();
        int horsePower = car.getHorsePower();
        int topSpeed = car.getTopSpeed();
        Boolean isElectic = car.getElectic();

        System.out.println("Supercar Features");
        System.out.println("Brand: "+brand);
        System.out.println("Model: "+model);
        System.out.println("Horsepower: "+horsePower);
        System.out.println("topSpeed: "+topSpeed);
        System.out.println("isElectic: "+isElectic);
    }
}
