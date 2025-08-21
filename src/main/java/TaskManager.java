import java.util.ArrayList;

public class TaskManager {
    private static final String BANANA = "\uD83C\uDF4C";
    private static final String MONKEY = "🐒";
    private static final String newLine = "\n"
            + MONKEY + BANANA.repeat(20) + MONKEY
            + "\n";

    private ArrayList<Task> taskLists = new ArrayList<>();

    public void addTask(String description) {
        taskLists.add(new Task(description));
        System.out.println("ooo ooo aaa aaa");
        System.out.println("Added: " + description);
        System.out.println("eee eee aaa aaa");
    }

    public void listTasks() {
        if (taskLists.isEmpty()) {
            System.out.println("Wow you have no tasks! Here is a banana!" + BANANA);
            return;
        }

        System.out.println("OOO OOO AAA AAA here is all your tasks");
        for (int i = 0; i < taskLists.size(); i++) {
            Task task = taskLists.get(i);
            String done = task.isDone() ? "[X]" : "[ ]";
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
