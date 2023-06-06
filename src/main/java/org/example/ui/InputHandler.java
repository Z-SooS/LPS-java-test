package org.example.ui;

import org.example.elements.ElementType;
import org.example.menu.MenuInput;

public interface InputHandler {
    MenuInput getMainMenuSelection();

    ElementType getElementType();

    String getText();

    int getNumber();
}
