public class ToDoTask extends Task {
    public ToDoTask(String description) throws GeorgeException {
        super(description);
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
