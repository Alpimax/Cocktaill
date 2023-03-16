@Cocktail
Feature: Search Cocktails By Name

  Scenario: Search for a Cocktail by Name (Case-insensitive)
    Given Accept type is "application/json"
    And Query param "s" is "MaRgaRitA"
    When user sends GET request to "/search.php"
    Then status code should be 200
    And response should not be null
    And response should contain "Margarita" in its name.


  Scenario: Search for a Non-existent Cocktail
    Given Accept type is "application/json"
    And Query param "s" is "@#$%^&*()_+"
    When user sends GET request to "/search.php"
    Then status code should be 200
    And response should be null

  Scenario: Search for a cocktail by name
    Given Accept type is "application/json"
    And Query param "s" is "margarita"
    When user sends GET request to "/search.php"
    Then status code should be 200
    And response should contain "drinks" array
    And "strDrink" field should be present in each drink
    And "strTags" field should be present in each drink
    And "strCategory" field should be present in each drink
    And "strAlcoholic" field should be present in each drink
    And "strGlass" field should be present in each drink
    And "strInstructions" field should be present in each drink
    And "strIngredient1" field should be present in each drink
    And "strMeasure1" field should be present in each drink
    And each drink should have "dateModified".
