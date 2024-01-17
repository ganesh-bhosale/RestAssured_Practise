package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Serialization {

    public static void main(String [] args) throws IOException {

        // Create a car object
        Supercar car = new Supercar();
        car.setBrand("Ferrari");
        car.setModel("La Ferrari");
        car.setHorsePower(718);
        car.setTopSpeed(350);
        car.setElectic(false);

        // Create a Gson object
        Gson gson = new Gson();

        // toJson(Object src) method converts Java object to JSON object
        String carDetails = gson.toJson(car);

        // Printing json string (non-pretty)
        System.out.println("Non Pretty json String");
        System.out.println(carDetails);

        // We can create a configurable Gson instance using GsonBuilder class
        Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
        String carJsonStringUsingBuilder = gsonBuilder.toJson(car);
        System.out.println("Pretty json String");
        System.out.println(carJsonStringUsingBuilder);

        // To write Json object in to a file, we need to pass a FileWriter object which is in direct implementation of
        // Appendable interface. Make sure you call flush() method otherwise json file will be empty.
        String useDir = System.getProperty("user.dir");
        File outputJsonFile = new File(useDir+"/src/test/java/resource/GSONpayload.json");
        FileWriter fileWriter = new FileWriter(outputJsonFile);
        gsonBuilder.toJson(car, fileWriter);
        fileWriter.flush();
    }
}
