package test;

import baseUrl.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C17_BaseUrlHerokuQueryParam extends HerokuappBaseUrl {



    @Test
    public void get01(){
/*
    1- Send a GET request to the https://restful-booker.herokuapp.com/booking
       endpoint and test that the returned response has a status code of 200 and
       there is a booking with an id of 33071 in the response.
*/
        // 1- Prepare the url.
        specHeroku.pathParam("pp1" , "booking");

        // 2- Prepare the Expected Data.
        // There is none for this query.

        // 3- Save Response.
        Response response = given().spec(specHeroku).when().get("/{pp1}");

        // 4- Assertion.
        response.then().assertThat()
                .statusCode(200)
                .body("bookingid" , hasItem(1200));
    }

    @Test
    public void get02(){
/*
    2- Send a GET request to the https://restful-booker.herokuapp.com/booking
       endpoint with the required query parameters, specifying the "firstname"
       value as "Eric". Test that the returned response has a status code of 200
       and there is only 1 booking with the name "Eric" in the response.
*/
        // 1- Prepare the url.
        specHeroku.pathParam("pp1" , "booking").queryParams("firstname" , "Eric");

        // 2- Prepare the Expected Data.
        // There is none for this query.

        // 3- Save Response.
        Response response = given().spec(specHeroku).when().get("/{pp1}");

        // 4- Assertion.
        response.then().assertThat()
                .statusCode(200)
                .body("bookingid" , hasSize(2));

    }

    @Test
    public void get03(){
/*
    3- Send a GET request to the https://restful-booker.herokuapp.com/booking
       endpoint with the required query parameters, specifying the "firstname"
       value as "Jim" and the "lastname" value as "Jackson". Test that the returned
       response has a status code of 200 and there is at least one booking with
       the name "Jim Jackson" in the response.
*/
        // 1- Prepare the url.
        specHeroku.pathParam("pp1", "booking").queryParams("firstname" , "Jim" , "lastname" , "Jackson");

        // 2- Prepare the Expected Data.
        // There is none for this query.

        // 3- Save Response.
        Response response = given().spec(specHeroku).when().get("/{pp1}");

        // 4- Assertion.
        response.then().assertThat().statusCode(200).body("bookingid",hasSize(0));
    }
}