package test;

public class C21_POST_TestDataUsage {
    /*
    Test that when sending a POST request to the URL https://restful-booker.herokuapp.com/booking
    with the provided body below,
    the response has the expected body format as specified,
    excluding the status code and ID.
    Request Body:
    {
        "firstname": "Ali",
        "lastname": "Bak",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }
    Expected Body:
    {
        "bookingid": 24,
        "booking": {
            "firstname": "Ali",
            "lastname": "Bak",
            "totalprice": 500,
            "depositpaid": false,
            "bookingdates": {
                "checkin": "2021-06-01",
                "checkout": "2021-06-10"
            },
            "additionalneeds": "wi-fi"
        }
    }
     */
}
