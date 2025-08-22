public class ToDoTask implements Task {
    private final String description;
    private boolean isDone;

    public ToDoTask(String description) {
        this.description = description;
        this.isDone = false;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isDone() {
        return isDone;
    }

    @Override
    public void markAsDone() {
        this.isDone = true;
    }

    @Override
    public void markAsNotDone() {
        this.isDone = false;
    }

    @Override
    public String getStatus() {
        return isDone ? "[X]" : "[ ]";
    }

    @Override
    public String getType() {
        return "[T]";
    }

    @Override
    public String toString() {
        return this.getType() + this.getStatus() + " " + this.getDescription();
    }
}
