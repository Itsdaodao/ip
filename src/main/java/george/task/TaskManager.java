package george.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import george.exceptions.GeorgeException;
import george.utils.Storage;


public class TaskManager {
    private List<Task> tasksList;
    private Storage storage;

    public TaskManager(String dataFileName) {
        this.tasksList = new ArrayList<>();
        this.storage = new Storage(dataFileName);
    }

    public void addToDoTask(String description) throws GeorgeException {
        Task task = new ToDoTask(description);
        tasksList.add(task);
        addTask(task.getDisplayText());
    }

    public void addDeadlineTask(String description, String date) throws GeorgeException {
        Task task = new DeadlineTask(description, date);
        tasksList.add(task);
        addTask(task.getDisplayText());
    }

    public void addEventTask(String description, String startTime, String endTime) throws GeorgeException {
        Task task = new EventTask(description, startTime, endTime);
        tasksList.add(task);
        addTask(task.getDisplayText());
    }

    public void addTask(String displayText) {
        System.out.println("You get a task. I get a banana!");
        System.out.println(displayText);
        System.out.println("You now have " + tasksList.size() + " things to do!!!\n" +
                "Remember to do them NOW!!!\n");
        try {
            storage.saveTasks(tasksList);
        } catch (IOException e) {
            System.out.println("Error while saving tasks: " + e.getMessage());
        }
    }

    public void deleteTask(int taskNumber) {
        Task removedTask = tasksList.remove(taskNumber - 1);
        System.out.println("george.George will turn this task into a banana:");
        System.out.println(removedTask.getDisplayText());
        System.out.println("You now have " + tasksList.size() + " tasks in the list.");
    }

    public void listTasks() {
        if (tasksList.isEmpty()) {
            System.out.println("Wow you have no tasks! Here is a banana!");
            return;
        }

        System.out.println("OOO OOO AAA AAA here is all your tasks");
        for (int i = 0; i < tasksList.size(); i++) {
            Task task = tasksList.get(i);
            System.out.println((i + 1) + "." + task.getDisplayText());
        }
        System.out.println("EEE EEE AAA AAA remember to do them all");
    }

    public void markTaskAsDone(int taskNumber) {
        Task task = tasksList.get(taskNumber - 1);
        task.markAsDone();
        System.out.println("Good job! Here is a banana for you!");
        System.out.println("[X] " + task.getDescription());
    }

    public void markTaskAsNotDone(int taskNumber) {
        Task task = tasksList.get(taskNumber - 1);
        task.markAsNotDone();
        System.out.println("Come on! You can do it!");
        System.out.println("[ ] " + task.getDescription());
    }

    private void save(List<Task> tasksList) throws IOException {
        storage.saveTasks(tasksList);
    }

    /**
     * Finds tasks containing the specified keyword in their description.
     *
     * @param keyword The keyword to search for.
     * @return A list of matching tasks.
     */
    public List<Task> findTasks(String keyword) {
        List<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasksList) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }

    public void load() throws IOException {
        tasksList = storage.loadTasks();
    }
}
