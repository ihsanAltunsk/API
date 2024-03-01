package testData;

import org.json.JSONObject;

public class TestDataDummy {
    public int statusSuccess = 200;
    public String contentType = "application/json";

    public JSONObject innerJSONBody (){

        JSONObject innerBody = new JSONObject();

        innerBody.put("id", 3);
        innerBody.put("employee_name","Ashton Cox");
        innerBody.put("employee_salary",86000);
        innerBody.put("employee_age",66);
        innerBody.put("profile_image","");

        return innerBody;
    }
    public JSONObject expectedDataCreation(){

        JSONObject expectedData = new JSONObject();

        expectedData.put("status","success");
        expectedData.put("message","Successfully! Record has been fetched.");
        expectedData.put("data",innerJSONBody());

        return expectedData;
    }
}