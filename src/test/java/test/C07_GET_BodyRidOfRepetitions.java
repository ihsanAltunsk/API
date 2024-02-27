package test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_GET_BodyRidOfRepetitions {

    //When we send a GET request to the URL 'https://restful-booker.herokuapp.com/booking/10',
    //test the returned Response for the following:
    // 1- The status code is 200,
    // 2- The content type is application/json; charset=utf-8,
    // 3- In the Response Body:
    //     - "firstname" is "Sally",
    //     - "lastname" is "Jones",
    //     - "totalprice" is 101,
    //     - "depositpaid" is false,
    //     - "additionalneeds" is "Breakfast".

    @Test
    public void get01(){
        // 1- Prepare Endpoint.
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Prepare the Expected Data.
            // There is none for this query.

        // 3- Save Response.
        Response response = given().when().get(url);

        // 4- Assertion.
        /* response.then().assertThat()
                       .statusCode(200)
                       .contentType("application/json; charset=utf-8")
                       .body("firstname", Matchers.equalTo("Sally"),
                               "lastname", Matchers.equalTo("Jones"),
                               "totalprice",Matchers.equalTo(101),
                               "depositpaid", Matchers.equalTo(false),
                               "additionalneeds", Matchers.equalTo("Breakfast"));
                                                                               */

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("firstname", equalTo("Sally"),
                        "lastname", equalTo("Jones"),
                        "totalprice", equalTo(101),
                        "depositpaid", equalTo(false),
                        "additionalneeds", equalTo("Breakfast"));
    }
}