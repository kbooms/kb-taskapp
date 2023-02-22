package com.kevinbooms;

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
    private ToDoList toDoList;

    public App(CommandLine console, ToDoList toDoList) {
        this.console = console;
        this.toDoList = toDoList;
    }

    public void run() {
        console.displayBanner();
    }

    public static void main(String[] args) {

        CommandLine console = new CommandLine(System.in, System.out);
        ToDoList toDoList = new ToDoList();
        App app = new App(console, toDoList);
        app.run();
        System.out.println(console.printGreeting());


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
