package edu.practice.domain;
import java.util.List;

public interface JsonConverter {
    String toJson(List<Student> students);
    List<Student> fromJson(String students);
}
