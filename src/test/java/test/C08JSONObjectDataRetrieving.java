package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C08JSONObjectDataRetrieving {
    /*
    {
    "firstName": "John",
    "lastName": "Doe",
    "age": 26,
    "address": {
    "streetAddress": "Naist Street",
    "city": "Nara",
    "postalCode": "630-0192"
                    },
    "phoneNumbers": [
                    {
                    "type": "iPhone",
                    "number": "0123-4567-8888"
                    },
                    {
                    "type": "home",
                    "number": "0123-4567-8910"
                    }
                    ]
                    }

     */
    @Test
    public void jsonPath01(){
        JSONObject phoneNumber = new JSONObject();
        phoneNumber.put("type" , "iPhone");
        phoneNumber.put("number" , "0123-4567-8888");

        JSONObject homeNumber = new JSONObject();
        homeNumber.put("type" , "home");
        homeNumber.put("number" , "0123-4567-8910");

        JSONArray numbers = new JSONArray();
        numbers.put(0,phoneNumber);
        numbers.put(1,homeNumber);

        JSONObject address = new JSONObject();
        address.put("streetAddress" , "Naist Street");
        address.put("city" , "Nara");
        address.put("postalCode" , "630-0192");

        JSONObject personalInformations = new JSONObject();
        personalInformations.put("firstName" , "John");
        personalInformations.put("lastName" , "Doe");
        personalInformations.put("age" , 26);
        personalInformations.put("address" , address);
        personalInformations.put("phoneNumbers" , numbers);

        System.out.println("Name : " + personalInformations.get("firstName"));
        System.out.println("Surname : " + personalInformations.get("lastName"));
        System.out.println("Age : " + personalInformations.get("age"));
        System.out.println("Street : " + personalInformations.getJSONObject("address").get("streetAddress"));
        System.out.println("City : " + personalInformations.getJSONObject("address").get("city"));
        System.out.println("Zip Code : " + personalInformations.getJSONObject("address").get("postalCode"));
        System.out.println("Phone no : " + personalInformations
                .getJSONArray("phoneNumbers")
                .getJSONObject(0)
                .get("number"));
        System.out.println("Type : " + personalInformations
                .getJSONArray("phoneNumbers")
                .getJSONObject(0)
                .get("type"));
        System.out.println("Phone no : " + personalInformations
                .getJSONArray("phoneNumbers")
                .getJSONObject(1)
                .get("number"));
        System.out.println("Type : " + personalInformations
                .getJSONArray("phoneNumbers")
                .getJSONObject(1)
                .get("type"));
    }
}
