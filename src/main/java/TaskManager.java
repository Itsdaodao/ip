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
        System.out.println("OOO OOO AAA AAA here is all your tasks");
        for (int i = 0; i < taskLists.size(); i++) {
            System.out.println((i + 1) + ". " + taskLists.get(i));
        }
        System.out.println("EEE EEE AAA AAA remember to do them all");
    }
}
