package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C06POST_ResponseTest {
    //When we send a POST request to the url 'https://jsonplaceholder.typicode.com/posts'
    //with the following body:
    //{
    //"title": "API",
    //"body": "Learning API is wonderful",
    //"userId": 10
    //}
    //Test the returned Response for the following:
    // 1- The status code is 201,
    // 2- The content type is application/json,
    // 3- In the Response Body, the "title" is "API",
    // 4- The value of "userId" is less than 100,
    // 5- The "body" contains the word "API".
    @Test
    public void post01(){
        // 1- Prepare Endpoint and Request Body.
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title" , "API");
        requestBody.put("body" , "Learning API is wonderful");
        requestBody.put("userId" , 10);

        // 2- Prepare the Expected Data.
            // There is none for this query.

        // 3- Save Response.
        Response response = given().
                                contentType(ContentType.JSON).
                            when().
                                body(requestBody.toString()).
                            post(url);

        // 4- Assertion.
        response.then().assertThat()
                       .statusCode(201)
                       .contentType("application/json")
                       .body("title", Matchers.equalTo("API"))
                       .body("userId", Matchers.lessThan(100))
                       .body("body", Matchers.containsString("API"));
    }
}
