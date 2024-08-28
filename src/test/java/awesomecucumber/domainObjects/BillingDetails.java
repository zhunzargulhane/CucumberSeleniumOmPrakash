package awesomecucumber.domainObjects;

import org.openqa.selenium.WebDriver;

public class BillingDetails {

    private String firstName;
    private String lastName;
    private String address_line1;
    private String city;
    private String state;
    private String zip;

    public BillingDetails(String firstName, String lastName, String address_line1, String city, String state, String zip, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address_line1 = address_line1;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
    }

    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
