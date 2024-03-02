package testData;

import org.json.JSONObject;

public class TestDataHeroku {
    public int statusSuccess = 200;

    public JSONObject innerBookingCreationJSON(){
        JSONObject innerBooking = new JSONObject();
        innerBooking.put("checkin" , "2021-06-01");
        innerBooking.put("checkout" , "2021-06-10");

        return innerBooking;
    }

    public JSONObject requestBodyCreationJSON(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname" , "Ali");
        requestBody.put("lastname" , "Bak");
        requestBody.put("totalprice" , 500);
        requestBody.put("depositpaid" , false);
        requestBody.put("bookingdates" , innerBookingCreationJSON());
        requestBody.put("additionalneeds" , "wi-fi");

        return requestBody;
    }

    public JSONObject expectedDataCreation(){
        JSONObject expectedData = new JSONObject();
        expectedData.put("bookingid" , 24);
        expectedData.put("booking" , requestBodyCreationJSON());

        return expectedData;
    }
}