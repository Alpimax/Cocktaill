@API @Cocktail
Feature: Search Ingredients By Name

  Scenario Outline: Search for an ingredient by name and verify its details
    Given I have a valid ingredient  "<name>"
    When I search for the ingredient by  "<name>"
    Then the search results should include the following fields "<Ingredient ID>","<Ingredient>","<Description>","<Type>","<Alcohol>","<ABV>"

    Examples:
      | name              | Ingredient ID | Ingredient        | Description          | Type        | Alcohol | ABV  |
      | vodka             | 1             | Vodka             | Vodka is a distilled | Vodka       | Yes     | 40   |
      | tequila           | 4             | Tequila           | Tequila (Spanish     | Spirit      | Yes     | 40   |
      | Pomegranate juice | 602           | Pomegranate juice | Pomegranate          | Fruit Juice | No      | null |
      | Triple Sec        | 498           | Triple Sec        | Triple sec,          | Liqueur     | Yes     | null |
      | Whisky            | 601           | Whisky            | Whisky or whiskey    | Whisky      | Yes     | 40   |
      | Gin               | 2             | Gin               | Gin is a distilled   | Gin         | Yes     | 40   |
      | honey syrup       | 568           | Honey syrup       | In cooking           | Syrup       | No      | null |
      | rum               | 3             | Rum               | Rum is a distilled   | Rum         | Yes     | 40   |
      | cranberry juice   | 155           | Cranberry Juice   | Cranberry juice      | Juice       | No      | null |
      | orange            | 359           | Orange            | The orange is        | Fruit       | No      | null |


  Scenario Outline: Search for an invalid ingredient by name
    Given I have an invalid ingredient "<name>"
    When I search for the ingredient by "<name>"
    Then Search should return an "<ErrorMessage>"


    Examples:
      | name            | ErrorMessage |
      | abcd            | null         |
      | 123             | null         |
      | @#$%^&*()_+     | null         |
      | vodka1          | null         |
      | tequila-        | null         |
      | 123987123987    | null         |
      | !               | null         |
      | -  -            | null         |
      | specialchars&^% | null         |
      | non-alcoholic   | null         |
      | empty           | null         |
      | whiskey1        | null         |


