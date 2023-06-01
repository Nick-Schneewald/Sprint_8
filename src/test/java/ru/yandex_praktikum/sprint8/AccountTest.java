package ru.yandex_praktikum.sprint8;

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

    @Parameterized.Parameters(name = "{index} Проверка подходит ли пара имя/фамилия {0} для печати на карточке, результат {1}, ")
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {"Тимоте Шаломе",true},
                {"ТимотеШаломе", false},
                {"Тимоте  Шаломе",false},
                {"Тимоте     Шаломе", false},
                {" ТимотеШаломе", false},
                {"ТимотеШаломе ", false}
        });
    }
    @Test
    public void checkProperNameSurname(){
        account = new Account(nameSurnamePair);
        Assert.assertEquals(expectedResult, account.checkNameToEmboss());
    }
}
