@Validations @InfoPageValidation @AutonomiaeAureamhometest
  Feature: As an automation tester, I am able to successfully verify the contents of info station page
  Background:
    Given I access "Autonomiae Auream home" page
    Then  I should be navigated to "Autonomiae Auream home" page
    When I enter email address and password
      | Email             | Password   |
      | adam@gmail.com    | Password1! |
    And  click submit in home page
    Then I should be navigated to "Information station" page

    @allImagesininfoPageLoadedValidations @InfoimageValidation
    Scenario: Verify whether all images in info page are loaded
      Then all images in the "info" page are loaded

    @allPanelHeadingsDimensionInInfoPageValidations @panelheadingsizevalidation
    Scenario: Verify whether all panel headings in info page are of same dimension
      Then all panel headings in the info page are of same dimension

    @allpanelcontentininfopagevalidation @panelcontentvalidation
    Scenario: Verify whether all panel contents are as according to the persistent layer(JSON) content
      Then all panel contents in the info page are same as mentioned in the JSON

