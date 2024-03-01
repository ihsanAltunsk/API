package test;

import baseUrl.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataHeroku;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_POST_TestDataUsage extends HerokuappBaseUrl {
    /*
    Test that when sending a POST request to the URL https://restful-booker.herokuapp.com/booking
    with the provided body below,
    the status code and
    the response has the expected body format as specified excluding ID.
    Request Body:
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
    Expected Body:
    {
        "bookingid": 24,
        "booking": {
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
    }
     */

    @Test
    public void post01(){
        // 1- Prepare the url.
        specHeroku.pathParams("pp1" , "booking");

        TestDataHeroku testDataHeroku = new TestDataHeroku();
        JSONObject requestBody = testDataHeroku.requestBodyCreationJSON();

        // 2- Prepare the Expected Data.
        JSONObject expectedData = testDataHeroku.expectedDataCreation();

        // 3- Save Response.
        Response response = given()
                                .spec(specHeroku)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(requestBody.toString())
                            .post("/{pp1}");

        JsonPath responseJP = response.jsonPath();
        response.prettyPrint();

        // 4- Assertion.
        assertEquals(testDataHeroku.statusSuccess , response.getStatusCode());
        assertEquals(expectedData.getJSONObject("booking").get("firstname"), responseJP.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"), responseJP.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"), responseJP.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"), responseJP.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"), responseJP.get("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                responseJP.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                responseJP.get("booking.bookingdates.checkout"));

    }
}