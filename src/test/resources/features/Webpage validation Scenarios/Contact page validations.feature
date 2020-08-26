@Validations @ContactPageValidations @AutonomiaeAureamhometest
Feature: As an automation tester, I am able to successfully verify the validations implemented in Contact page
  Background:
    Given I access "Autonomiae Auream home" page
    Then  I should be navigated to "Autonomiae Auream home" page
    When I enter email address and password
      | Email             | Password   |
      | philip@gmail.com  | Password1! |
    And  click submit in home page
    Then I should be navigated to "Information station" page
    And  I click contact link
    Then I should be navigated to "Contact" page

  @EmptyEmailContactPageMandatoryValidation  @emailvalidationcontact
  Scenario: Verify whether email ID is mandatory in contacts page
    When I enters contact details
      | Email            | Firstname | Lastname| Phonenumber | Requesttype  | comment |
      |                  | James     | Smith   | 07405741281  | New Ticket  |Sample   |
    And  click submit in contact page
    Then I verify emailID is mandatory

  @EmailWithoutAmpersandContactPageMandatoryValidation  @emailvalidationcontact
  Scenario: Verify whether email ID format is validated when entered is mark
    When I enters contact details
      | Email            | Firstname | Lastname| Phonenumber | Requesttype  | comment |
      | mark             | Mark      | Smith   | 07405741281  | New Ticket  |Sample   |
    And  click submit in contact page
    Then I should see error message "Please include an '@' in the email address. 'mark' is missing an '@'."

  @EmptyFollowedByAmpersandContactpageEmailAddressValidation  @emailvalidationcontact
  Scenario: Verify whether email ID format is validated when entered is james@
    When I enters contact details
      | Email            | Firstname | Lastname| Phonenumber | Requesttype  | comment |
      | james@           | James     | Smith   | 07405741281  | New Ticket  |Sample   |
    And  click submit in contact page
    Then I should see error message "Please enter a part following '@'. 'james@' is incomplete."

  @SpaceInEmailcontactpageEmailAddressValidation  @emailvalidationcontact
  Scenario: Verify whether email ID format is validated when entered is mi ke@gmail.com
    When I enters contact details
      | Email            | Firstname | Lastname| Phonenumber | Requesttype  | comment |
      | mi ke@gmail.com  | Mike      | Smith   | 07405741281  | New Ticket  |Sample   |
    And  click submit in contact page
    Then I should see error message "A part followed by '@' should not contain the symbol ' '."

  @SpecialCharacterInEmailBeforeAmpersandcontactpageEmailAddressValidation  @emailvalidationcontact
  Scenario: Verify whether email ID format is validated when entered is al$x@gmail.com
    When I enters contact details
      | Email            | Firstname | Lastname| Phonenumber | Requesttype  | comment |
      | al$x@gmail.com   | Alex      | Smith   | 07405741281  | New Ticket  |Sample   |
    Then I should see error message "A part followed by '@' should not contain the symbol '$'."

  @SpaceInEmailAfterAmpersandcontactpageEmailAddressValidation  @emailvalidationcontact
  Scenario: Verify whether email ID format is validated when entered is julia@g mail.com
    When I enters contact details
      | Email            | Firstname | Lastname| Phonenumber | Requesttype  | comment |
      | julia@g mail.com | Julia     | Smith   | 07405741281  | New Ticket  |Sample   |
    And  click submit in contact page
    Then I should see error message "A part following '@' should not contain the symbol ' '."

  @SpecialCharacterInEmailAfterAmpersandcontactpageEmailAddressValidation  @emailvalidationcontact
  Scenario: Verify whether email ID format is validated when entered is oliver@g$mail.com
    When I enters contact details
      | Email             | Firstname | Lastname| Phonenumber | Requesttype  | comment |
      | oliver@g$mail.com | Oliver    | Smith   | 07405741281  | New Ticket  |Sample   |
    And  click submit in contact page
    Then I should see error message "A part following '@' should not contain the symbol '$'."

  @EmptyFirstNameContactPageMandatoryValidated @namevalidation @firstnamevalidation
  Scenario: Verify whether firstname is mandatory when other details are provided
    When I enters contact details
      | Email            | Firstname | Lastname | Phonenumber | Requesttype  | comment |
      | philip@gmail.com |           | Patrick  | 07405741281 | New Ticket   |         |
    And  click submit in contact page
    Then I verify "first name" field is mandatory


  @NumericValueInFirstNameContactPageMandatoryValidated @namevalidation @firstnamevalidation
  Scenario: Verify whether firstname field is validated when James2 is entered
    When I enters contact details
      | Email            | Firstname | Lastname | Phonenumber | Requesttype  | comment   |
      | jamesj@gmail.com | James2    | Joseph   | 07405741281 | New Ticket   | New Query |
    And  click submit in contact page
    Then I should see error message "First Name should not contain numeric value"

  @SpecialCharacterInFirstNameContactpageEmailAddressValidation @namevalidation  @firstnamevalidation
  Scenario: Verify whether firstname field is validated when Stephen! is entered
    When I enters contact details
      | Email               | Firstname | Lastname| Phonenumber | Requesttype  | comment     |
      | stephens@gmail.com | Stephen!  | Smith   | 07405741281  | New Ticket  |New Update   |
    And  click submit in contact page
    Then I should see error message "First Name should not contain special character"

  @EmptyLastNameContactPageMandatoryValidated @namevalidation @lastnamevalidation
  Scenario: Verify whether lastname is mandatory when other details are provided
    When I enters contact details
      | Email            | Firstname | Lastname | Phonenumber | Requesttype  | comment |
      | philip@gmail.com | Philip    |          | 07405741281 | New Ticket   |         |
    And  click submit in contact page
    Then I verify "last name" field is mandatory



  @NumericValueInLastNameContactPageMandatoryValidated @namevalidation @lastnamevalidation
  Scenario: Verify whether lastname field is validated when Joseph2 is entered
    When I enters contact details
      | Email            | Firstname | Lastname | Phonenumber | Requesttype  | comment   |
      | jamesj@gmail.com | James     | Joseph2  | 07405741281 | New Ticket   | New Query |
    And  click submit in contact page
    Then I should see error message "Last Name should not contain numeric value"

  @SpecialCharacterInLastNameContactpageEmailAddressValidation @namevalidation  @lastnamevalidation
  Scenario: Verify whether lastname field is validated when Smith! is entered
    When I enters contact details
      | Email               | Firstname | Lastname| Phonenumber | Requesttype  | comment     |
      | stephens@gmail.com  | Stephen   | Smith!  | 07405741281  | New Ticket  |New Update   |
    And  click submit in contact page
    Then I should see error message "Last Name should not contain special character"

  @EmptyPhoneNumberContactPageMandatoryValidated @phonenumbervalidation
  Scenario: Verify whether phone number is mandatory when other details are provided
    When I enters contact details
      | Email            | Firstname | Lastname | Phonenumber | Requesttype  | comment   |
      | philip@gmail.com | Philip    | Patrick  |             | New Ticket   | New user  |
    And  click submit in contact page
    Then I verify "phone number" field is mandatory

  @AlphabetValueInPhoneNumberContactPageMandatoryValidated @phonenumbervalidation
  Scenario: Verify whether phone number field is validated when 0745Ac12123 is entered
    When I enters contact details
      | Email            | Firstname | Lastname | Phonenumber | Requesttype  | comment   |
      | jamesj@gmail.com | James     | Joseph   | 0745Ac12123 | New Ticket   | New Query |
    And  click submit in contact page
    Then I should see error message "Phone Number should not contain Alphabetical value"

  @SpecialCharacterInPhoneNumberContactpageEmailAddressValidation @phonenumbervalidation
  Scenario: Verify whether phone number field is validated when 075 38383!@ is entered
    When I enters contact details
      | Email               | Firstname | Lastname| Phonenumber | Requesttype  | comment     |
      | stephens@gmail.com  | Stephen   | Smith   | 075 38383!@ | New Ticket  |New Update   |
    And  click submit in contact page
    Then I should see error message "Last Name should not contain special character"

  @PhoneNumberLengthValidation  @phonenumbervalidation
  Scenario: Verify whether phone number length is exactly 10 , entered as 07538
    When I enters contact details
      | Email               | Firstname | Lastname| Phonenumber | Requesttype  | comment     |
      | stephens@gmail.com  | Stephen   | Smith   | 07538       | New Ticket   |New Update   |
    And  click submit in contact page
    Then I should see error message "Phone number should have only 10 digits."

  @PhoneNumberLengthValidation2  @phonenumbervalidation
  Scenario: Verify whether phone number length is exactly 10 , entered as 075389016254
    When I enters contact details
      | Email               | Firstname | Lastname| Phonenumber  | Requesttype  | comment     |
      | stephens@gmail.com  | Stephen   | Smith   | 075389016254 | New Ticket   | New Update   |
    And  click submit in contact page
    Then I should see error message "Phone number should have 10 digits."

  @CommentsInContactPageNotMandatoryValidated @commentsvalidation
  Scenario: Verify whether comments in contact page is not mandatory
    When I enters contact details
      | Email            | Firstname | Lastname | Phonenumber   | Requesttype  | comment   |
      | philip@gmail.com | Philip    | Patrick  | 07405741281   | New Ticket   |           |
    And  click submit in contact page
    Then I should be navigated to "Information station" page

  @allImagesinContactPageLoadedValidations @contactImageValidation
  Scenario: Verify whether all images in contact page are loaded
    Then all images in the "contact" page are loaded




