package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataJsonPlace;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C18_GET_TestDataClassUsage extends JsonPlaceHolderBaseUrl {
    /*
    Test that when we send a GET request to the URL
    https://jsonplaceholder.typicode.com/posts/22,
    the returned response has a status code of 200 and
    the response body is the same as the one provided below:
    Expected Response Body:
    {
      "userId": 3,
      "id": 22,
      "title": "dolor sint quo a velit explicabo quia nam",
      "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */
    @Test
    public void get01(){
        // 1- Prepare the url.
        specJsonPlace.pathParams("pp1", "posts" , "pp2" , "22");

        // 2- Prepare the Expected Data.
        TestDataJsonPlace testDataJsonPlace = new TestDataJsonPlace();
        JSONObject expectedBody = testDataJsonPlace.expectedBodyCreation();

        // 3- Save Response.
        Response response = given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");
        JsonPath responseJP = response.jsonPath();

        // 4- Assertion.
        response.then().assertThat().statusCode(200).body("userId", equalTo(3) ,
                                                       "id" , equalTo(22) ,
                                                                "title" , equalTo("dolor sint quo a velit explicabo quia nam"),
                                                                "body" , equalTo("eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"));

    }
}
