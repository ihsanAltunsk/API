package test;

import baseUrl.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C20_GET_TestDataUsage extends DummyBaseUrl {
    /*
    Test that the response, when sending a GET request to the URL http://dummy.restapiexample.com/api/v1/employee/3,
    has a status code of 200,
    a content type of "application/json"
    and a body matching the expected data provided below.
    Expected Body:
    {
        "status": "success",
        "data": {
            "id": 3,
            "employee_name": "Ashton Cox",
            "employee_salary": 86000,
            "employee_age": 66,
            "profile_image": ""
        },
        "message": "Successfully! Record has been fetched."
    }
     */
    @Test
    public void get01(){
        // 1- Prepare the url.
        specDummy.pathParams("pp1" , "api" , "pp2" , "v1" , "pp3" , "employee" , "pp4" , "3");

        // 2- Prepare the Expected Data.
        TestDataDummy testDataDummy = new TestDataDummy();
        JSONObject expectedData = testDataDummy.expectedDataCreation();

        // 3- Save Response.
        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");
        JsonPath responseJP = response.jsonPath();

        // 4- Assertion.
        assertEquals(testDataDummy.statusSuccess , response.getStatusCode());
        assertEquals(testDataDummy.contentType , response.getContentType());
        assertEquals(expectedData.get("status") , responseJP.get("status"));
        assertEquals(expectedData.get("message") , responseJP.get("message"));
        assertEquals(expectedData.getJSONObject("data").get("id") , responseJP.get("data.id"));
        assertEquals(expectedData.getJSONObject("data").get("employee_name") , responseJP.get("data.employee_name"));
        assertEquals(expectedData.getJSONObject("data").get("employee_salary") , responseJP.get("data.employee_salary"));
        assertEquals(expectedData.getJSONObject("data").get("employee_age") , responseJP.get("data.employee_age"));
        assertEquals(expectedData.getJSONObject("data").get("profile_image") , responseJP.get("data.profile_image"));
    }
}