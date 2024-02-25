package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get_ResponseBodyTest {

    //When we send a GET request to the URL https://jsonplaceholder.typicode.com/posts/44,
    //test that the returned response has:
    //1- a status code of 200,
    //2- a content type of ContentType.JSON,
    //3- the userId in the response body is 5,
    //4- and the title in the response body is "optio dolor molestias sit."
    @Test
    public void get01(){
        // 1- Prepare Endpoint.
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2- Prepare the Expected Data.
            // There is none for this query.

        // 3- Save Response.
        Response response = given().when().get(url);

        // 4- Assertion.
        response.then().assertThat()
                       .statusCode(200)
                       .contentType(ContentType.JSON)
                       .body("userId" , Matchers.equalTo(5))
                       .body("title", Matchers.equalTo("optio dolor molestias sit"));
    }
}
