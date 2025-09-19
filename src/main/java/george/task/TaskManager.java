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
     * @return The display text of adding To Do Task
     * @throws GeorgeException If the task creation fails
     */
    public String addToDoTask(String description) throws GeorgeException {
        Task task = new ToDoTask(description);
        tasksList.add(task);
        return addTask(task.getDisplayText());
    }

    /**
     * Adds a new deadline task to the task list.
     *
     * @param description The description of the deadline task
     * @param date The deadline date string
     * @return The display text of adding Deadline Task.
     * @throws GeorgeException If the task creation fails
     */
    public String addDeadlineTask(String description, String date) throws GeorgeException {
        Task task = new DeadlineTask(description, date);
        tasksList.add(task);
        return addTask(task.getDisplayText());
    }

    /**
     * Adds a new event task to the task list.
     *
     * @param description The description of the event task
     * @param startTime The start time string of the event
     * @param endTime The end time string of the event
     * @return The display text of adding Event Task.
     * @throws GeorgeException If the task creation fails
     */
    public String addEventTask(String description, String startTime, String endTime) throws GeorgeException {
        Task task = new EventTask(description, startTime, endTime);
        tasksList.add(task);
        return addTask(task.getDisplayText());
    }

    /**
     * Handles the common operations after adding any task.
     *
     * @param displayText The formatted display text of the added task
     * @return The display message for adding a task.
     */
    public String addTask(String displayText) {
        try {
            storage.saveTasks(tasksList);
        } catch (IOException e) {
            System.out.println("Error while saving tasks: " + e.getMessage());
        }
        String message = "You get a task. I get a banana!\n"
                + displayText + "\nYou now have "
                + tasksList.size() + " things to do!!!\n"
                + "Remember to do them NOW!!!\n";
        return message;
    }

    /**
     * Deletes a task from the task list by its number.
     *
     * @param taskNumber The number of the task to delete (1-based index)
     * @return The display message of deleting a task.
     */
    public String deleteTask(int taskNumber) {
        Task removedTask = tasksList.remove(taskNumber - 1);
        String message = "george.George will turn this task into a banana:\n"
                + removedTask.getDisplayText() + "\nYou now have "
                + tasksList.size() + " tasks in the list.";
        return message;
    }

    /**
     * Lists all tasks in the task list with their status and descriptions.
     *
     * @return A formatted string containing all tasks or a message if the list is empty
     */
    public String listTasks() {
        if (tasksList.isEmpty()) {
            return "Wow you have no tasks! Here is a banana!";
        }

        StringBuilder result = new StringBuilder();
        result.append("OOO OOO AAA AAA here is all your tasks\n");
        for (int i = 0; i < tasksList.size(); i++) {
            Task task = tasksList.get(i);
            result.append((i + 1) + "." + task.getDisplayText() + "\n");
        }
        result.append("EEE EEE AAA AAA remember to do them all");

        return result.toString();
    }

    /**
     * Marks a task as done by its number.
     *
     * @param taskNumber The number of the task to mark as done (1-based index)
     * @return A success message with the marked task details
     */
    public String markTaskAsDone(int taskNumber) {
        Task task = tasksList.get(taskNumber - 1);
        task.markAsDone();

        StringBuilder result = new StringBuilder();
        result.append("Good job! Here is a banana for you!\n");
        result.append("[X] " + task.getDescription());

        return result.toString();
    }

    /**
     * Marks a task as not done by its number.
     *
     * @param taskNumber The number of the task to mark as not done (1-based index)
     * @return An encouragement message with the unmarked task details
     */
    public String markTaskAsNotDone(int taskNumber) {
        Task task = tasksList.get(taskNumber - 1);
        task.markAsNotDone();

        StringBuilder result = new StringBuilder();
        result.append("Come on! You can do it!\n");
        result.append("[ ] " + task.getDescription());

        return result.toString();
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
