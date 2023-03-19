package com.alpi.CocktailPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredients {

    private Object idIngredient;
    private Object strIngredient;
    private Object strDescription;
    private Object strType;
    private Object strAlcohol;
    private Object strABV;
}
