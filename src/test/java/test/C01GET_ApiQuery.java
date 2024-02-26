package test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C01GET_ApiQuery {
    // When we send a GET request to the URL https://restful-booker.herokuapp.com/booking/10,
    // the expected response should have:
    //   1- a status code of 200,
    //   2- a content type of application/json; charset=utf-8,
    //   3- a Server header with the value Cowboy,
    //   4- a status line of HTTP/1.1 200 OK,
    //   5- and the response time should be less than 5 seconds, manually verified.

    /*
    1- Prepare the necessary URL and, if needed, the Request Body for the request we will send.
    2- If provided in the question, prepare the Expected Data.
    3- Save the returned Response as Actual Data.
    4- We need to compare Expected Data with Actual Data, in other words, perform Assertion.
                                                                                             */
    @Test
    public void get01(){
        // 1- Prepare the necessary URL and, if needed, the Request Body for the request we will send.
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- If provided in the question, prepare the Expected Data.
            // There is none for this query.

        // 3- Save the returned Response as Actual Data.
        // 4- We need to compare Expected Data with Actual Data, in other words, perform Assertion.

                Response response = given().when().get(url);
        response.prettyPrint();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Content Type: " + response.getContentType());
        System.out.println("Header value: " + response.getHeader("Server"));
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Response Time: " + response.getTime());
    }
}