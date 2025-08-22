import java.util.Scanner;

public class George {
    private static final String newLine = """
            
            GEORGE the monkey LOVES to eat bananas!\
            
            """;

    public static void main(String[] args)  {
        greet();
        echo();
    }

    private static void greet() {
        String greeting = """
                Ooo eee ooo aaa aaa\s
                I am George the Monkey\
                
                George can help you with?""";
        System.out.println(greeting);
        System.out.println(newLine);
    }

    private static void echo() {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            try {
                if (input.equals("bye")) {
                    String exit = "I love bananas " +
                            "\nplease bring bananas next time";
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
                } else if (input.startsWith("todo ")) {
                    String description = input.substring(5);
                    manager.addToDo(description);
                } else if (input.startsWith("deadline ")) {
                    String content = input.substring(9);
                    String description = content.split("/by")[0].trim();
                    String date = content.split("/by")[1].trim();
                    manager.addDeadlineTask(description, date);
                } else if (input.startsWith("event ")) {
                    String content = input.substring(6);
                    String[] splits = content.split("/from | /to");
                    String description = splits[0].trim();
                    String start = splits[1].trim();
                    String end = splits[2].trim();
                    manager.addEventTask(description, start, end);
                } else {
                    throw new GeorgeException("What are you saying???");
                }
            }  catch (GeorgeException e) {
                System.out.println(e.toString());
            }
        }
        scanner.close();
    }
}
