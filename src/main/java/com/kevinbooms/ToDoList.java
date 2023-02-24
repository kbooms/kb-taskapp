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

    }
    public void showList() {
        System.out.println("-------------------------");
        System.out.println("| EXAMPLE LIST           ");
        System.out.println("-------------------------");
        System.out.println("1) Task 1");
        System.out.println("2) Task 2");

    }

    public void addTask(Task task) {
        tasks.add(task);
    }
    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
