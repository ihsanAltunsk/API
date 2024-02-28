package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_GET_ExpectedDataTestWithSoftAssert {
    /*
    Test that when we send a GET request to the http://dummy.restapiexample.com/api/v1/employee/3,
    the returned response is as follows:
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
        // 1- Prepare Endpoint.
        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2- Prepare the Expected Data.
        JSONObject data = new JSONObject();
        data.put("id" , 3);
        data.put("employee_name" , "Ashton Cox");
        data.put("employee_salary" , 86000);
        data.put("employee_age" , 66);
        data.put("profile_image" , "");

        JSONObject expected = new JSONObject();
        expected.put("status" , "success");
        expected.put("data" , data);
        expected.put("message" , "Successfully! Record has been fetched.");

        // 3- Save Response.
        Response response = given().when().get(url);


        // 4- Assertion.
        JsonPath responseJP = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(expected.get("status") , responseJP.get("status"));
        softAssert.assertEquals(expected.getJSONObject("data").get("id") , responseJP.get("data.id"));
        softAssert.assertEquals(expected.getJSONObject("data").get("employee_name") , responseJP.get("data.employee_name"));
        softAssert.assertEquals(expected.getJSONObject("data").get("employee_salary") , responseJP.get("data.employee_salary"));
        softAssert.assertEquals(expected.getJSONObject("data").get("employee_age") , responseJP.get("data.employee_age"));
        softAssert.assertEquals(expected.getJSONObject("data").get("profile_image") , responseJP.get("data.profile_image"));
        softAssert.assertEquals(expected.get("message") , responseJP.get("message"));

        softAssert.assertAll();
    }
}