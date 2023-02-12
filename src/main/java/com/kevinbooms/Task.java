package com.kevinbooms;

import java.util.Date;

public class Task {

    private int id;
    private String description;
//    private Date dueDate;
//    private String[] status = {"PENDING", "IN_PROGRESS", "COMPLETED"};
//    maybe work on dueDate and status later as a bug tracker add-on
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Task() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
