package edu.practice.domain;
import java.time.LocalDate;

public record Student(String name, String surname, Course course, LocalDate dateOfBirth, String email, int phoneNumber) {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name.isEmpty() ? "-----" : name);
        sb.append("Surname: ").append(surname.isEmpty() ? "-----" : surname);
        sb.append("Course: ").append(course == null ? "-----" : course.toString());
        sb.append("Date of Birth: ").append(dateOfBirth == null ? "-----" : dateOfBirth.toString());
        sb.append("Email: ").append(email.isEmpty() ? "-----" : email);
        sb.append("Phone Number: ").append(phoneNumber == 0 ? "-----" : phoneNumber);
        return sb.toString();
    }
}

