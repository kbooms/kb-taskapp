package com.kevinbooms;

import com.kevinbooms.Task;

public class App {

    public static void main(String[] args) {

        Task taskOne = new Task(1, "The first task");
//        Task taskTwo = new Task(2, "The next right thing to do.");

        System.out.println("Let's build Taskmin and finally finish it!\n");

        System.out.println(taskOne.getId() + ": " + taskOne.getDescription());
        System.out.println(taskOne);
    }
}
