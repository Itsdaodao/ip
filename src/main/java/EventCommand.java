import exceptions.GeorgeException;

public class EventCommand extends Command {
    private final String description;
    private final String start;
    private final String end;

    public EventCommand(String description, String start, String end) {
        this.description = description;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute(TaskManager manager) throws GeorgeException {
        manager.addEventTask(description, start, end);
    }

    @Override
    public String getCommandWord() {
        return "event";
    }
}
