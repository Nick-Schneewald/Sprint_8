package ru.yandex_praktikum.sprint8;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class AccountTest {
    private Account account;
    @Parameterized.Parameter
    public String nameSurnamePair;

    @Parameterized.Parameter(1)
    public boolean expectedResult;

    @Parameterized.Parameters(name = "{index} Checks if pair name/surname {0} can be printed on credit card, expected result {1}, ")
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {"Тимоте Шаломе",true},
                {"Арнольд Шварценейге", true},
                {"Т ",false},
                {"Ти Ш", true},
                {"Арнольд Шварценейг",true},
                {"Т", false},
                {"", false},
                {"Арнольд Шварценейгерррррр",false},
                {"Арнольд Шварценейгер",false},
                {"Арнольд Шварценейгерр",false},
                {"Тимоте  Шаламе",false},
                {"ТимотейШевроле",false},
                {"Тимоте     Шаламе",false},
                {"Тимоте   Шаламе",false},
                {" ТимотеШаламе",false},
                {"ТимотеШаламе ", false}
        });
    }
    @Test
    @DisplayName("Test checks name/surname pair for to be printed on credit card")
    @Description("Test checks name/surname pairs according to equivalence classes and border values")
    public void checkProperNameSurname(){
        account = new Account(nameSurnamePair);
        Assert.assertEquals(expectedResult, account.checkNameToEmboss());
    }
}
