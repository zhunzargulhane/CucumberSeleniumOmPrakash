package awesomecucumber.utils;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {
    public static List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies){
        List<io.restassured.http.Cookie>  cookiesRestAssured = cookies.asList();
        List<Cookie> cookiesSelenium=new ArrayList<>();
        for(io.restassured.http.Cookie cookie:cookiesRestAssured){
            cookiesSelenium.add(new Cookie(cookie.getName(),cookie.getValue(),
                    cookie.getDomain(),cookie.getPath(),
                    cookie.getExpiryDate(),cookie.isSecured(),
                    cookie.isHttpOnly()));
        }
        return cookiesSelenium;
    }
}
