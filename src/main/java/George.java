import java.io.IOException;
import java.util.Scanner;
import exceptions.GeorgeException;

public class George {
    private static final String fileName = "george.txt";
    private static final String newLine = """
            
            GEORGE the monkey LOVES to eat bananas!\
            
            """;

    public static void main(String[] args)  {
        greet();
        try {
            TaskManager manager = start();
            echo(manager);
        } catch (IOException e) {
            System.out.println("Error starting taskmanager: " + e.getMessage());
        }
    }

    private static void greet() {
        String greeting = """
                Ooo eee ooo aaa aaa\s
                I am George the Monkey\
                
                George can help you with?""";
        System.out.println(greeting);
        System.out.println(newLine);
    }

    private static TaskManager start() throws IOException {
        TaskManager manager = new TaskManager(fileName);
        manager.load();
        return manager;
    }

    private static void echo(TaskManager manager) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            try {
                Command command = CommandParser.parse(input);
                command.execute(manager);

                if (command instanceof ExitCommand) {
                    break;
                }
            } catch (GeorgeException e) {
                System.out.println(e.toString());
            } catch (NumberFormatException e) {
                System.out.println("Please provide a valid task number!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
