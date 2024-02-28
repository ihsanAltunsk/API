package test;

import baseUrl.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;

public class C16_BaseUrlHeroku extends HerokuappBaseUrl {
    @Test
    public void get01(){
        // 1- Send a GET request to the https://restful-booker.herokuapp.com/booking
        //    endpoint and test that the returned response has a status code of 200
        //    and there is a booking with an id of 24389 in the response.

        // 1- Prepare the url.
        specHeroku.pathParam("pp1" , "booking");

        // 2- Prepare the Expected Data.
        // There is none for this query.

        // 3- Save Response.
        Response response = given().spec(specHeroku).when().get("/{pp1}");

        // 4- Assertion.
        response.then().assertThat()
                       .statusCode(200)
                       .body("bookingid",hasItem(24389));
    }

    @Test
    public void post01(){
        // 2- Send a POST request to the https://restful-booker.herokuapp.com/booking
        //    endpoint with the following body, and test that the returned response
        //    has a status code of 200 and the value of "firstname" is "Ali":
        /*
          {
        "firstname" : "Ali",
        "lastname" : "Bak",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                      },
        "additionalneeds" : "wi-fi"
         }
         */

        // 1- Prepare the url.
        specHeroku.pathParam("pp1" , "booking");

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin" , "2021-06-01");
        bookingDates.put("checkout" , "2021-06-10");

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname" , "Ali");
        requestBody.put("lastname" , "Bak");
        requestBody.put("totalprice" , 500);
        requestBody.put("depositpaid" , false);
        requestBody.put("bookingdates" , bookingDates);
        requestBody.put("additionalneeds" , "wi-fi");

        // 2- Prepare the Expected Data.
        // There is none for this query.

        // 3- Save Response.
        Response response = given().spec(specHeroku).contentType(ContentType.JSON).when().body(requestBody.toString()).post("/{pp1}");

        // 4- Assertion.
        response.then().assertThat()
                       .statusCode(200)
                       .body("booking.firstname" , equalTo("Ali"));
    }
}