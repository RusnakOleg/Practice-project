package edu.practice.workWithJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.practice.domain.Student;

import java.util.List;

public class GsonConverter implements JsonConverter {
    private final Gson gson;

    public GsonConverter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String toJson(List<Student> students) {
        return gson.toJson(students);
    }

    @Override
    public List<Student> fromJson(String students) {
        TypeToken<List<Student>> typeToken = new TypeToken<>(){};
        return gson.fromJson(students, typeToken);
    }
}
