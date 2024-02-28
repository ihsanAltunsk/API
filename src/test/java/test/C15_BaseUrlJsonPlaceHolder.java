package test;

import org.testng.annotations.Test;

public class C15_BaseUrlJsonPlaceHolder {
    /*
    Create 3 test methods inside the Class and perform the following tests:
    1- Send a GET request to the https://jsonplaceholder.typicode.com/posts
       endpoint and test that the returned response has a status code of 200
       and there are 100 records in the response.
    2- Send a GET request to the https://jsonplaceholder.typicode.com/posts/44
       endpoint and test that the returned response has a status code of 200 and
       the value of the "title" is "optio dolor molestias sit".
    3- Send a DELETE request to the https://jsonplaceholder.typicode.com/posts/50
       endpoint and test that the returned response has a status code of 200 and the
       response body is null.
     */
    @Test
    public void get01(){
        //1- Send a GET request to the https://jsonplaceholder.typicode.com/posts
        //   endpoint and test that the returned response has a status code of 200
        //   and there are 100 records in the response.


    }

    @Test
    public void get02(){

    }

    @Test
    public void delete01(){

    }
}
