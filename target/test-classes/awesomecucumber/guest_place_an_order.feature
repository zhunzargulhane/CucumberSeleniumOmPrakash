Feature: Place an Order as a guest user

  Scenario: Using default payment option
    Given I'm a guest user
    And The billing details are
      | firstName       | lastname       | country            | address_line1 | city          | state      | zip   | email              |
      | demofirstnameUS | demolastNameUS | United States (US) | myaddress     | San Francisco | California | 94188 | askomdch@gmail.com |
    And I have a product in the cart
    And I'm on the checkout page
    When I enter the billing address details
    And I place an order
    Then Order should be placed successfully