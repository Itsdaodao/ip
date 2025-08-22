public class EventTask extends Task {
    private String startTime;
    private String endTime;

    public EventTask(String description, String startTime, String endTime) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
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
}
