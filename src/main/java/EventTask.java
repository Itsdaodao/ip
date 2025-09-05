import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import exceptions.GeorgeException;
import utils.DateTimeParser;

public class EventTask extends Task {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public EventTask(String description, String startTime, String endTime) throws GeorgeException {
        this(description, startTime, endTime, false);
    }

    public EventTask(String description, String startTime, String endTime, boolean isDone) throws GeorgeException {
        super(description);
        this.startTime = DateTimeParser.parseDateTime(startTime);
        this.endTime = DateTimeParser.parseDateTime(endTime);
        this.isDone = isDone;
    }

    private String getFormattedTime(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return time.format(formatter);
    }

    @Override
    public String getType() {
        return "[E]";
    }

    @Override
    public String getDisplayText() {
        return this.getType() + this.getStatus() + " " + this.getDescription()
                + " (from: " + this.getFormattedTime(startTime) + " to: " + this.getFormattedTime(endTime) + ")";
    }

    @Override
    public String toString() {
        return getType().charAt(1) + " | " + (isDone() ? 1 : 0) + " | " + getDescription() + " | " + startTime + " | "
                + endTime;
    }
}
