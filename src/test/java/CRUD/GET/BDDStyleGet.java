package CRUD.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class BDDStyleGet {

    @Test
    public void BDDStyleGetRequest(){

        // https://abc.com/pp/ppa?q=abc
        // baseUri -> https://abc.com
        // basePath -> pp
        // pathParam -> ppa
        // queryParam -> ?q=abc
        // https://restful-booker.herokuapp.com

        /* --- BDD Style Request --- */

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").
                basePath("/booking").
                when().get().
                then().statusCode(200);
    }
}
