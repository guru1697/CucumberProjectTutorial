Feature: Search and place the order for Product

  @FirstTest
  Scenario: Search experience of product in both home and offers page

    Given User is on GreenKart landing page
    When User searched with the short name "Tom" and extracted the actual name
    Then User search for same product "Tom" in offers page to verify if product exist



