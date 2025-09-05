import exceptions.GeorgeException;
import utils.DateTimeParser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeadlineTask extends Task {
    private LocalDateTime deadline;

    public DeadlineTask(String description, String deadline) throws GeorgeException {
        this(description, deadline, false);
    }

    public DeadlineTask(String description, String deadline, boolean isDone) throws GeorgeException {
        super(description);
        this.deadline = DateTimeParser.parseDateTime(deadline);
        this.isDone = isDone;
    }

    @Override
    public String getType() {
        return "[D]";
    }

    public String getDeadline() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return deadline.format(formatter);
    }

    @Override
    public String getDisplayText() {
        return this.getType() + this.getStatus()
                + " " + this.getDescription() + " (by: " + this.getDeadline() + ")";
    }

    @Override
    public String toString() {
        return getType().charAt(1) + " | " + (isDone() ? 1 : 0) + " | " + getDescription() + " | " + getDeadline();
    }
}
