package test;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C03JsonObjectCreation {
    //Create and print the following JSON object on the console:
    /*
    {
      "title": "Ahmet",
      "body": "Hello",
      "userId": 1
    }
    */
    @Test
    public void jsonObject01(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title" , "Ahmet");
        jsonObject.put("body" , "Hello");
        jsonObject.put("userId" , 1);

        System.out.println(jsonObject);
    }

    @Test
    public void jsonObject02(){
        /*
        {
        "firstname": "Jim",
        "additional needs": "Breakfast",
        "bookingdates":{
                "checkin":"2018-01-01",
                "checkout":"2019-01-01"
        },
        "totalprice": 111,
        "depositpaid": true,
        "Lastname": "Brown"
        }
        */

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin" , "2018-01-01");
        bookingDates.put("checkout" , "2019-01-01");

        JSONObject outerJson = new JSONObject();
        outerJson.put("firstname" ,  "Jim");
        outerJson.put("additional needs" , "Breakfast");
        outerJson.put("bookingDates" , bookingDates);
        outerJson.put("totalprice" , 111);
        outerJson.put("depositpaid" , true);
        outerJson.put("Lastname" , "Brown");
        System.out.println(outerJson);
    }
}