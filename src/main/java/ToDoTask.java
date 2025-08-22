public class ToDoTask extends Task {
    public ToDoTask(String description) {
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
