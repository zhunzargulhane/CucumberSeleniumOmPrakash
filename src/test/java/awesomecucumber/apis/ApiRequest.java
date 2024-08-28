package awesomecucumber.apis;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ApiRequest extends SpecBuilder{
    public static Response post(String endpoint, Headers headers,
                                HashMap<String,Object> formParam, Cookies cookies){
        Response response = given(getRequestSpec()).headers(headers).formParams(formParam).cookies(cookies).
                when().post(endpoint).then().spec(getResponseSpec()).extract().response();
        return response;
    }

    public static Response get(String endpoint, Cookies cookies){
        Response response = given(getRequestSpec()).cookies(cookies).
                when().get(endpoint).then().spec(getResponseSpec()).extract().response();
        return response;
    }
}
