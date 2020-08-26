@Validations @HomePageValidations @AutonomiaeAureamhometest
Feature: As an automation tester, I am able to successfully verify the validations implemented in home page
  Background:
    Given I access "Autonomiae Auream home" page
    Then I should be navigated to "Autonomiae Auream home" page

  @EmptyEmailAndPwdHomePageMandatoryValidation @emailvalidation
  Scenario: Verify whether email ID and Password are mandatory
    When I enter email address and password
      | Email | Password |
      |       |           |
    And click submit in home page
    Then I verify emailID and Password are mandatory

  @EmptyEmailHomePageMandatoryValidation @emailvalidation
  Scenario: Verify whether email ID is mandatory when password only entered
    When I enter email address and password
      | Email | Password |
      |       | Password123! |
    And click submit in home page
    Then I verify emailID is mandatory

  @EmailWithoutAmpersandHomePageMandatoryValidation @emailvalidation
  Scenario: Verify whether email ID format is validated when entered is mark
    When I enter email address and password
      | Email | Password |
      | mark  | Password678! |
    And click submit in home page
    Then I should see error message "Please include an '@' in the email address. 'mark' is missing an '@'."

  @EmptyFollowedByAmpersandHomepageEmailAddressValidation @emailvalidation
  Scenario: Verify whether email ID format is validated when entered is james@
    When I enter email address and password
      | Email   | Password |
      | james@ | Password1! |
    And click submit in home page
    Then I should see error message "Please enter a part following '@'. 'james@' is incomplete."

  @SpaceInEmailHomepageEmailAddressValidation @emailvalidation
  Scenario: Verify whether email ID format is validated when entered is mi ke@gmail.com
    When I enter email address and password
      | Email           | Password |
      | mi ke@gmail.com | Password1! |
    And click submit in home page
    Then I should see error message "A part followed by '@' should not contain the symbol ' '."

  @SpecialCharacterInEmailBeforeAmpersandHomepageEmailAddressValidation @emailvalidation
  Scenario: Verify whether email ID format is validated when entered is al$x@gmail.com
    When I enter email address and password
      | Email           | Password |
      | al$x@gmail.com  | Password1! |
    Then I should see error message "A part followed by '@' should not contain the symbol '$'."

  @SpaceInEmailAfterAmpersandHomepageEmailAddressValidation @emailvalidation
  Scenario: Verify whether email ID format is validated when entered is julia@g mail.com
    When I enter email address and password
      | Email | Password |
      | julia@g mail.com | Password1! |
    And click submit in home page
    Then I should see error message "A part following '@' should not contain the symbol ' '."

  @SpecialCharacterInEmailAfterAmpersandHomepageEmailAddressValidation @emailvalidation
  Scenario: Verify whether email ID format is validated when entered is oliver@g$mail.com
    When I enter email address and password
      | Email | Password |
      | oliver@g$mail.com | Password1! |
    And click submit in home page
    Then I should see error message "A part following '@' should not contain the symbol '$'."

  @EmptyPwdHomePageMandatoryValidation @passwordvalidation
  Scenario: Verify whether password is mandatory when Email only entered
    When I enter email address and password
      | Email | Password |
      | nathan@gmail.com | |
    And click submit in home page
    Then I verify password is mandatory

  @PasswordLengthHomepageValidation @passwordvalidation
  Scenario: Verify whether password Length is greater than or Equal to 8
    When I enter email address and password
      | Email | Password |
      | peter@gmail.com | Pwd123 |
    And click submit in home page
    Then I should see error message "Password length should be greater than or Equal to 8"

  @PasswordShouldcontainatleastoneSpecialCharacterHomepageValidation @passwordvalidation
  Scenario: Verify whether password contains atleast one special character
    When I enter email address and password
      | Email | Password |
      | shane@gmail.com | Password1 |
    And click submit in home page
    Then I should see error message "Password should contain atleast one special character"

  @PasswordShouldcontainatleastonenumericcharacterHomepageValidation @passwordvalidation
  Scenario: Verify whether password contains atleast one numeric character
    When I enter email address and password
      | Email | Password |
      | stephen@gmail.com | Password! |
    And click submit in home page
    Then I should see error message "Password should contain atleast one numeric character"

  @allImagesinhomePageLoadedValidations @HomePageImageValidation
  Scenario: Verify whether all images in index page are loaded
    Then all images in the "home" page are loaded