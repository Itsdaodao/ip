import exceptions.GeorgeException;

public abstract class Command {
    protected TaskManager manager;

    public Command(TaskManager manager) {
        this.manager = manager;
    }

    public abstract void execute() throws GeorgeException;
}
