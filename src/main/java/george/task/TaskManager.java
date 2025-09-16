package george.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import george.exceptions.GeorgeException;
import george.utils.Storage;

/**
 * Manages the collection of tasks including adding, deleting, marking, and listing tasks.
 * Handles persistence of tasks through the Storage class.
 */
public class TaskManager {
    private List<Task> tasksList;
    private Storage storage;

    /**
     * Constructs a TaskManager with the specified data file name for storage.
     *
     * @param dataFileName The name of the file to store tasks data
     */
    public TaskManager(String dataFileName) {
        this.tasksList = new ArrayList<>();
        this.storage = new Storage(dataFileName);
    }

    /**
     * Adds a new todo task to the task list.
     *
     * @param description The description of the todo task
     * @throws GeorgeException If the task creation fails
     */
    public void addToDoTask(String description) throws GeorgeException {
        Task task = new ToDoTask(description);
        tasksList.add(task);
        addTask(task.getDisplayText());
    }

    /**
     * Adds a new deadline task to the task list.
     *
     * @param description The description of the deadline task
     * @param date The deadline date string
     * @throws GeorgeException If the task creation fails
     */
    public void addDeadlineTask(String description, String date) throws GeorgeException {
        Task task = new DeadlineTask(description, date);
        tasksList.add(task);
        addTask(task.getDisplayText());
    }

    /**
     * Adds a new event task to the task list.
     *
     * @param description The description of the event task
     * @param startTime The start time string of the event
     * @param endTime The end time string of the event
     * @throws GeorgeException If the task creation fails
     */
    public void addEventTask(String description, String startTime, String endTime) throws GeorgeException {
        Task task = new EventTask(description, startTime, endTime);
        tasksList.add(task);
        addTask(task.getDisplayText());
    }

    /**
     * Handles the common operations after adding any task.
     *
     * @param displayText The formatted display text of the added task
     */
    public void addTask(String displayText) {
        System.out.println("You get a task. I get a banana!");
        System.out.println(displayText);
        System.out.println("You now have " + tasksList.size() + " things to do!!!\n"
                + "Remember to do them NOW!!!\n");
        try {
            storage.saveTasks(tasksList);
        } catch (IOException e) {
            System.out.println("Error while saving tasks: " + e.getMessage());
        }
    }

    /**
     * Deletes a task from the task list by its number.
     *
     * @param taskNumber The number of the task to delete (1-based index)
     */
    public void deleteTask(int taskNumber) {
        Task removedTask = tasksList.remove(taskNumber - 1);
        System.out.println("george.George will turn this task into a banana:");
        System.out.println(removedTask.getDisplayText());
        System.out.println("You now have " + tasksList.size() + " tasks in the list.");
    }

    /**
     * Lists all tasks in the task list with their status and descriptions.
     */
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

    /**
     * Marks a task as done by its number.
     *
     * @param taskNumber The number of the task to mark as done (1-based index)
     */
    public void markTaskAsDone(int taskNumber) {
        Task task = tasksList.get(taskNumber - 1);
        task.markAsDone();
        System.out.println("Good job! Here is a banana for you!");
        System.out.println("[X] " + task.getDescription());
    }

    /**
     * Marks a task as not done by its number.
     *
     * @param taskNumber The number of the task to mark as not done (1-based index)
     */
    public void markTaskAsNotDone(int taskNumber) {
        Task task = tasksList.get(taskNumber - 1);
        task.markAsNotDone();
        System.out.println("Come on! You can do it!");
        System.out.println("[ ] " + task.getDescription());
    }

    /**
     * Saves the current task list to storage.
     *
     * @param tasksList The list of tasks to save
     * @throws IOException If an I/O error occurs during saving
     */
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

    /**
     * Loads tasks from storage into the task list.
     *
     * @throws IOException If an I/O error occurs during loading
     */
    public void load() throws IOException {
        tasksList = storage.loadTasks();
    }
}
