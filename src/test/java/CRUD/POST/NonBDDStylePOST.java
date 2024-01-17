package CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStylePOST {

    @Test
    public void NonBDDStylePOSTRequest(){

        // Step 1 - Pre Request Set up
        // Payload
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);

        r.body(payload);

        // Step 2 - Make Request
        Response response = r.post();

        String responseString = response.asString();
        System.out.println(responseString);

        // Step 3 - Validation and Testing
        ValidatableResponse validatableResponse = response.then();

        validatableResponse.body("token", Matchers.notNullValue());
        validatableResponse.body("token.length()", Matchers.is(15));

    }
}
