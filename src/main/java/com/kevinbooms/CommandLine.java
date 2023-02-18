package com.kevinbooms;

import java.util.Scanner;

public class CommandLine {

    private final Scanner scanner = new Scanner(System.in);

    public void displayBanner() {
        System.out.println("_/_/_/_/_/                    _/                        _/           ");
        System.out.println("   _/      _/_/_/    _/_/_/  _/  _/    _/_/_/  _/_/        _/_/_/    ");
        System.out.println("  _/    _/    _/  _/_/      _/_/      _/    _/    _/  _/  _/    _/   ");
        System.out.println(" _/    _/    _/      _/_/  _/  _/    _/    _/    _/  _/  _/    _/    ");
        System.out.println("_/      _/_/_/  _/_/_/    _/    _/  _/    _/    _/  _/  _/    _/     ");
        System.out.println();
    }

    public String printGreeting() {
        return "Checking in!";
    }

    public void displayMainMenu() {
        System.out.println("1: Create New List");
        System.out.println("2: Load List");
        System.out.println("3: Help");
        System.out.println("0: Exit");
    }

    public void displayListMenu() {
        System.out.println("1: Add Task");
        System.out.println("2: Remove Task");
        System.out.println("3: Change Title");
        System.out.println("4: Save List");
        System.out.println("0: Exit (Go Back)");
    }

    public int promptForMenuSelection(String prompt) {

        int menuSelection;
        System.out.println(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public String promptForString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public int promptForTaskIndex(String prompt) {

        int userChoice;
        System.out.println(prompt);
        try {
            userChoice = Integer.parseInt(scanner.nextLine());
        } catch (IndexOutOfBoundsException i) {
            userChoice = -1;
        }
        return userChoice;
    }
}
