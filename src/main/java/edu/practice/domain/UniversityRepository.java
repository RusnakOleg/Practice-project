package edu.practice.domain;
import java.util.ArrayList;
import java.util.List;

public class UniversityRepository implements ActionsWithStudents{
    List<Student> studentList = new ArrayList<>();

    private final StudentsDataSource studentsDataSource;
    private final List<Student> students;

    public UniversityRepository(StudentsDataSource studentsDataSource, List<Student> students) {
        this.studentsDataSource = studentsDataSource;
        this.students = students;
    }

    @Override
    public void addStudent() {

    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public void searchStudent() {

    }

    @Override
    public void sortStudents() {

    }

    @Override
    public void editStudent() {

    }
}
