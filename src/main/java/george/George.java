import java.io.IOException;
import java.util.Scanner;

import george.command.Command;
import george.command.CommandParser;
import george.exceptions.GeorgeException;

public class George {
    private static final String fileName = "george.txt";
    private final Ui ui;

    public George() {
        this.ui = new Ui();
    }

    public static void main(String[] args)  {
        George george = new George();
        george.run();
    }

    private void run() {
        ui.showWelcome();
        try {
            TaskManager manager = start();
            echo(manager);
        } catch (IOException e) {
            ui.showError("Error starting taskmanager: " + e.getMessage());
        }
    }

    private TaskManager start() throws IOException {
        TaskManager manager = new TaskManager(fileName);
        manager.load();
        return manager;
    }

    private void echo(TaskManager manager) {
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
