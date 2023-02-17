package com.kevinbooms;

import com.kevinbooms.Task;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private String title;
    // need to create a sequence to generate id's
    private int idGenerator;
    private List<Task> tasks = new ArrayList<>();

    public ToDoList(){}

    public ToDoList(String title) {
        this.title = title;
//        this.tasks = tasks;
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

    public void addTask(Task task) {
        tasks.add(task);
    }
    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
