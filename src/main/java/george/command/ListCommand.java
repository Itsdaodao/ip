package george.command;

import george.task.TaskManager;

public class ListCommand extends Command {
    @Override
    public void execute(TaskManager manager) {
        manager.listTasks();
    }

    @Override
    public String getCommandWord() {
        return "list";
    }
}
