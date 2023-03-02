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
                    System.out.println("LOAD A LIST");
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

//        System.out.println(console.printGreeting());
        // *** designing and testing an id generator sequence
//        List<Task> tasks = new ArrayList<>();                // new list as sample Task list
//        ToDoList list = new ToDoList("test", tasks);    // new sample ToDoList, incorporates sample list
//        int idGen = tasks.size() + 1;                        // id generator prototype, +1 because of 0 indexing
//        Task task = new Task(idGen, "testing id generator");    // shows an id of 1
//        list.addTask(task);                                               // add the task to the list
//        // each time a task is added to the list, the id generator sequence must be run again.
//        // this can lead to duplicate id's as tasks are removed and added again. since it currently is only a tasklist,
//        // it doesn't need id's at all. The numbering can be achieved with a simple for loop when printing out the list
//        idGen = tasks.size() + 1;
//        Task task1 = new Task(idGen, "testing id generator again");
//        list.addTask(task1);
//        System.out.println(list.getTasks());

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
