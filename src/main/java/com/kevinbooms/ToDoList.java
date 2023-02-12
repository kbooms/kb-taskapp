package com.kevinbooms;

import com.kevinbooms.Task;

import java.util.List;

public class ToDoList {

    private String title;
    private List<Task> tasks;

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

    public void addTask(Task task) {
        tasks.add(task);
    }
    public void remoteTask(Task task) {
        tasks.remove(task);
    }
}
