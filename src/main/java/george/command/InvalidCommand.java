package george.command;

import george.exceptions.GeorgeException;
import george.task.TaskManager;

public class InvalidCommand extends Command {
    @Override
    public void execute(TaskManager manager) throws GeorgeException {
        throw new GeorgeException("What are you saying???");
    }

    @Override
    public String getCommandWord() {
        return "invalid";
    }
}
