package test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetResponseAssertion {
    // Automate the test for the response returned when we send a GET request to the URL https://restful-booker.herokuapp.com/booking/10,
    // ensuring that:
    //  1- the status code is 200,
    //  2- the content type is application/json; charset=utf-8,
    //  3- the value of the Server header is Cowboy,
    //  4- the status line is HTTP/1.1 200 OK,
    //  5- and the response time is less than 5 seconds.

    @Test
    public void get01(){
        String url ="https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "Cowboy")
                .statusLine("HTTP/1.1 200 OK");

    }
}
