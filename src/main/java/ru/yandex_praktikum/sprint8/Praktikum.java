package ru.yandex_praktikum.sprint8;

public class Praktikum {
    public static void main(String[] args) {
        String sourceString = "Тимоти Шаламе";
        Account account = new Account(sourceString);

        System.out.println(account.checkNameToEmboss());
    }
}
