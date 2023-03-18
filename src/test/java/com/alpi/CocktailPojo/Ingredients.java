package com.alpi.CocktailPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredients {

    private String idIngredient;
    private String strIngredient;
    private String strDescription;
    private String strType;
    private String strAlcohol;
    private String strABV;
}
