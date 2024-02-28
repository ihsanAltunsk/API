package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C15_BaseUrlJsonPlaceHolder extends JsonPlaceHolderBaseUrl {
    @Test
    public void get01(){
        // 1- Send a GET request to the https://jsonplaceholder.typicode.com/posts
        //    endpoint and test that the returned response has a status code of 200
        //    and there are 100 records in the response.

        // 1- Prepare the url.
        specJsonPlace.pathParam("pp1" , "posts");

        // 2- Prepare the Expected Data.
            // There is none for this query.

        // 3- Save Response.
        Response response = given().spec(specJsonPlace).when().get("/{pp1}");

        // 4- Assertion.
        response.then().assertThat()
                       .statusCode(200)
                       .body("title" , hasSize(100));
    }

    @Test
    public void get02(){
        // 2- Send a GET request to the https://jsonplaceholder.typicode.com/posts/44
        //    endpoint and test that the returned response has a status code of 200 and
        //    the value of the "title" is "optio dolor molestias sit".

        // 1- Prepare the url.
        specJsonPlace.pathParams("pp1" , "posts" , "pp2" , 44);

        // 2- Prepare the Expected Data.
        // There is none for this query.

        // 3- Save Response.
        Response response = given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

        // 4- Assertion.
        response.then().assertThat()
                       .statusCode(200)
                       .body("title" , equalTo("optio dolor molestias sit"));
    }

    @Test
    public void delete01(){
        // 3- Send a DELETE request to the https://jsonplaceholder.typicode.com/posts/50
        //        endpoint and test that the returned response has a status code of 200 and the
        //        response body is null.

        // 1- Prepare the url.
        specJsonPlace.pathParams("pp1" , "posts" , "pp2" , 50);

        // 2- Prepare the Expected Data.
        // There is none for this query.

        // 3- Save Response.
        Response response = given().spec(specJsonPlace).when().delete("/{pp1}/{pp2}");

        // 4- Assertion.
        response.then().assertThat()
                       .statusCode(200)
                       .body("title" , nullValue());
    }
}