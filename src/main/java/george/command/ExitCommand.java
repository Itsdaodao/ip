package george.command;

import george.task.TaskManager;

/**
 * Represents a command to exit the George application.
 * This command displays a farewell message and terminates the program.
 */

public class ExitCommand extends Command {

    @Override
    public void execute(TaskManager manager) {
        String exit = "I love bananas " +
                "\nplease bring bananas next time";
        System.out.println("\n" + exit);
    }

    @Override
    public String getCommandWord() {
        return "bye";
    }
}
