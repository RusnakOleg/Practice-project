package edu.practice.workWithJson;
import edu.practice.domain.Student;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StudentsDataSource {
    private final JsonConverter jsonConverter;

    public StudentsDataSource(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }
    public List<Student> readStudents() {
        try {
            Path path = Paths.get("src/main/java/edu/practice/workWithJson/student.json");
            String s = Files.readString(path);
            return jsonConverter.fromJson(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeStudents(List<Student> students) {
        try {
            Path path = Paths.get("src/main/java/edu/practice/workWithJson/student.json");
            String jsonStudent = jsonConverter.toJson(students);
            Files.writeString(path, jsonStudent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
