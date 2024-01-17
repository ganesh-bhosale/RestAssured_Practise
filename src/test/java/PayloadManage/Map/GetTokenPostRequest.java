package PayloadManage.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetTokenPostRequest {

    @Test
    public void GetTokenPOSTRequest(){

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");

        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);

        // Payload -> 1.String
        String payloadAuth = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        // 2. HashMap
        Map<String, String> payLoadMap = new HashMap<>();

        // Map -> InputStream by GSON/Jackson API

        payLoadMap.put("username", "admin");
        payLoadMap.put("password", "password123");

        // Make the request
        requestSpecification.body(payLoadMap);

        Response response = requestSpecification.when().post();
        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

        String token = response.then().extract().path("token");
        System.out.println(token);

    }
}
