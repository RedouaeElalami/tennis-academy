Feature: check the result of the first player Novack djokovic
  Scenario: client makes call to get /players/1
    When call /players/1
    Then  the client receives name of this player is "Novak Djokovic" and his age is 31





#Feature: User Login
#  User should be able to login using valide credentiels
#
#  Scenario Outline: Testing login with valid credentials
#    Given I am on login page
#    When I enter username as "<uname>" and password as "<pass>"
#    And I submit login page
#    Then I redirect to user home page
#
#    Examples:
#      | uname  | pass     |
#      | jsmith | demo1234 |
#      | admin  | admin    |