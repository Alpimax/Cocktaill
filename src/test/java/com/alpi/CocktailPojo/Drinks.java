package com.alpi.CocktailPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drinks {

    /** Response converter POJO class
     *  when working with a heavy payload.
     *
     */

    private String strDrink;
    private String strTags;
    private String strCategory;
    private String strAlcoholic;
    private String strGlass;
    private String strInstructions;
    private String strIngredient1;
    private String strMeasure1;
    private String strCreativeCommonsConfirmed;
    private String dateModified;



}
