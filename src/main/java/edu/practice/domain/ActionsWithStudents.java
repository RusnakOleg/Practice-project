package edu.practice.domain;
import java.util.List;

public interface ActionsWithStudents {
    void addStudent(Student student);
    void deleteStudent(int idForRemove);
    List<Student> searchStudent(String keyword);
    void sortStudents(String sortCriteria);
    Student editStudent(int idForEdit);
    void showStudent();
}
