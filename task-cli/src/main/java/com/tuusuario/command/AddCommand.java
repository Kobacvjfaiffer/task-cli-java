package com.tuusuario.command;

import com.tuusuario.model.Task;
import com.tuusuario.repository.TaskRepository;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
        name = "add",
        description = "Agrega una nueva tarea"
)
public class AddCommand implements Runnable {

    @Parameters(index = "0", description = "Título de la tarea")
    private String title;

    @Option(names = {"-p", "--priority"}, description = "Prioridad (alta, media, baja)", defaultValue = "media")
    private String priority;

    private final TaskRepository repository = new TaskRepository();

    @Override
    public void run() {
        Task task = repository.add(title, priority);
        System.out.println("Tarea creada [id=" + task.getId() + "]: " + task.getTitle() + " (prioridad: " + task.getPriority() + ")");
    }
}