package george.command;

import george.exceptions.GeorgeException;
import george.task.TaskManager;

public class ToDoCommand extends Command {
    private final String description;

    public ToDoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskManager manager) throws GeorgeException {
        manager.addToDoTask(description);
    }

    @Override
    public String getCommandWord() {
        return "todo";
    }
}
