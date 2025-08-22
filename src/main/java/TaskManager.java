import java.util.ArrayList;

public class TaskManager {
    private static final String BANANA = "\uD83C\uDF4C";
    private static final String MONKEY = "🐒";
    private static final String newLine = "\n"
            + MONKEY + BANANA.repeat(20) + MONKEY
            + "\n";

    private ArrayList<Task> taskLists = new ArrayList<>();

    public void addToDo(String description) {
        Task task = new ToDoTask(description);
        taskLists.add(task);
        addTask(task.getDisplayText());
    }

    public void addDeadlineTask(String description, String date) {
        Task task = new DeadlineTask(description, date);
        taskLists.add(task);
        addTask(task.getDisplayText());
    }

    public void addEventTask(String description, String startTime, String endTime) {
        Task task = new EventTask(description, startTime, endTime);
        taskLists.add(task);
        addTask(task.getDisplayText());
    }

    public void addTask(String displayText) {
        System.out.println("You get a task. I get a banana" + BANANA);
        System.out.println(displayText);
        System.out.println("You now have " + taskLists.size() + " things to do!!!\n" +
                "Remember to do them NOW!!!");
    }

    public void listTasks() {
        if (taskLists.isEmpty()) {
            System.out.println("Wow you have no tasks! Here is a banana!" + BANANA);
            return;
        }

        System.out.println("OOO OOO AAA AAA here is all your tasks");
        for (int i = 0; i < taskLists.size(); i++) {
            Task task = taskLists.get(i);
            String done = task.isDone() ? "[X] " : "[ ] ";
            System.out.println((i + 1) + "." + done + task.getDescription());
        }
        System.out.println("EEE EEE AAA AAA remember to do them all");
    }

    public void markTaskAsDone(int taskNumber) {
        Task task = taskLists.get(taskNumber - 1);
        task.markAsDone();
        System.out.println("Good job! Here is a banana for you! " + BANANA);
        System.out.println("[X] " + task.getDescription());
    }

    public void markTaskAsNotDone(int taskNumber) {
        Task task = taskLists.get(taskNumber - 1);
        task.markAsNotDone();
        System.out.println("Come on! You can do it! " + MONKEY);
        System.out.println("[ ] " + task.getDescription());
    }
}
