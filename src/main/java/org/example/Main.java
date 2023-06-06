package org.example;

import org.example.menu.MenuHandler;
import org.example.ui.ConsoleInput;
import org.example.ui.ConsoleOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please enter name and email as arguments!");
            return;
        }
        String name = args[0];
        String email = args[1];

        HtmlBuilder builder = new HtmlBuilder("");
        builder.setUpExample(name,email);

        ConsoleInput input = new ConsoleInput(new Scanner(System.in));
        ConsoleOutput output = new ConsoleOutput();

        MenuHandler menuHandler = new MenuHandler(input, output, builder);

        menuHandler.run();
    }
}