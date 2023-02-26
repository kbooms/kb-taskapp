package com.kevinbooms;

import com.kevinbooms.Task;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private static final String LIST_MENU_ADD_TASK = "Add Task";
    private static final String LIST_MENU_REMOVE_TASK = "Remove Task";
    private static final String LIST_MENU_CHANGE_TITLE = "Change Title";
    private static final String LIST_MENU_SAVE_LIST = "Save List (not implemented)";
    private static final String LIST_MENU_EXIT = "Exit";
    private static final String[] LIST_MENU_OPTIONS = { LIST_MENU_ADD_TASK,
                                                        LIST_MENU_REMOVE_TASK,
                                                        LIST_MENU_CHANGE_TITLE,
                                                        LIST_MENU_SAVE_LIST,
                                                        LIST_MENU_EXIT};

    private String title;
    // need to create a sequence to generate id's
//    private int idGenerator;
    private List<Task> tasks = new ArrayList<>();

    public ToDoList(){}

    public ToDoList(String title, List<Task> tasks) {
        this.title = title;
        this.tasks = tasks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void run() {
        CommandLine listConsole = new CommandLine(System.in, System.out);
        while (true) { // begin list manager loop
            // show the banner
            listConsole.displayBanner();
            // show the list
            showList();
            // get a choice from user, use LIST_MENU_OPTIONS
            String action = String.valueOf(listConsole.getChoiceFromOptions(LIST_MENU_OPTIONS));
            // list handler methods
            switch (action) {
                case LIST_MENU_ADD_TASK -> {
                    System.out.println("\n*** ADD A TASK ***\n");
                    // Prompt the user to write out the task
                    // Create a new Task object with the id and description
                    // Add task to the list
                    // Should return to the top loop from here
                }
                case LIST_MENU_REMOVE_TASK -> {
                    System.out.println("*** REMOVE A TASK ***");
                    // Prompt the user to enter a task id
                    // Remove task with id matching user input from list
                    // Should return to the top loop from here
                }
                case LIST_MENU_CHANGE_TITLE -> {
                    System.out.println("*** CHANGE TITLE ***");
                    // Prompt the user to enter a new title for the list
                    // use the setter to change the title of the list
                    // should return to the top loop from here
                }
                case LIST_MENU_SAVE_LIST -> {
                    System.out.println("*** SAVE LIST ***");
                    // to be implemented once FileManager class is in place
                }
                case LIST_MENU_EXIT -> {
                    return; // return user to main menu
                }
            }

        } // end list manager loop
    }
    private void showList() {
        System.out.println("-------------------------");
        System.out.println("| " + tasks.size() + " | " + getTitle());
        System.out.println("-------------------------");
        for (Task task : tasks) {
            System.out.println(tasks.indexOf(task) + ") " + task.getDescription());
        }

    }

    public void addTask(Task task) {
        tasks.add(task);
    }
    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
