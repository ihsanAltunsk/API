package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C09_POST_BodyTestWithJsonPath {
    /*
    To the URL https://restful-booker.herokuapp.com/booking,
    when we send a POST request with the following body:
        {
        "firstname": "Ali",
        "lastname": "Bak",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
        }
    Verify that the returned response has:
    1- a status code of 200,
    2- a content type of application/json; charset=utf-8,
    3- and in the response body:
        - "firstname" is "Ali",
        - "lastname" is "Bak",
        - "totalprice" is 500,
        - "depositpaid" is false,
        - "checkin" date is 2021-06-01,
        - "checkout" date is 2021-06-10,
        - "additionalneeds" is "wi-fi".
                                    */
    @Test
    public void post01(){
        // 1- Prepare Endpoint and Request Body.
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingdate = new JSONObject();
        bookingdate.put("checkin" , "2021-06-01");
        bookingdate.put("checkout" , "2021-06-10");

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname" , "Ali");
        requestBody.put("lastname" , "Bak");
        requestBody.put("totalprice" , 500);
        requestBody.put("depositpaid" , false);
        requestBody.put("bookingdates" , bookingdate);
        requestBody.put("additionalneeds" , "wi-fi");

        // 2- Prepare the Expected Data.
            // There is none for this query.

        // 3- Save Response.
        Response response = given()
                                .contentType(ContentType.JSON)
                            .when()
                                .body(requestBody.toString())
                            .post(url);

        // 4- Assertion.
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("booking.firstname" , equalTo(requestBody.get("firstname")),
                "booking.lastname" , equalTo("Bak"),
                         "booking.totalprice" , equalTo(500),
                         "booking.depositpaid" , equalTo(true),
                         "booking.additionalneeds" , equalTo("wi-fi"),
                         "booking.bookingdates.checkin" , equalTo("2021-06-01"),
                         "booking.bookingdates.checkout" , equalTo("2021-06-10"));


    }
}