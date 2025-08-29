public class DeadlineTask extends Task {
    private String deadline;

    public DeadlineTask(String description, String deadline) throws GeorgeException {
        this(description, deadline, false);
    }

    public DeadlineTask(String description, String deadline, boolean isDone) throws GeorgeException {
        super(description);
        this.deadline = deadline;
        this.isDone = isDone;
    }

    @Override
    public String getType() {
        return "[D]";
    }

    public String getDeadline() {
        return this.deadline;
    }

    @Override
    public String getDisplayText() {
        return this.getType() + this.getStatus()
                + " " + this.getDescription() + " (by: " + this.getDeadline() + ")";
    }
}
