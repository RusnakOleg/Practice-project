package edu.practice.presentation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.practice.domain.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        JsonConverter gsonConverter = new GsonConverter(gson);
        StudentsDataSource studentsDataSource = new StudentsDataSource(gsonConverter);
        List<Student> students = studentsDataSource.readBooks();
        UniversityRepository libraryRepository = new UniversityRepository(studentsDataSource, students);

        Scanner command = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    MAIN COMMANDS:*****
                    "help" - show menu of commands
                    "add" - add a new student
                    "delete" - delete a student
                    "search" - search one or more students
                    "sort" - sort the list of student by criteria
                    "edit" - edit information about a student
                    "exit" - saves all changes and exists program""" + "\n");

            System.out.println("Enter command: ");
            switch (command.nextLine()) {
                case "help":
                System.out.println("Application was closed");
                case "add":
                    System.out.println("Application was closed");
                case "delete":
                    System.out.println("Application was closed");
                case "search":
                    System.out.println("Application was closed");
                case "sort":
                    System.out.println("Application was closed");
                case "edit":
                    System.out.println("Application was closed");
                case "exit":
                    System.out.println("Application was closed");
                    return;
                default:
                    System.out.println("Command not recognized!");
            }
        }
    }
}