import exceptions.GeorgeException;

public class ExitCommand extends Command {

    @Override
    public void execute(TaskManager manager) {
        String exit = "I love bananas " +
                "\nplease bring bananas next time";
        System.out.println("\n" + exit);
    }

    @Override
    public String getCommandWord() {
        return "bye";
    }
}
