package george.command;

import george.exceptions.GeorgeException;

public class CommandParser {
    public static Command parse(String input) throws GeorgeException {
        if (input.equals("bye")) {
            return new ExitCommand();
        } else if (input.equals("list")) {
            return new ListCommand();
        } else if (input.startsWith("mark ")) {
            int taskNumber = Integer.parseInt(input.substring(5));
            return new MarkCommand(taskNumber);
        } else if (input.startsWith("unmark ")) {
            int taskNumber = Integer.parseInt(input.substring(7));
            return new UnmarkCommand(taskNumber);
        } else if (input.startsWith("todo ")) {
            String description = input.substring(5);
            return new ToDoCommand(description);
        } else if (input.startsWith("deadline ")) {
            String content = input.substring(9);
            String[] parts = content.split("/by");
            if (parts.length < 2) {
                throw new GeorgeException("Deadline format should be: deadline description /by date");
            }
            String description = parts[0].trim();
            String date = parts[1].trim();
            return new DeadlineCommand(description, date);
        } else if (input.startsWith("event ")) {
            String content = input.substring(6);
            String[] splits = content.split("/from |/to ");
            if (splits.length < 3) {
                throw new GeorgeException("Event format should be: event description /from start /to end");
            }
            String description = splits[0].trim();
            String start = splits[1].trim();
            String end = splits[2].trim();
            return new EventCommand(description, start, end);
        } else if (input.startsWith("delete ")) {
            int taskNumber = Integer.parseInt(input.substring(7));
            return new DeleteCommand(taskNumber);
        } else {
            return new InvalidCommand();
        }
    }
}