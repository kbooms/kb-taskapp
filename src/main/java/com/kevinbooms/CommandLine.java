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
        System.out.println("    A lightweight rapid-fire task manager                        v0.5");
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
                    " is not a valid option." + System.lineSeparator());
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

    public String promptForString(String prompt) {
        System.out.println(prompt);
        return in.nextLine();
    }

    public int promptForInteger(String prompt) {
        System.out.println(prompt);
        int index;
        try {
            index = (Integer.parseInt(in.nextLine()) -1);
        } catch (IndexOutOfBoundsException i) {
            System.out.println("Task not found...");
            index = -1;
        }
        return index;
    }
}
