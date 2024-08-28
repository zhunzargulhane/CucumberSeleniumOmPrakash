package awesomecucumber.pages;

import awesomecucumber.base.BasePage;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;
    private static StorePage storePage;

    public static CartPage getCartPage(WebDriver driver) {
        if (cartPage == null)
            return new CartPage(driver);
        return cartPage;
    }

    public static CheckoutPage getCheckoutPage(WebDriver driver) {
        if (checkoutPage == null)
            return new CheckoutPage(driver);
        return checkoutPage;
    }

    public static StorePage getStorePage(WebDriver driver) {
        if (storePage == null)
            return new StorePage(driver);
        return storePage;
    }
}
