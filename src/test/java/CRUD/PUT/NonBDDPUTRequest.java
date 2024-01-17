package CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NonBDDPUTRequest {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token;

    @BeforeTest
    public void setUp(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        Response response = requestSpecification.post();
        validatableResponse = response.then();
        validatableResponse.body("token", Matchers.notNullValue());
        validatableResponse.body("token.length()", Matchers.is(15));
        token = response.then().log().all().extract().path("token");
        System.out.println(token);
    }

    @Test
    public void NonBDDStylePOSTRequest(){
        String jsonString = "{\n" +
                "    \"firstname\" : \"Ganesh\",\n" +
                "    \"lastname\" : \"Bhosale\",\n" +
                "    \"totalprice\" : 38892,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2023-04-10\",\n" +
                "        \"checkout\" : \"2013-04-15\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        // Setting content type to specify format in which request payload will be sent.
        requestSpecification.contentType(ContentType.JSON);
        // Setting a cookie for authentication as per API documentation
        requestSpecification.cookie("token", token);

        // Adding URL
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/348");    // Change the booking ID

        // Adding body as  string
        requestSpecification.body(jsonString);

        // Calling PUT method on URI. After hitting we get Response
        Response response = requestSpecification.put();

        // Printing response as String
        System.out.println(response.asString());

        // Get Validatable response to perform validations
        validatableResponse = response.then().log().all();

        // Validate status code as 200
        validatableResponse.statusCode(200);

        // Validate value of first name is updated
        validatableResponse.body("firstname", Matchers.equalTo("Ganesh"));

        // Validate total price value
        validatableResponse.body("totalprice", Matchers.equalTo(38892));
    }

}
