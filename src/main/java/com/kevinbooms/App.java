package com.kevinbooms;

import com.kevinbooms.Task;

public class App {

    private CommandLine console;

    public App(CommandLine console) {
        this.console = console;
    }

    public void run() {
        console.displayBanner();
    }
    public static void main(String[] args) {


        System.out.println("Let's build Taskmin and finally finish it!\n");

        CommandLine cl = new CommandLine();
        App app = new App(cl);
        app.run();
        System.out.println(cl.printGreeting());


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
