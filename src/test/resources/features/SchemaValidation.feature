@API @Cocktail
Feature:  Schema validation

  Scenario Search for a Cocktail by Name and Validate API Response Schema

    Given the API is available for search "MaRgaRitA"
    When I search for a cocktail by name "MaRgaRitA"
    Then the API returns a response with a valid schema


  Scenario Outline: Search for an Invalid Cocktail Name and Validate API Response
    Given the API is available for search "<cocktail_name>"
    When I search for a cocktail by an invalid name "<cocktail_name>"
    Then the API returns a response with an error message

    Examples:
      | cocktail_name   |
      | MArigira1       |
      | 524gin1         |
      | @#$%^&*()_+     |
      | !               |
      | -  -            |
      | specialchars&^% |
      | non-alcoholic   |
      | empty           |
      | '  '            |
      | whiskey1        |


