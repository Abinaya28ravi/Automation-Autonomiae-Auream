@E2Ehappypath @AutonomiaeAureamhometest
Feature: As a user, I am able to successfully login to 'Autonomiae Auream' website and also able to access information
  station ,also able to submit contact details.

  Background:
    Given I access "Autonomiae Auream home" page
    Then  I should be navigated to "Autonomiae Auream home" page


  Scenario: An E2E journey to login ,access information station and submit contact details
    When I enter email address and password
      | Email             | Password   |
      | sample@sample.com | Password1! |
    And  click submit in home page
    Then I should be navigated to "Information station" page
    #And  I should able to view all the contents of 'Information station' page
    And  I click contact link
    Then I should be navigated to "Contact" page
    When I enters contact details
     | Email            | Firstname | Lastname| Phonenumber | Requesttype  | comment |
     | sample@sample.com| James     | Smith   | 07405741281  | New Ticket  |Sample   |
     And click submit in contact page
    Then I should be navigated to "Information station" page

