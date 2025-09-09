package george.command;

import george.exceptions.GeorgeException;
import george.task.TaskManager;

public class UnmarkCommand extends Command {
    private final int taskNumber;

    public UnmarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskManager manager) throws GeorgeException {
        manager.markTaskAsNotDone(taskNumber);
    }

    @Override
    public String getCommandWord() {
        return "unmark";
    }
}
