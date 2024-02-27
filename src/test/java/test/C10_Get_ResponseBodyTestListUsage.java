package test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestListUsage {
    /*
    When we send a GET request to the URL http://dummy.restapiexample.com/api/v1/employees,
    verify that the returned Response has
    1- a status code of 200,
    2- a content type of application/json,
    3- in the response body,
        - verify that the number of employees is 24,
        - and that one of the employees is "Ashton Cox",
        - and test that the ages entered are 61, 40, and 30.
                                                          */
    @Test
    public void get01(){
        // 1- Prepare Endpoint.
        String url = "http://dummy.restapiexample.com/api/v1/employees";

        // 2- Prepare the Expected Data.
            // There is none for this query.

        // 3- Save Response.
        Response response = given().when().get(url);

        // 4- Assertion.
        response.then().assertThat()
                       .statusCode(200)
                       .contentType("application/json")
                        .body("data.id", hasSize(24),
                       "data.employee_name", hasItem("Ashton Cox"),
                                 "data.employee_age", hasItems(61,30,40));
    }
}