Feature: the result of all players

  Scenario Outline: client makes call to GET all players /players/"<id>"
    When the client calls /players/"<id>"
    Then the client receives Le nom de joueur "<name>"
#    And the client receives L'age de joueur "<age>"
    Examples:
      | id | name                  | age |
      | 1  | Novak Djokovic        | 31  |
      | 2  | Rafael Nadal          | 32  |
      | 3  | Roger Federer         | 32  |
      | 4  | Alexander Zverev      | 21  |
      | 5  | Juan Martin del Potro | 30  |
