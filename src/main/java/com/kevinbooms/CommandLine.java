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
    }

    public void displayTagline() {
        System.out.println("    A lightweight rapid-fire task manager                        v1.0");
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
        } catch (NumberFormatException n) {
            System.out.println("not a number");
            index = -2;
        }
        return index;
    }

    public Object getChoiceFromOptions(Object[] options) {
        Object choice = null;
        while (choice == null) {
            displayMenuOptions(options);
            choice = getChoiceFromUserInput(options);
        }
        return choice;
    }

    public void helpMe() {
        System.out.println("TASKMIN HELP");
        System.out.println(" This application keeps and manages lists of tasks as .txt files");
        System.out.println();
        System.out.println(" MAIN MENU:");
        System.out.println("*Create NewList* Creates a new blank list with a title of the");
        System.out.println(" user's choosing.");
        System.out.println("*Load List* Enter the filename of the list to load.");
        System.out.println(" lists are in .txt format");
        System.out.println("*Help* You are here!");
        System.out.println();
        System.out.println(" LIST MENU:");
        System.out.println("*Add Task* Write a new task and enter it on to the list.");
        System.out.println(" Leaving title blank will cancel the process.");
        System.out.println("*Remove Task* Enter the task number and it will be removed.");
        System.out.println(" Entering 0 will cancel the process.");
        System.out.println("*Change Title* Enter a new title to rename your list.");
        System.out.println(" Leaving title blank will cancel the process.");
        System.out.println("*Save List* Enter a file name and the list will be saved to");
        System.out.println(" it in .txt format");
        System.out.println();
        System.out.println("Thank you for using Taskmin");
        System.out.println("Questions or comments? Reach out to mrkbooms@gmail.com");
        System.out.println();
        System.out.println("Press ENTER to continue..");
        in.nextLine();
    }
}
