Feature: Login into SwagLabs

  Scenario Outline: Login with users
    Given I open SwagLabs login page
    When I set the username as "<username>"
    And I set the password as "common password"
    And I click Login button
    Then Login is "successful"
    And I can see app logo text as Swag Labs

    Examples:
      | username                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |
      | error_user              |
      | visual_user             |


  Scenario Outline: Validate error message for unsuccessful login attempts
    Given I open SwagLabs login page
    When I set the username as "<username>"
    And I set the password as "<password>"
    And I click Login button
    Then I can see "<error_message>" displayed as error message

    Examples:
      | username                | password          | error_message                                                              |
      | standard_user           | bad password      | Epic sadface: Username and password do not match any user in this service  |
      | locked_out_user         | common password   | Epic sadface: Sorry, this user has been locked out.                        |
