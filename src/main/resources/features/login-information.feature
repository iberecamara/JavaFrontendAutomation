Feature: Validate SwagLabs Login page

  Scenario Outline: Get Accepted usernames from Login page
    Given I open SwagLabs login page
    When I retrieve the "Accepted usernames" from Login page
    Then I can see "<username>" in the Accepted usernames list

    Examples:
      | username                 |
      | standard_user            |
      | locked_out_user          |
      | problem_user             |
      | performance_glitch_user  |
      | error_user               |
      | visual_user              |


  Scenario: Get common password from Login page
    Given I open SwagLabs login page
    When I retrieve the "Password for all users" from Login page
    Then I validate the common password value