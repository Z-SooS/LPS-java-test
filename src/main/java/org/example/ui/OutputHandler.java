package org.example.ui;

import org.example.HtmlBuilder;
import org.example.elements.HtmlElement;

import java.util.List;

public interface OutputHandler {
    void displayMainMenu(List<HtmlElement> currentElements);

    void displayFinalResult(HtmlBuilder builder);

    void displayAddMenu();

    void displayRemoveMenu();

    void successfulRemove();

    void displayEnterTextMenu();

    void displayEnterLinkMenu();

    void displayTableSizeMenu();

    void displayCellInputMenu(int rowNumber, int columnNumber);

    void displaySuccessfullyAddedItem();

    void displayNotAddableElementTypes();
}
