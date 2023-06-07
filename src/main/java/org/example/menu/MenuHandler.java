package org.example.menu;

import org.example.HtmlBuilder;
import org.example.elements.*;
import org.example.ui.ConsoleInput;
import org.example.ui.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;

public class MenuHandler {
    private boolean isRunning = true;

    private final ConsoleInput consoleInput;
    private final ConsoleOutput consoleOutput;
    private final HtmlBuilder builder;

    public MenuHandler(ConsoleInput consoleInput, ConsoleOutput consoleOutput, HtmlBuilder builder) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
        this.builder = builder;
    }

    public void run() {
        while (isRunning) {
            consoleOutput.displayMainMenu(builder.getElements());
            MenuInput selection = consoleInput.getMainMenuSelection();

            if (selection == MenuInput.EXIT) {
                exit();
            }
            if (selection == MenuInput.ADD) {
                addNewItemMenu();
            }
            if (selection == MenuInput.REMOVE) {
                removeItemMenu();
            }
        }
    }

    private void exit() {
        consoleOutput.displayFinalResult(builder);
        isRunning = false;
    }

    private void addNewItemMenu() {
        consoleOutput.displayAddMenu();
        ElementType elementTypeToAdd = consoleInput.getElementType();
        if (elementTypeToAdd == null) {
            return;
        }

        if (elementTypeToAdd == ElementType.A) {
            builder.addElement(createAnchor());
        } else if (elementTypeToAdd == ElementType.P) {
            builder.addElement(createParagraph());
        } else if (elementTypeToAdd == ElementType.H1) {
            builder.addElement(createHeading());
        } else if (elementTypeToAdd == ElementType.TABLE) {
            builder.addElement(createTable());
        } else {
            consoleOutput.displayNotAddableElementTypes();
            addNewItemMenu();
            return;
        }
        consoleOutput.displaySuccessfullyAddedItem();
    }

    private HtmlElement createAnchor() {
        consoleOutput.displayEnterTextMenu();
        String inside = consoleInput.getText();

        consoleOutput.displayEnterLinkMenu();
        String link = consoleInput.getText();

        return new Anchor(HtmlBuilder.BASEDEPTH, link, inside, true);
    }

    private HtmlElement createParagraph() {
        consoleOutput.displayEnterTextMenu();
        String inside = consoleInput.getText();

        return new Paragraph(HtmlBuilder.BASEDEPTH, inside, true);
    }

    private HtmlElement createHeading() {
        consoleOutput.displayEnterTextMenu();
        String inside = consoleInput.getText();

        return new Heading(HtmlBuilder.BASEDEPTH, inside, true);
    }

    private HtmlElement createTable() {
        consoleOutput.displayTableSizeMenu();
        int numberOfRows = consoleInput.getNumber();
        int numberOfColumns = consoleInput.getNumber();

        if (numberOfRows > 4 || numberOfRows < 1 || numberOfColumns < 1 || numberOfColumns > 4) {
            return createTable();
        }

        List<TableRow> rows = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            List<TableCell> columnsForRow = new ArrayList<>();
            for (int j = 0; j < numberOfColumns; j++) {
                consoleOutput.displayCellInputMenu(i + 1, j + 1);
                String celltext = consoleInput.getText();
                columnsForRow.add(new TableCell(HtmlBuilder.BASEDEPTH + 2, celltext));
            }
            rows.add(new TableRow(HtmlBuilder.BASEDEPTH + 1, columnsForRow));
        }

        return new Table(HtmlBuilder.BASEDEPTH, rows);
    }

    private void removeItemMenu() {
        consoleOutput.displayRemoveMenu();
        ElementType elementTypeToRemove = consoleInput.getElementType();
        if (elementTypeToRemove == null) {
            return;
        }

        builder.removeElement(elementTypeToRemove);

        consoleOutput.successfulRemove();
    }


}
