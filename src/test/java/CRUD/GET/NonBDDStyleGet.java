package CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStyleGet {

    @Test
    public void NonBDDStyleGetRequest(){

        // --- Non BBDStyle Get Request

        // Get Request to get all the booking IDs from restful-booker app

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.when().get();
        r.then().statusCode(200);
    }
}
