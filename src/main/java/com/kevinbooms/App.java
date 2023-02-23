package com.kevinbooms;

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

    public void run() {
        console.displayBanner();

        while (true) { // begin main while loop
            //
            String choice = String.valueOf(console.getChoiceFromOptions(MAIN_MENU_OPTIONS));

            switch (choice) {
                case MAIN_MENU_NEWLIST -> {
                    System.out.println("CREATE NEW LIST");
                }
                case MAIN_MENU_LOADLIST -> {
                    System.out.println("LOAD A LIST");
                }
                case MAIN_MENU_HELP -> {
                    System.out.println("*** HELP MENU ***");
                }
                case MAIN_MENU_EXIT -> {
                    System.out.println("*** EXIT ***");
                    exit(0);
                }
                default -> {
                    System.out.println("*** not a valid option ***");
                }
            }
        } // end main while loop
    }

    public static void main(String[] args) {

        CommandLine console = new CommandLine(System.in, System.out);
        ToDoList toDoList = new ToDoList();
        App app = new App(console);
        app.run();
//        System.out.println(console.printGreeting());


        // *** manually testing Task and ToDoList class ***
//        Task taskOne = new Task(1, "The first task");
//        Task taskTwo = new Task(2, "The next right thing to do.");
//        ToDoList list = new ToDoList();
//        list.addTask(taskOne);
//        list.addTask(taskTwo);
//
//        System.out.println(list.getTasks().get(0).getDescription());
    }
}
