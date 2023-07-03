package edu.practice.domain;

import java.time.LocalDate;

public class Student {
    int id;
    String name;
    String surname;
    Course course;
    LocalDate dateOfBirth;
    String email;
    String phoneNumber;

    public Student(int id, String name, String surname, Course course, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("--------------------------------");
            sb.append("\n" + "ID: ").append(id);
            sb.append("\n" + "Name: ").append(name.isEmpty() ? "-----" : name);
            sb.append("\n" + "Surname: ").append(surname.isEmpty() ? "-----" : surname);
            sb.append("\n" + "Course: ").append(course == null ? "-----" : course.toString());
            sb.append("\n" + "Date of Birth: ").append(dateOfBirth == null ? "-----" : dateOfBirth.toString());
            sb.append("\n" + "Email: ").append(email.isEmpty() ? "-----" : email);
            if(phoneNumber.length() == 10) {
                if(     phoneNumber.startsWith("039") || phoneNumber.startsWith("067") ||
                        phoneNumber.startsWith("068") || phoneNumber.startsWith("096") ||
                        phoneNumber.startsWith("097") ||phoneNumber.startsWith("098")){
                    sb.append("\n" + "Phone Number: ").append(phoneNumber).append(" (Kyivstar)");
                } else if (phoneNumber.startsWith("050") || phoneNumber.startsWith("066") ||
                        phoneNumber.startsWith("095") || phoneNumber.startsWith("099")) {
                    sb.append("\n" + "Phone Number: ").append(phoneNumber).append(" (Vodafone)");
                }else if (phoneNumber.startsWith("063") || phoneNumber.startsWith("073") ||
                        phoneNumber.startsWith("093")){
                    sb.append("\n" + "Phone Number: ").append(phoneNumber).append(" (Lifecell)");
                }
                else if (phoneNumber.startsWith("091")){
                    sb.append("\n" + "Phone Number: ").append(phoneNumber).append(" (Utel)");
                }
                else if (phoneNumber.isEmpty()) {
                sb.append("\n" + "Phone Number: -----");
            } else
                sb.append("\n" + "Phone Number: INCORRECT NUMBER ");
        sb.append("\n" + "--------------------------------");
        System.out.println("\t");

        }return sb.toString();
    }
}
