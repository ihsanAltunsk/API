package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C04_PUT_ResponseAssertion {

    /*
    When we send a PUT request to the URL https://jsonplaceholder.typicode.com/posts/70
    with the following JSON body:
    {
      "title": "Ahmet",
      "body": "Hello",
      "userId": 10,
      "id": 70
    }
    The expected response should have:
    1- a status code of 200,
    2- a content type of application/json; charset=utf-8,
    3- a Server header with the value cloudflare,
    4- and a status line of HTTP/1.1 200 OK.
    */
    @Test
    public void put01(){
        // 1- Prepare Endpoint and Request Body.
        String url = "https://jsonplaceholder.typicode.com/posts/70";
        JSONObject requestBody = new JSONObject();
        requestBody.put("title" , "Ahmet");
        requestBody.put("body" , "Hello");
        requestBody.put("userId" , 10);
        requestBody.put("id" , 70);

        // 2- Prepare the Expected Data.
            // There is none for this query.

        // 3- Save Response.
        // NOTE: If we are sending a request body in our query, we must specify the format of
        //       the data we are sending. We can specify this immediately after the given()
        //       method as a pre-condition.
        Response response = given().
                                contentType(ContentType.JSON)
                            .when()
                                .body(requestBody.toString())
                            .put(url);

        // 4- Assertion.
        response.then().assertThat()
                       .statusCode(200)
                       .contentType("application/json; charset=utf-8")
                       .header("Server","cloudflare")
                       .statusLine("HTTP/1.1 200 OK");
    }
}