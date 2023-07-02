package edu.practice.domain;
import java.util.List;

public class StudentsDataSource {
    private final JsonConverter jsonConverter;

    public StudentsDataSource(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    public List<Student> readBooks() {
        return jsonConverter.fromJson("");
    }

    public void writeStudents(List<Student> books) {
        String jsonStudents = jsonConverter.toJson(books);
    }
}
