package com.tuusuario.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tuusuario.model.Task;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private static final String FILE_PATH = "tasks.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<Task> findAll() {
        Path path = Path.of(FILE_PATH);
        if (!Files.exists(path)) {
            return new ArrayList<>();
        }
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Task>>() {}.getType();
            List<Task> tasks = gson.fromJson(reader, listType);
            return tasks != null ? tasks : new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer " + FILE_PATH, e);
        }
    }

    public void saveAll(List<Task> tasks) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir " + FILE_PATH, e);
        }
    }

    public Task add(String title, String priority) {
        List<Task> tasks = findAll();
        int nextId = tasks.stream().mapToInt(Task::getId).max().orElse(0) + 1;
        Task task = new Task(nextId, title, priority);
        tasks.add(task);
        saveAll(tasks);
        return task;
    }
}
