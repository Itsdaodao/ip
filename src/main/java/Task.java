abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) throws GeorgeException {
        if (description == null || description.trim().isEmpty()) {
            throw new GeorgeException("You can't have an empty task. Please do something!");
        }
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsNotDone() {
        this.isDone = false;
    }

    public String getStatus() {
        return isDone ? "[X]" : "[ ]";
    }

    abstract String getType();
    abstract String getDisplayText();
}
