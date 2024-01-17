package PayloadManage.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateBookingRequest {

    @Test
    public void CreateBookingPOSTReq(){

        /* {
            "firstname" : "Ganesh",
            "lastname" : "Bhosale",
            "totalprice" : 1998,
            "depositpaid" : true,
            "bookingdates" : {
                "checkin" : "2023-03-04",
                "checkout" : "2013-03-10"
             },
            "additionalneeds" : "Dinner"
           }
        */

        // Converting Payload -> Map

        Map<String,Object> payloadMain = new HashMap<>();
        payloadMain.put("firstname", "Murphy");
        payloadMain.put("lastname", "Cooper");
        payloadMain.put("totalprice", 98127);
        payloadMain.put("depositpaid",true);
        payloadMain.put("additionalneeds","Dinner");

        // Second Map for child objects
        Map<String,Object> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2023-03-04");
        bookingDatesMap.put("checkout", "2013-03-10");
        payloadMain.put("bookingdates", bookingDatesMap);

        // Rest Assured Steps

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("booking");
        r.contentType(ContentType.JSON);
        r.body(payloadMain);
        Response response = r.when().post();
        ValidatableResponse validatableResponse = response.then().log().all();

        String firstName = response.then().extract().path("booking.firstname");
        System.out.println(firstName);

        validatableResponse.statusCode(200);
        validatableResponse.body("booking.firstname", Matchers.equalTo("Murphy"));

        String lastName = response.then().extract().path("booking.lastname");
        Assert.assertEquals(lastName, "Cooper");
        System.out.println(lastName);

        validatableResponse.body("booking.bookingdates.checkin", Matchers.equalTo("2023-03-04"));

    }
}
