package ru.yandex_praktikum.sprint8;

public class Account {
    private static final String WHITESPACE = " ";
    private static final int NOT_FOUND = -1;
    private static final int OCCURRENCES_ONCE = 1;
    private final String name;
    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if(name.length() > 2 && name.length() < 20) {
            if (countOccurrences(name.trim(),WHITESPACE.charAt(0)) == OCCURRENCES_ONCE) {
                 if (!name.startsWith(WHITESPACE) && !name.endsWith(WHITESPACE)) return true;
            }
        }
        return false;
    }

    private static int countOccurrences(String source, char ch){
        int count = 0;
        for (int i = 0; (i = source.indexOf(ch, i)) != NOT_FOUND; i++) {count++;}
        return count;
    }
}
