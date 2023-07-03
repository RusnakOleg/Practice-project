package edu.practice.domain;
import edu.practice.workWithJson.StudentsDataSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UniversityRepository implements ActionsWithStudents {
    private final StudentsDataSource studentsDataSource;
    private final List<Student> students;

    public UniversityRepository(StudentsDataSource studentsDataSource, List<Student> students) {
        this.studentsDataSource = studentsDataSource;
        this.students = students;
    }
    public void writeFile() {
        studentsDataSource.writeStudents(students);
    }
    @Override
    public void showStudent() {
        if (!students.isEmpty()) {
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("There aren't any students");
        }
    }
    @Override
    public void addStudent(Student student) {
        students.add(student);
    }
    @Override
    public void deleteStudent(int idForRemove) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (student.getId() == idForRemove) {
                students.remove(i);
                System.out.println("Student was deleted");
                return;
            }
        }
        System.out.println("Student not found.");
    }
    @Override
    public List<Student> searchStudent(String keyword) {
        List<Student> searchedStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    student.getSurname().toLowerCase().contains(keyword.toLowerCase()) ||
                    student.getEmail().toLowerCase().contains(keyword.toLowerCase())) {
                searchedStudents.add(student);
            }
        }
        return searchedStudents;
    }
    @Override
    public void sortStudents(String sortCriteria) {
        switch (sortCriteria) {
            case "name" -> students.sort(Comparator.comparing(Student::getName));
            case "surname" -> students.sort(Comparator.comparing(Student::getSurname));
            case "age" -> students.sort(Comparator.comparing(Student::getDateOfBirth));
            case "course" -> students.sort(Comparator.comparing(student -> student.getCourse().toString()));
            default -> System.out.println("There isn't such criteria");
        }
    }
    @Override
    public Student editStudent(int idForEdit) {
        for (Student student : students) {
            if (student.getId() == idForEdit)
                return student;

        }return null;
    }
}
