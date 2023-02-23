package com.kevinbooms;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class CommandLine {

    private PrintWriter out;
    private Scanner in;

    public CommandLine(InputStream input, OutputStream output) {
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }

    public void displayBanner() {
        System.out.println("_/_/_/_/_/                    _/                        _/           ");
        System.out.println("   _/      _/_/_/    _/_/_/  _/  _/    _/_/_/  _/_/        _/_/_/    ");
        System.out.println("  _/    _/    _/  _/_/      _/_/      _/    _/    _/  _/  _/    _/   ");
        System.out.println(" _/    _/    _/      _/_/  _/  _/    _/    _/    _/  _/  _/    _/    ");
        System.out.println("_/      _/_/_/  _/_/_/    _/    _/  _/    _/    _/  _/  _/    _/     ");
        System.out.println("A lightweight rapid-fire task manager!");
    }

    public String printGreeting() {
        return "Checking in!";
    }

    public Object getChoiceFromOptions(Object[] options) {
        Object choice = null;
        while (choice == null) {
            displayMenuOptions(options);
            choice = getChoiceFromUserInput(options);
        }
        return choice;
    }

    public Object getChoiceFromUserInput(Object[] options) {
        Object choice = null;
        String userInput = in.nextLine();
        try {
            int selectedOption = Integer.valueOf(userInput);
            if (selectedOption > 0 && selectedOption <= options.length) {
                choice = options[selectedOption - 1]; // -1 to properly index
            }
        } catch (NumberFormatException n) {
            // eat the exception and display an error message to user
        }
        if (choice == null) {
            out.println(System.lineSeparator() + "!! " + userInput +
                    "is not a valid option." + System.lineSeparator());
        }
        return choice;
    }
    private void displayMenuOptions(Object[] options) {
        out.println();
        for (int i = 0; i < options.length; i++) {
            int optionNum = i + 1;
            out.println(" " + optionNum + ": " + options[i]);
        }
        out.print("\r\nPlease choose an option: ");
        out.flush();
    }

//    public void displayMainMenu() {
//        System.out.println("1: Create New List");
//        System.out.println("2: Load List");
//        System.out.println("3: Help");
//        System.out.println("0: Exit");
//    }
//
//    public void displayListMenu() {
//        System.out.println("1: Add Task");
//        System.out.println("2: Remove Task");
//        System.out.println("3: Change Title");
//        System.out.println("4: Save List");
//        System.out.println("0: Exit (Go Back)");
//    }
//
//    public int promptForMenuSelection(String prompt) {
//
//        int menuSelection;
//        System.out.println(prompt);
//        try {
//            menuSelection = Integer.parseInt(scanner.nextLine());
//        } catch (NumberFormatException e) {
//            menuSelection = -1;
//        }
//        return menuSelection;
//    }
//
//    public String promptForString(String prompt) {
//        System.out.println(prompt);
//        return scanner.nextLine();
//    }
//
//    public int promptForTaskIndex(String prompt) {
//
//        int userChoice;
//        System.out.println(prompt);
//        try {
//            userChoice = Integer.parseInt(scanner.nextLine());
//        } catch (IndexOutOfBoundsException i) {
//            userChoice = -1;
//        }
//        return userChoice;
//    }
}
