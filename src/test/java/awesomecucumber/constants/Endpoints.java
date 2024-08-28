package awesomecucumber.constants;

public enum Endpoints {
    STORE("/store"),
    CHECKOUT("/checkout"),
    ADD_TO_CART("/?wc-ajax=add_to_cart");
    public final String endpoint;

    Endpoints(String s) {
        endpoint = s;
    }

}
