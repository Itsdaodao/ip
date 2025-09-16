package george.task;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import george.exceptions.GeorgeException;
import george.utils.DateTimeParser;

/**
 * Represents a task with a specific deadline.
 * Extends the base Task class with deadline-specific functionality.
 */
public class DeadlineTask extends Task {
    private LocalDateTime deadline;

    /**
     * Constructs a DeadlineTask with description and deadline string.
     *
     * @param description The description of the deadline task
     * @param deadline The deadline time string to be parsed
     * @throws GeorgeException If the description is invalid or deadline time cannot be parsed
     */
    public DeadlineTask(String description, String deadline) throws GeorgeException {
        this(description, deadline, false);
    }

    /**
     * Constructs a DeadlineTask with description, deadline string, and completion status.
     *
     * @param description The description of the deadline task
     * @param deadline The deadline time string to be parsed
     * @param isDone The completion status of the task
     * @throws GeorgeException If the description is invalid or deadline time cannot be parsed
     */
    public DeadlineTask(String description, String deadline, boolean isDone) throws GeorgeException {
        super(description);
        this.deadline = DateTimeParser.parseDateTime(deadline);
        this.isDone = isDone;
    }

    @Override
    public String getType() {
        return "[D]";
    }

    /**
     * Returns the formatted deadline string.
     *
     * @return The deadline formatted as "MMM dd yyyy" (e.g., "Jan 15 2024")
     */
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
