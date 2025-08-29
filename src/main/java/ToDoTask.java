public class ToDoTask extends Task {
    public ToDoTask(String description) throws GeorgeException {
        this(description, false);
    }

    public ToDoTask(String description, boolean isDone) throws GeorgeException {
        super(description);
        this.isDone = isDone;
    }

    @Override
    public String getType() {
        return "[T]";
    }

    @Override
    public String getDisplayText() {
        return this.getType() + this.getStatus() + " "
                + this.getDescription();
    }
}
