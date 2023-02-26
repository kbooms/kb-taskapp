package com.kevinbooms;

public class Task {

    private String description;

    public Task(String description) {
        this.description = description;
    }

//    public Task() {
//
//    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                ", description='" + description + '\'' +
                '}';
    }
}
