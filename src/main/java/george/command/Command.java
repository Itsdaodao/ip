package george.command;

import george.exceptions.GeorgeException;
import george.task.TaskManager;

public abstract class Command {
    public abstract void execute(TaskManager manager) throws GeorgeException;
    public abstract String getCommandWord();
}
