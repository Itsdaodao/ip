import jdk.jfr.Event;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private final String fileName;
    private final Path dataPath;
    private final static String FILE_DIRECTORY = "./data";

    public Storage(String fileName) {
        this.fileName = fileName;
        this.dataPath = Paths.get(FILE_DIRECTORY + fileName);
    }

    public List<Task> loadTasks() throws IOException {
        List<Task> tasks = new ArrayList<>();

        if (!Files.exists(dataPath)) {
            System.out.println("File does not exist yet!");
            System.out.println("Creating new file");
            ensureDirectoryExists();
            return tasks;
        }

        try {
            List<String> lines = Files.readAllLines(dataPath);
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;

                try {
                    Task task = parseTaskFromLine(line);
                    tasks.add(task);
                } catch (GeorgeException e) {
                    System.out.println("Failed to parse this line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return tasks;
    }

    public void saveTasks(List<Task> tasks) throws IOException {
        ensureDirectoryExists();

        try {
            List<String> lines = new ArrayList<>();
            for (Task task : tasks) {
                lines.add(task.toString());
            }

            Files.write(Paths.get(FILE_DIRECTORY + fileName), lines);
            System.out.println("Saved " + tasks.size() + " tasks to " + dataPath);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
            throw e;
        }

    }

    private Task parseTaskFromLine(String line) throws GeorgeException {
        String[] parts = line.split(" \\| ");
        String type = parts[0].trim();
        boolean isCompleted = parts[1].trim().equals("1");
        switch (type) {
        case "D":
            return new DeadlineTask(parts[2], parts[3], isCompleted);
        case "E":
            return new EventTask(parts[2], parts[3], parts[4], isCompleted);
        default:
            return new ToDoTask(parts[2], isCompleted);
        }
    }

    private void ensureDirectoryExists() throws IOException {
        if (dataPath != null && !Files.exists(dataPath)) {
            Files.createDirectories(dataPath);
            System.out.println("Created file at: " + dataPath);
        }
    }
}