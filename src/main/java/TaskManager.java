import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> taskLists = new ArrayList<>();

    public void addToDo(String description) throws GeorgeException {
        Task task = new ToDoTask(description);
        taskLists.add(task);
        addTask(task.getDisplayText());
    }

    public void addDeadlineTask(String description, String date) throws GeorgeException {
        Task task = new DeadlineTask(description, date);
        taskLists.add(task);
        addTask(task.getDisplayText());
    }

    public void addEventTask(String description, String startTime, String endTime) throws GeorgeException {
        Task task = new EventTask(description, startTime, endTime);
        taskLists.add(task);
        addTask(task.getDisplayText());
    }

    public void addTask(String displayText) {
        System.out.println("You get a task. I get a banana!");
        System.out.println(displayText);
        System.out.println("You now have " + taskLists.size() + " things to do!!!\n" +
                "Remember to do them NOW!!!\n");
    }

    public void deleteTask(int taskNumber) {
        Task removedTask = taskLists.remove(taskNumber - 1);
        System.out.println("George will turn this task into a banana:");
        System.out.println(removedTask.getDisplayText());
        System.out.println("You now have " + taskLists.size() + " tasks in the list.");
    }

    public void listTasks() {
        if (taskLists.isEmpty()) {
            System.out.println("Wow you have no tasks! Here is a banana!");
            return;
        }

        System.out.println("OOO OOO AAA AAA here is all your tasks");
        for (int i = 0; i < taskLists.size(); i++) {
            Task task = taskLists.get(i);
            System.out.println((i + 1) + "." + task.getDisplayText());
        }
        System.out.println("EEE EEE AAA AAA remember to do them all");
    }

    public void markTaskAsDone(int taskNumber) {
        Task task = taskLists.get(taskNumber - 1);
        task.markAsDone();
        System.out.println("Good job! Here is a banana for you!");
        System.out.println("[X] " + task.getDescription());
    }

    public void markTaskAsNotDone(int taskNumber) {
        Task task = taskLists.get(taskNumber - 1);
        task.markAsNotDone();
        System.out.println("Come on! You can do it!");
        System.out.println("[ ] " + task.getDescription());
    }

    private void saveTasks() {

    }
}
