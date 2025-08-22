public class DeadlineTask implements Task {
    private final String description;
    private boolean isDone;
    private String deadline;

    public DeadlineTask(String description, String deadline) {
        this.description = description;
        this.isDone = false;
        this.deadline = deadline;
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
        return "[D]";
    }

    public String getDeadline() {
        return this.deadline;
    }

    @Override
    public String toString() {
        return this.getType() + this.getStatus() + " " + this.getDescription() + " (by: " + this.getDeadline() + ")";
    }
}
