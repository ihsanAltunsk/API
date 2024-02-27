package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_POST_AssertionWithExpectedDataAndJsonPath {
        /*
        Test whether the response, when sending a POST request to the URL https://restful-booker.herokuapp.com/booking
        with the provided body, matches the expected body below (excluding the 'id' in the response).
        Request body:
        {
          "firstname": "Ahmet",
          "lastname": "Bulut",
          "totalprice": 500,
          "depositpaid": false,
          "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
          },
          "additionalneeds": "wi-fi"
        }
        Expected Response Body:
        {
          "bookingid": 24,
          "booking": {
            "firstname": "Ahmet",
            "lastname": "Bulut",
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
        // 1- Prepare Endpoint and Request Body.
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin" , "2021-06-01");
        bookingDates.put("checkout" , "2021-06-10");

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname" , "Ahmet");
        requestBody.put("lastname" , "Bulut");
        requestBody.put("totalprice" , 500);
        requestBody.put("depositpaid" , false);
        requestBody.put("bookingdates" , bookingDates);
        requestBody.put("additionalneeds" , "wi-fi");

        // 2- Prepare the Expected Data.
        JSONObject expectedData = new JSONObject();
        expectedData.put("bookingid" , 24);
        expectedData.put("booking" , requestBody);
        expectedData.put("additionalneeds" , "wi-fi");

        // 3- Save Response.
        Response response = given()
                                .contentType(ContentType.JSON)
                            .when()
                                .body(requestBody.toString())
                                .post(url);

        // 4- Assertion.
        JsonPath responseJP = response.jsonPath();
        assertEquals(expectedData.getJSONObject("booking").get("firstname") , responseJP.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname") , responseJP.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice") , responseJP.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid") , responseJP.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds") , responseJP.get("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin") , responseJP.get("booking.bookingdates.checkin") );
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout") , responseJP.get("booking.bookingdates.checkout") );
    }
}