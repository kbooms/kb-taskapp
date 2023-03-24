package com.kevinbooms;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    /*
    * We need a method to save a file
    *   Save method should use PrintWriter.
    *   Performance and size of text input is not an issue
    *
    * We need a method to load a file
    *   Load method should use FileReader
    *   Performance and size of text output is not an issue
    *
     */
    public void saveFile(List<Task> tasks, String title, String filePath) {
        filePath += ".txt"; // append the file as a text file
        try (PrintWriter todoList = new PrintWriter(filePath)) {
            todoList.println("** " + title);
            for (Task task : tasks) {
               todoList.println(task.getDescription());
            }
            System.out.println("List saved as: " + filePath);
        } catch (FileNotFoundException e) { // I should rewrite this as a FileAlreadyExists, and ask the user if they want to overwrite
            System.err.println("File not found..."); // if they don't want to overwrite, they'll have to go back to entering a file name
        }
    }

    public ToDoList openFile(String filePath) {
        File listFile = new File(filePath + ".txt");
        String title = new String();
        List<Task> tasks = new ArrayList<>();

        // load the file and set the title, close it
        try (Scanner loadFile = new Scanner(listFile)) {
            String currentLine = loadFile.nextLine();
            title = currentLine.substring(3);
        } catch (FileNotFoundException f) {
            System.err.println("File not found...");
        }

        // load the file and populate the list
        try (Scanner loadFile = new Scanner(listFile)) {
            // read and discard the first line, since this is the title
            if (loadFile.hasNextLine()) {
                loadFile.nextLine();
            }
            while (loadFile.hasNextLine()) {
                Task currentLine = new Task(loadFile.nextLine());
                tasks.add(currentLine);
                }
        } catch (FileNotFoundException f) {
            System.err.println("File not found...");
        }
        return new ToDoList(title, tasks);
    }
}
