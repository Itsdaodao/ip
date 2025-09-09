import exceptions.GeorgeException;

public class DeleteCommand extends Command {
    private final int taskNumber;

    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskManager manager) throws GeorgeException {
        manager.deleteTask(taskNumber);
    }

    @Override
    public String getCommandWord() {
        return "delete";
    }
}
