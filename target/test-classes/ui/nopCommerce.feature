@UI
Feature: nopCommerce site

  Scenario: Order from the nopCommerce site
  Given that the registered user can access the nopCommerce site
  When the user adds the HTC One Mini Blue item to the cart
  Then navigates to the Shopping cart
  And does checkout
  And enters or selects existing Billing address info
  And selects Next Day Air Shipping method
  And selects Credit card as Payment method
  And provides Payment information
  And confirm the order