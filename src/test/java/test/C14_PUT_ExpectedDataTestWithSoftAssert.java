package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_PUT_ExpectedDataTestWithSoftAssert {
    /*
    Test that when we send a PUT request to the https://dummy.restapiexample.com/api/v1/update/21
    with the following body, the returned response is as follows:
    Request Body:
    {
      "status": "success",
      "data": {
        "name": "Ahmet",
        "salary": "1230",
        "age": "44",
        "id": 40
      }
    }
    Response Body:
    {
      "status": "success",
      "data": {
        "status": "success",
        "data": {
          "name": "Ahmet",
          "salary": "1230",
          "age": "44",
          "id": 40
        }
      },
      "message": "Successfully! Record has been updated."
    }
     */

    @Test
    public void put01(){
        // 1- Prepare Endpoint and Request Body.
        String url = "https://dummy.restapiexample.com/api/v1/update/21";

        JSONObject innerBody = new JSONObject();
        innerBody.put("name" , "Ahmet");
        innerBody.put("salary" , "1230");
        innerBody.put("age" , "44");
        innerBody.put("id" , 40);

        JSONObject requestBody = new JSONObject();
        requestBody.put("status" , "success");
        requestBody.put("data" , innerBody);

        // 2- Prepare the Expected Data.
        JSONObject expected = new JSONObject();
        expected.put("status" , "success");
        expected.put("data" , requestBody);
        expected.put( "message" , "Successfully! Record has been updated.");

        // 3- Save Response.
        Response response = given()
                                .contentType(ContentType.JSON)
                            .when()
                                .body(requestBody.toString())
                            .put(url);

        // 4- Assertion.
        JsonPath responseJP = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        responseJP.prettyPrint();

        softAssert.assertEquals(responseJP.get("status"), expected.get("status"));
        softAssert.assertEquals(responseJP.get("data.data.name"),
                expected.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(responseJP.get("data.data.id"),
                expected.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJP.get("data.data.salary"),
                expected.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(responseJP.get("data.data.age"),
                expected.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(responseJP.get("data.status"), expected.getJSONObject("data").get("status"));
        softAssert.assertEquals(responseJP.get("message"), expected.get("message"));

        softAssert.assertAll();
    }
}
