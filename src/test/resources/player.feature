Feature: the status is 200

  Scenario: client makes call to GET /players
    When the client calls /players
    Then the client receives status code of 200
