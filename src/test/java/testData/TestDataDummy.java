package testData;

import org.json.JSONObject;

public class TestDataDummy {
    public int statusSuccess = 200;
    public String contentType = "application/json; charset=utf-8";

    public JSONObject expectedDataCreation(){
        JSONObject inner = new JSONObject();
        inner.put("id" , 3);
        inner.put("employee_name" , "Ashton Cox");
        inner.put("employee_salary" , 86000);
        inner.put("employee_age" , 66);
        inner.put("profile_image" , "");

        JSONObject expectedData = new JSONObject();
        expectedData.put( "status" , "success");
        expectedData.put("data" , inner);
        expectedData.put("message" , "Successfully! Record has been fetched.");

        return expectedData;
    }
}