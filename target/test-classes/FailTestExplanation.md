Requirements: 

*** If an ingredient is alcoholic, Alcohol is yes and ABV is not null ***
Triple sec" in this scenario the alcohol is yes but the ABV was null from the actual response result however based on the requirements if for any Cocktail the Alcohol is yes the ABV should not be null either something is missing in the requirements or there is a potential bug in the response, based on this reason I did  not changed the requirements to pass that tests therefore I left the tests to be failed and provide this justification.


*** "Sangria the best" I was considering some edge cases for The Cocktail name in the postman to search by negative edge scenarios when I start putting two empty spaces in the query Params and send the get request based on the requirements I was supposed received the response (drinks = null) but I received this Cocktail information (Sangria the Best), I just want to bring this issue into your attention. 

