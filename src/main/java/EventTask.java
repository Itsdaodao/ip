public class EventTask extends Task {
    private String startTime;
    private String endTime;

    public EventTask(String description, String startTime, String endTime) throws GeorgeException {
        this(description, startTime, endTime, false);
    }

    public EventTask(String description, String startTime, String endTime, boolean isDone) throws GeorgeException {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
        this.isDone = isDone;
    }

    @Override
    public String getType() {
        return "[E]";
    }

    @Override
    public String getDisplayText() {
        return this.getType() + this.getStatus() + " " + this.getDescription()
                + " (from: " + this.startTime + " to: " + this.endTime + ")";
    }

    @Override
    public String toString() {
        return getType().charAt(1) + " | " + (isDone() ? 1 : 0) + " | " + getDescription() + " | " + startTime + " | "
                + endTime;
    }
}
