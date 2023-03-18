package com.alpi.Excel_util_read;

import com.alpi.utilities.ExcelUtil;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class ExcelUtilRead {

    @Test
    public void test1() {


        ExcelUtil cocktail = new ExcelUtil("src/test/resources/Cocktail_search.xlsx", "Cocktail_Name");

        List<Map<String, String>> allCocktail = cocktail.getDataList();

        for (Map<String, String> eachUser : allCocktail) {
            System.out.println("eachUser = " + eachUser);
        }

    }
}
