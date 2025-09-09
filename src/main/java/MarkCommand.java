import exceptions.GeorgeException;

public class MarkCommand extends Command {
    private final int taskNumber;

    public MarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskManager manager) throws GeorgeException {
        manager.markTaskAsDone(taskNumber);
    }

    @Override
    public String getCommandWord() {
        return "mark";
    }
}
