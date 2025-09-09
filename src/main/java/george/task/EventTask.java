package george.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import george.exceptions.GeorgeException;
import george.utils.DateTimeParser;

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

    @Override
    public String getType() {
        return "[E]";
    }

    @Override
    public String getDisplayText() {
        return this.getType() + this.getStatus() + " " + this.getDescription()
                + " (from: " + this.getStartTime() + " to: " + this.getEndTime() + ")";
    }

    public String getStartTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        return startTime.format(formatter);
    }

    public String getEndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        return endTime.format(formatter);
    }

    @Override
    public String toString() {
        return getType().charAt(1) + " | " + (isDone() ? 1 : 0) + " | " + getDescription() + " | " +
                getStartTime() + " | " + getEndTime();
    }
}
