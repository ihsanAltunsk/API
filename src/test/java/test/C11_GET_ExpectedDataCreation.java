package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C11_GET_ExpectedDataCreation {
    /*
    Test whether the response body returned when sending a GET request to the URL https://jsonplaceholder.typicode.com/posts/22
    is the same as the one given below:
    Response body:
    {
      "userId": 3,
      "id": 22,
      "title": "dolor sint quo a velit explicabo quia nam",
      "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum
               mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */
    @Test
    public void get01(){
        // 1- Prepare Endpoint.
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2- Prepare the Expected Data.
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId" , 3);
        expectedData.put("id" , 22);
        expectedData.put("title" , "dolor sint quo a velit explicabo quia nam");
        expectedData.put("body" , "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        // 3- Save Response.
        Response response = given().when().get(url);

        // 4- Assertion.

        JsonPath responseJP = response.jsonPath();
        assertEquals(expectedData.get("userId") , responseJP.get("userId"));
        assertEquals(expectedData.get("id") , responseJP.get("id"));
        assertEquals(expectedData.get("title") , responseJP.get("title"));
        assertEquals(expectedData.get("body") , responseJP.get("body"));
    }
}
