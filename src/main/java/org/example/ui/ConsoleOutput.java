package org.example.ui;

import org.example.HtmlBuilder;
import org.example.elements.HtmlElement;

import java.util.List;

public class ConsoleOutput implements OutputHandler {

    @Override
    public void displayMainMenu(List<HtmlElement> currentElements) {
        System.out.println("\nCurrently stored elements:");
        currentElements.forEach(e -> System.out.print(e.getTagName() + " "));
        System.out.println("\nChoose what to do:");
        System.out.println("('add', 'remove', 'exit'[Print and Exit])");
    }

    @Override
    public void displayFinalResult(HtmlBuilder builder) {
        System.out.println(builder.toString());
    }

    @Override
    public void displayAddMenu() {
        System.out.println("\nWhat new element would you like to add?");
        System.out.println("Type(h1, a, p, table)");
    }

    @Override
    public void displayRemoveMenu() {
        System.out.println("\nWhat element would you like to remove?");
        System.out.println("Type(h1, a, p, table, tr, td)");
    }

    @Override
    public void successfulRemove(int removedItemNumber) {
        System.out.printf("\nSuccessfully removed %d items%n", removedItemNumber);
    }

    @Override
    public void displayEnterTextMenu() {
        System.out.println("\nEnter text:");
    }

    @Override
    public void displayEnterLinkMenu() {
        System.out.println("\nEnter link href for tag");
    }

    @Override
    public void displayTableSizeMenu() {
        System.out.println("\nTable size:");
        System.out.println("Row and column in separate lines (max 4 each)");
    }

    @Override
    public void displayCellInputMenu(int rowNumber, int columnNumber) {
        System.out.println("\nCurrently writing into row: " + rowNumber + ", column: " + columnNumber);
    }

    @Override
    public void displaySuccessfullyAddedItem() {
        System.out.println("\nSuccessfully added element");
    }

    @Override
    public void displayNotAddableElementTypes() {
        System.out.println("\nElements <tr> and <td> can not be added by themselves");
    }
}
