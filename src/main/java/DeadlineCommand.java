import exceptions.GeorgeException;

public class DeadlineCommand extends Command {
    private final String description;
    private final String date;

    public DeadlineCommand(String description, String date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public void execute(TaskManager manager) throws GeorgeException {
        manager.addDeadlineTask(description, date);
    }

    @Override
    public String getCommandWord() {
        return "deadline";
    }
}
