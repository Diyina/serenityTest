Feature: Users Details

  Scenario Outline: Get the details of Users
    Given I send a <id> request to endpoint
    When the API should return status <status code>
    Then response should contains <name>
    Examples:
      | id | status code | name    |
      | 1  | 200         | Terry  |
      | 3  | 200         | Terrill |
      | 5  | 200         | Mavis   |
