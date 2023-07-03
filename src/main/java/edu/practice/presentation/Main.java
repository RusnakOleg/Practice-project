package edu.practice.presentation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.practice.domain.*;
import edu.practice.workWithJson.GsonConverter;
import edu.practice.workWithJson.JsonConverter;
import edu.practice.workWithJson.LocalDateAdapter;
import edu.practice.workWithJson.StudentsDataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
        JsonConverter gsonConverter = new GsonConverter(gson);
        StudentsDataSource studentsDataSource = new StudentsDataSource(gsonConverter);
        List<Student> students = studentsDataSource.readStudents();
        if (students == null) students = new ArrayList<>();
        UniversityRepository universityRepository = new UniversityRepository(studentsDataSource, students);

        Scanner command = new Scanner(System.in);
        System.out.println("""
                    MAIN COMMANDS:*****
                    "help" - show menu of commands
                    "add" - add a new student
                    "delete" - delete a student
                    "search" - search one or more students
                    "sort" - sort the list of student by criteria
                    "edit" - edit information about a student
                    "exit" - saves all changes and exists program""" + "\n");

        while (true) {
            System.out.println("\n" + "Enter command: ");
            switch (command.nextLine()) {
                case "help" -> System.out.println("""
                        MAIN COMMANDS:*****
                        "help" - show menu of commands
                        "add" - add a new student
                        "delete" - delete a student
                        "search" - search one or more students
                        "sort" - sort the list of student by criteria
                        "edit" - edit information about a student
                        "exit" - saves all changes and exists program""" + "\n");
                case "add" -> {
                    int id = RandomIdGenerator.generateRandomId();
                    System.out.println("Enter NAME:");
                    String name = command.nextLine();

                    System.out.println("Enter SURNAME:");
                    String surname = command.nextLine();

                    System.out.println("Enter EMAIL:");
                    String email = command.nextLine();

                    System.out.println("Enter PHONE NUMBER:");
                    System.out.print("+38 ");
                    String phoneNumber = command.nextLine();
                    System.out.println("Enter COURSE: (first, second, ...)");
                    Course course = null;
                    String courseInput = command.nextLine().toUpperCase();
                    if (!courseInput.isEmpty()) {
                            course = Course.valueOf(courseInput);
                        }
                    System.out.println("Enter DATE OF BIRTH:");
                    System.out.println("Enter YEAR (1956)");
                    int year = command.nextInt();
                    System.out.println("Enter MONTH (08)");
                    int month = command.nextInt();
                    System.out.println("Enter DAY (24)");
                    int day = command.nextInt();
                    LocalDate dateOfBirth = null;
                    if (year > 1900 && year < 2023  && month > 0 && month < 13 && day > 0 && day < 32) {
                        dateOfBirth = LocalDate.of(year,month,day);
                    }

                    Student student = new Student(id, name, surname, course, dateOfBirth, email, phoneNumber);
                    universityRepository.addStudent(student);
                    System.out.println("\n" + ANSI_GREEN + "New student was successfully added" + ANSI_RESET);
                }
                case "delete" -> {
                    System.out.println("Enter the id of student which you would like to delete:");
                    int idForRemove = command.nextInt();
                    universityRepository.deleteStudent(idForRemove);
                    System.out.println("\n" + ANSI_GREEN + "Student was successfully deleted" + ANSI_RESET);
                }
                case "search" -> {
                    System.out.println("Enter the keyword to search:(name, surname, mail) ");
                    String keyword = command.nextLine();
                    List<Student> searchedStudents = universityRepository.searchStudent(keyword);
                    if (searchedStudents.isEmpty()) {
                        System.out.println(ANSI_RED + "No students found matching the search criteria." + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_GREEN + "Founded students: " + ANSI_RESET);
                        for (Student foundedStudents : searchedStudents) {
                            System.out.println(foundedStudents.toString());
                        }
                    }
                }
                case "sort" -> {
                    System.out.println("""
                            'name' - sort by name
                            'surname' - sort by surname
                            'age' - sort by date of birth
                            'course' - sort by courses of students
                            By which criteria would you like to sort the students?""");
                    universityRepository.sortStudents(command.nextLine());
                    System.out.println("\n" + ANSI_GREEN + "List of students was successful sorted" + ANSI_RESET);
                }
                case "edit" -> {
                    System.out.println("Enter the id of student that you would like to edit");
                    Student editStudent = universityRepository.editStudent(command.nextInt());
                    System.out.println("""
                            Which field would you like to edit?
                            'name' - to edit name
                            'surname' - to edit surname
                            'email' - to edit email
                            'course' - to edit course
                            'dbo' - to edit date of birth
                            'phone' - to edit phone number""");
                    Scanner sc = new Scanner(System.in);
                    switch (sc.nextLine()){
                        case "name" ->{
                            System.out.println("Enter NAME");
                            editStudent.setName(sc.nextLine());
                        }
                        case "surname" -> {
                            System.out.println("Enter SURNAME:");
                            editStudent.setSurname(sc.nextLine());
                        }
                        case "email" -> {
                            System.out.println("Enter EMAIL:");
                            editStudent.setEmail(sc.nextLine());
                        }
                        case "course" -> {
                            System.out.println("Enter COURSE:");
                            Course course = null;
                            String courseInput = command.nextLine().toUpperCase();
                            if (!courseInput.isEmpty()) {
                                course = Course.valueOf(courseInput);
                            }
                            editStudent.setCourse(course);
                        }
                        case "dbo" -> {
                            System.out.println("Enter DATE OF BIRTH:");
                            System.out.println("Enter YEAR (1956)");
                            int year = command.nextInt();
                            System.out.println("Enter MONTH (08)");
                            int month = command.nextInt();
                            System.out.println("Enter DAY (24)");
                            int day = command.nextInt();
                            LocalDate dateOfBirth = null;
                            if (year > 1900 && year < 2023  && month > 0 && month < 13 && day > 0 && day < 32) {
                                dateOfBirth = LocalDate.of(year,month,day);
                            }
                            editStudent.setDateOfBirth(dateOfBirth);
                        }
                        case "phone" -> {
                            System.out.println("Enter PHONE NUMBER:");
                            editStudent.setPhoneNumber(sc.nextLine());
                        }
                    }System.out.println("\n" + ANSI_GREEN + "Data of student was changed successfully " + ANSI_RESET);
                }
                case "show" -> {
                    System.out.println("All students:");
                    universityRepository.showStudent();
                }
                case "exit" -> {
                    universityRepository.writeFile();
                    System.out.println("\n" + ANSI_GREEN + "Data saved successfully" + ANSI_RESET);
                    return;
                }
                default -> System.out.println("Command not recognized!");
            }
        }
    }
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
}