package com.tuusuario;

import com.tuusuario.command.AddCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
        name = "task",
        description = "Gestor de tareas por línea de comandos",
        mixinStandardHelpOptions = true,
        version = "task-cli 1.0",
        subcommands = { AddCommand.class }
)
public class Main implements Runnable {

    @Override
    public void run() {
        System.out.println("Usa --help para ver los comandos disponibles.");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}