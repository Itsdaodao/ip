import java.util.Scanner;

public class George {
    private static final String BANANA = "\uD83C\uDF4C";
    private static final String MONKEY = "🐒";
    private static final String newLine = "\n"
            + MONKEY + BANANA.repeat(20) + MONKEY
            + "\n";

    public static void main(String[] args) {
        greet();
        echo();
    }

    private static void greet() {
        String greeting = "Ooo eee ooo aaa aaa \nI am George the Monkey"
                + MONKEY
                + "\nGeorge can help you with?";
        System.out.println(greeting);
        System.out.println(newLine);
    }

    private static void echo() {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                String exit = "I love bananas " + BANANA.repeat(5)
                        + "\nplease bring bananas next time";
                System.out.println("\n" + exit);
                break;
            } else if (input.equals("list")) {
                manager.listTasks();
            } else if (input.startsWith("mark ")) {
                int taskNumber = Integer.parseInt(input.substring(5));
                manager.markTaskAsDone(taskNumber);
            } else if (input.startsWith("unmark ")) {
                int taskNumber = Integer.parseInt(input.substring(7));
                manager.markTaskAsNotDone(taskNumber);
            } else {
                System.out.println(newLine);
                manager.addTask(input);
                System.out.println(newLine);
            }
        }
        scanner.close();
    }
}
