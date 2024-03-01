package test;

import baseUrl.DummyBaseUrl;
import org.json.JSONObject;

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
    public void get01(){
        // 1- Prepare the url.
        specDummy.pathParams("pp1" , "api" , "pp2" , "v1" , "pp3" , "employee" , "pp4" , "3");

        // 2- Prepare the Expected Data.



    }
}
