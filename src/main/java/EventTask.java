public class EventTask implements Task {
    private final String description;
    private boolean isDone;
    private String startTime;
    private String endTime;

    public EventTask(String description, String startTime, String endTime) {
        this.description = description;
        this.isDone = false;
        this.startTime = startTime;
        this.endTime = endTime;
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
        return "[E]";
    }

    @Override
    public String toString() {
        return this.getType() + this.getStatus() + " "
                + this.getDescription() + " (from: " + this.startTime + " to: " + this.endTime + ")";
    }
}
