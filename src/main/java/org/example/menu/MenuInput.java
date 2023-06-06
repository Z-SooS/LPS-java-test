package org.example.menu;

public enum MenuInput {
    ADD,
    REMOVE,
    EXIT;

    public static boolean contains(String test) {

        for (MenuInput menuInput : MenuInput.values()) {
            if (menuInput.name().equals(test.toUpperCase())) {
                return true;
            }
        }

        return false;
    }
}
