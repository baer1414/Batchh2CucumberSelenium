
@login
Feature: Krafttech Log in test
  # Agile story: As a user, I should be able to log in so I can see my account
  Background:
    Given User should be on the login page

@Coday @smoke @SDET
  Scenario: Login as Coday
    When The user enters Coday credentials
    Then The user should be able to login

@SDET @smoke @db
    Scenario: Login as Sebestian
      When The user enters Sebestian credentials
      Then The user should be able to login

      #class task user John nash
@developer
  Scenario: Login as Jhon Nash
    When The user enters Jhon Nash credentials
    Then The user should be able to login
  @smoke
  Scenario: Login as Rosa
    When The user enters Rosa credentials
    Then The user should be able to login

    Scenario: User should be abe to login with valid credentials
      When User should input login information
      Then User should be on home page
  @wip
  Scenario: login with parameters
    When  When User should input "user22@test.com" and "Test123456"
    Then User should be on home page


  Scenario: Login as a given user
    Then User should input following credentials

      | email    | user22@test.com |
      | password | Test123456      |
      | Name     | User22          |


  Scenario Outline: Data table and scenario outline
    Then User should input following credentials

      | email    | <userEmail> |
      | password | <password>  |
      | Name     | <name>      |

    Examples:
      | userEmail               | password   | name           |
      | user22@test.com         | Test123456 | User22         |
      | eddiem@kraft.com        | eddiem12   | Eddie Murphy   |
      | morganfreeman@kraft.com | mfreeman   | Morgan Freeman |