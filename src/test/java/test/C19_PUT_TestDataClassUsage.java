package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataJsonPlace;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C19_PUT_TestDataClassUsage extends JsonPlaceHolderBaseUrl {
    /*
    Test sending a PUT request to the following URL: https://jsonplaceholder.typicode.com/posts/70,
    with the body provided below. Verify that
    the returned response has a status code of 200,
    a content type of "application/json; charset=utf-8",
    a Connection header value of "keep-alive",
    and that the response body matches the expected data given below.
    Request Body:
    {
        "title": "Ali",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
    }
    Expected Data:
    {
        "title": "Ali",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
    }
    */

    @Test
    public void put01(){
        // 1- Prepare the url.
        specJsonPlace.pathParams("pp1" , "posts" , "pp2" , "70");

        TestDataJsonPlace testDataJsonPlace = new TestDataJsonPlace();
        JSONObject requestBody = testDataJsonPlace.requestBodyCreationJSON();

        // 2- Prepare the Expected Data.
        JSONObject expectedData = testDataJsonPlace.requestBodyCreationJSON();

        // 3- Save Response.
        Response response = given()
                                .spec(specJsonPlace)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(requestBody.toString())
                            .put("/{pp1}/{pp2}");
        JsonPath responseJP = response.jsonPath();

        // 4- Assertion.
        assertEquals(testDataJsonPlace.statusSuccess , response.getStatusCode());
        assertEquals(testDataJsonPlace.contentType , response.getContentType());
        assertEquals(testDataJsonPlace.connectionHeaderValue , response.getHeader("Connection"));

        assertEquals(expectedData.get("userId") , responseJP.get("userId"));
        assertEquals(expectedData.get("id") , responseJP.get("id"));
        assertEquals(expectedData.get("title") , responseJP.get("title"));
        assertEquals(expectedData.get("body") , responseJP.get("body"));
    }
}