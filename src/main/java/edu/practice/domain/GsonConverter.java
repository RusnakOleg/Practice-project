package edu.practice.domain;
import com.google.gson.Gson;
import java.util.List;

public class GsonConverter implements JsonConverter{
    private final Gson gson;

    public GsonConverter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String toJson(List<Student> students) {
        return null;
    }

    @Override
    public List<Student> fromJson(String students) {
        return null;
    }
}
