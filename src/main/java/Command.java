import exceptions.GeorgeException;

public abstract class Command {
    public abstract void execute(TaskManager manager) throws GeorgeException;
    public abstract String getCommandWord();
}
