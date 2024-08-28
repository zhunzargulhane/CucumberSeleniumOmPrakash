package awesomecucumber.apis;

import awesomecucumber.constants.Endpoints;
import io.cucumber.java.hu.Ha;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

public class AddToCartAPI {
    private Cookies cookies;
    public Cookies getCookies(){
        return cookies;
    }
    public AddToCartAPI(){

    }
    public AddToCartAPI(Cookies cookies){
        this.cookies=cookies;
    }

    public Response addProductToCart(int product_id,int qty){
        Header header = new Header("Content-Type","application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String,Object> formParams = new HashMap();
        formParams.put("product_id",product_id);
        formParams.put("quantity",qty);
        if(cookies==null)
            cookies = new Cookies();
        Response response = ApiRequest.post(Endpoints.ADD_TO_CART.endpoint,headers,formParams,cookies);
        if(response.getStatusCode()!=200)
            throw new RuntimeException("Unable to add product to the cart "+product_id);
        this.cookies=response.getDetailedCookies();
        return response;
    }
}
