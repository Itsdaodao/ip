import jdk.jfr.Event;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private final String filePath;
    private final Path dataDirectory;
    private final static String FILE_DIRECTORY = "./data";

    public Storage(String filePath) {
        this.filePath = filePath;
        this.dataDirectory = Paths.get(filePath).getParent();
    }

    public List<Task> loadTasks() throws IOException {
        List<Task> tasks = new ArrayList<>();
        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            System.out.println("File does not exist yet!");
            System.out.println("Creating new file");
            ensureDirectoryExists();
            return tasks;
        }

        try {
            List<String> lines = Files.readAllLines(path);
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

    private Task parseTaskFromLine(String line) throws GeorgeException {
        String[] parts = line.split(" \\| ");
        String type = parts[0].trim();
        boolean isCompleted = parts[1].trim().equals("1");
        switch (type) {
        case "D":
            return new DeadlineTask(parts[2], parts[3]);
        case "E":
            return new EventTask(parts[2], parts[3], parts[4]);
        default:
            return new ToDoTask(parts[2]);
        }
    }

    private void ensureDirectoryExists() throws IOException {
        if (dataDirectory != null && !Files.exists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
            System.out.println("Created directory: " + dataDirectory);
        }
    }

    public boolean fileExists() {
        return Files.exists(Paths.get(filePath));
    }
}