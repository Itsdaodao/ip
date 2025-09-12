package george.task;

import george.exceptions.GeorgeException;

/**
 * Represents a todo task without any date or time constraints.
 * Extends the base Task class for basic task functionality.
 */
public class ToDoTask extends Task {
    /**
     * Constructs a ToDoTask with the specified description.
     *
     * @param description The description of the todo task
     * @throws GeorgeException If the description is invalid
     */
    public ToDoTask(String description) throws GeorgeException {
        this(description, false);
    }

    /**
     * Constructs a ToDoTask with description and completion status.
     *
     * @param description The description of the todo task
     * @param isDone The completion status of the task
     * @throws GeorgeException If the description is invalid
     */
    public ToDoTask(String description, boolean isDone) throws GeorgeException {
        super(description);
        this.isDone = isDone;
    }

    /**
     * Returns the type identifier for todo tasks.
     *
     * @return The string "[T]" representing a todo task
     */
    @Override
    public String getType() {
        return "[T]";
    }

    /**
     * Returns the formatted display text for the todo task.
     *
     * @return A formatted string containing task type, status, and description
     */
    @Override
    public String getDisplayText() {
        return this.getType() + this.getStatus() + " "
                + this.getDescription();
    }

    /**
     * Returns a string representation for storage purposes.
     *
     * @return A pipe-separated string containing task type, status, and description
     */
    @Override
    public String toString() {
        return getType().charAt(1) + " | " + (isDone() ? 1 : 0) + " | " + getDescription();
    }
}
