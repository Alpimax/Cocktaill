@Cocktail
Feature: Search Ingredients By Name

  Scenario Outline: Search for an ingredient by name and verify its details


    Given Accept type is "application/json"
    And Query param  "i" is "<name>"
    When user send GET request to "/search.php"
    Then status code should be 200
    And  verify "<Ingredient>" with "<Ingredient ID>"
    And User should able to see "<Description>"
    And verify "<Type>" is product
    And If "<Alcohol>" is "Yes" "<ABV>" should not be null


    Examples:
      | name              | Ingredient ID | Ingredient        | Description          | Type        | Alcohol | ABV  |
      | vodka             | 1             | Vodka             | Vodka is a distilled | Vodka       | Yes     | 40   |
      | tequila           | 4             | Tequila           | Tequila (Spanish     | Spirit      | Yes     | 40   |
      | Pomegranate juice | 602           | Pomegranate juice | Pomegranate          | Fruit Juice | No      | null |
      | Triple Sec        | 498           | Triple Sec        | Triple sec,          | Liqueur     | Yes     | 30   |
      | Whisky            | 601           | Whisky            | Whisky or whiskey    | Whisky      | Yes     | 40   |
      | Gin               | 2             | Gin               | Gin is a distilled   | Gin         | Yes     | 40   |
      | honey syrup       | 568           | Honey syrup       | In cooking           | Syrup       | No      | null |
      | rum               | 3             | Rum               | Rum is a distilled   | Rum         | Yes     | 40   |
      | cranberry juice   | 155           | Cranberry Juice   | Cranberry juice      | Juice       | No      | null |
      | orange            | 359           | Orange            | The orange is        | Fruit       | No      | null |


  Scenario Outline: Search for an invalid ingredient by name

    Given Accept type is "application/json"
    And  Query param  "i" is "<name>"
    When user send GET request to "/search.php"
    Then status code should be 200
    And search should return an "<Message>"



    Examples:
      | name            | Message |
      | abcd            | null    |
      | 123             | null    |
      | @#$%^&*()_+     | null    |
      | vodka1          | null    |
      | tequila-        | null    |
      | 123987123987    | null    |
      | !               | null    |
      | -  -            | null    |
      | specialchars&^% | null    |
      | non-alcoholic   | null    |
      |                 | null    |
      | empty           | null    |



