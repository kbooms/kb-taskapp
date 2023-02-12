package com.kevinbooms;

import com.kevinbooms.Task;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private String title;
    private List<Task> tasks = new ArrayList<>();

    public ToDoList(){}
    // not sure I need a parameterized constructor yet.
    // If I'm creating a new ToDoList object, it should be allowed to be blank
//    public ToDoList(String title, List<Task> tasks) {
//        this.title = title;
//        this.tasks = tasks;
//    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
