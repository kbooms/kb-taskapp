package com.kevinbooms;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class App {

    private static final String MAIN_MENU_NEWLIST = "Create New List";
    private static final String MAIN_MENU_LOADLIST = "Load List (not implemented)";
    private static final String MAIN_MENU_HELP = "Help";
    private static final String MAIN_MENU_EXIT = "Exit";

    private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_NEWLIST,
                                                        MAIN_MENU_LOADLIST,
                                                        MAIN_MENU_HELP,
                                                        MAIN_MENU_EXIT };
    private CommandLine console;

    public App(CommandLine console) {
        this.console = console;
    }

    public void run() throws InterruptedException {
        console.displayBanner();
        console.displayTagline();

        while (true) { // begin main while loop
            /*  User must make a choice. The choices are presented as an array.
            *   Utilizing the command line, and its method getChoice, the user
            *   is shown the available options and prompted to respond.
            * */
            String choice = String.valueOf(console.getChoiceFromOptions(MAIN_MENU_OPTIONS));

            //  Based on the user's input, one of several actions will be performed
            switch (choice) {
                case MAIN_MENU_NEWLIST -> { // a new list is created
                    System.out.println();
                    String title = console.promptForString("Set a title for the list?");
                    List<Task> tasks = new ArrayList<>();
                    ToDoList toDoList = new ToDoList(title, tasks);
                    toDoList.run();

                }
                case MAIN_MENU_LOADLIST -> {
                    System.out.println();
                    String filePath = console.promptForString("Please enter the file name?");
                    FileManager fm = new FileManager();
                    ToDoList toDoList = fm.openFile(filePath);
                    toDoList.run();
                }
                case MAIN_MENU_HELP -> {
                    System.out.println("*** HELP MENU ***");
                    console.helpMe();
                }
                case MAIN_MENU_EXIT -> {
                    System.out.println("*** EXIT ***");
                    exit(0);
                }
                default -> {
                    System.out.println("*** not a valid option ***");
                }
            }
            console.displayBanner();
        } // end main while loop
    }

    public static void main(String[] args) {

        CommandLine console = new CommandLine(System.in, System.out);
        App app = new App(console);
        try {
            app.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
