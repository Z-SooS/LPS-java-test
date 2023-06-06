package org.example.ui;

import org.example.elements.ElementType;
import org.example.menu.MenuInput;

import java.util.Scanner;

public class ConsoleInput implements InputHandler {

    private final Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public MenuInput getMainMenuSelection() {
        String input = scanner.nextLine();

        if (MenuInput.contains(input)) {
            return MenuInput.valueOf(input.toUpperCase());
        }

        return getMainMenuSelection();
    }

    @Override
    public ElementType getElementType() {
        String input = scanner.nextLine();

        if (ElementType.contains(input)) {
            return ElementType.valueOf(input.toUpperCase());
        }

        if (input.equals("back")) return null;

        return getElementType();
    }

    @Override
    public String getText() {
        return scanner.nextLine();
    }

    @Override
    public int getNumber() {
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }
}