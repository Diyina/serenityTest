Feature: Find a word using Wiktionary

  Scenario Outline: Wiktionary multiple search
    Given I want to search in wiktionary
    When I search for <term> word
    Then I should see a <definition> result
    Examples:
      |term   |definition |
      |apple  |fruit      |
      |coin   |money      |
      |coffee |beverage   |
