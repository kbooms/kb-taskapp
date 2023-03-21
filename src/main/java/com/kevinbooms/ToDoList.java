package com.kevinbooms;

import com.kevinbooms.Task;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private static final String LIST_MENU_ADD_TASK = "Add Task";
    private static final String LIST_MENU_REMOVE_TASK = "Remove Task";
    private static final String LIST_MENU_CHANGE_TITLE = "Change Title";
    private static final String LIST_MENU_SAVE_LIST = "Save List";
    private static final String LIST_MENU_EXIT = "Exit";
    private static final String[] LIST_MENU_OPTIONS = { LIST_MENU_ADD_TASK,
                                                        LIST_MENU_REMOVE_TASK,
                                                        LIST_MENU_CHANGE_TITLE,
                                                        LIST_MENU_SAVE_LIST,
                                                        LIST_MENU_EXIT};

    private String title;
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

    private void showList() {
        System.out.println("-------------------------");
        System.out.println("| " + tasks.size() + " | " + getTitle());
        System.out.println("-------------------------");
        for (Task task : tasks) {
            System.out.println((tasks.indexOf(task) + 1) + ") " + task.getDescription());
        }
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
                    String description = listConsole.promptForString("Please describe the task");
                    if (!description.isBlank()) {
                        // Create a new Task object with the id and description
                        Task task = new Task(description);
                        // Add task to the list
                        tasks.add(task);
                    }
                    // Should return to the top loop from here
                }
                case LIST_MENU_REMOVE_TASK -> {
                    if (!tasks.isEmpty()){  // will only run if the list has tasks added
                        System.out.println("*** REMOVE A TASK ***");
                        boolean taskRemoved = false; // flag for successful operation
                        while (!taskRemoved) {
                            try {
                                // Prompt the user to enter a task id
                                // Remove task with id matching user input, from list
                                int choice = listConsole.promptForInteger("Which # task to delete? Enter '0' to cancel");
                                if (!(choice == -1)) {  // if the users choice returned 0 (-1), go back to the list menu
                                    tasks.remove(choice);   // remove the task
                                    taskRemoved = true;     // set the flag to true
                                } else break;   // skips the "truthy" code and goes back to the list menu
                            } catch (IndexOutOfBoundsException i) {
                                System.out.println("The task does not exist...");
                            }
                        }
                    } else {
                        System.out.println("You have no tasks..."); // displayed if the list is empty
                    }
                    // Should return to the top loop from here
                }
                case LIST_MENU_CHANGE_TITLE -> {
                    System.out.println("*** CHANGE TITLE ***");
                    // Prompt the user to enter a new title for the list
                    String newTitle = listConsole.promptForString("Please enter the new title...");
                    // use the setter to change the title of the list
                    if (!newTitle.isBlank()) { // will only change the title if user entered a new title
                        setTitle(newTitle);
                    }
                    // should return to the top loop from here
                }
                case LIST_MENU_SAVE_LIST -> {
                    System.out.println("*** SAVE LIST ***");
                    FileManager fm = new FileManager();
                    String fileName = listConsole.promptForString("Please enter a file name...");
                    fm.saveFile(tasks, title, fileName);
                }
                case LIST_MENU_EXIT -> {
                    return; // return user to main menu
                }
            }

        } // end list manager loop
    }

}
