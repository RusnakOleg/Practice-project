package edu.practice.workWithJson;
import edu.practice.domain.Student;

import java.util.List;

public interface JsonConverter {
    String toJson(List<Student> students);
    List<Student> fromJson(String students);
}
