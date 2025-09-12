package george.command;

import java.util.List;

import george.exceptions.GeorgeException;
import george.task.Task;
import george.task.TaskManager;

/**
 * Represents a command to find tasks containing a specific keyword.
 */
public class FindCommand extends Command {
    private String keyword;

    /**
     * Constructs a FindCommand with the specified keyword.
     *
     * @param keyword The keyword to search for in task descriptions.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command by searching for tasks containing the keyword.
     *
     * @param manager The TaskManager containing all tasks.
     * @throws GeorgeException If there's an error during execution.
     */
    @Override
    public void execute(TaskManager manager) throws GeorgeException {
        if (keyword == null || keyword.trim().isEmpty()) {
            throw new GeorgeException("Please provide a keyword to search for.");
        }

        List<Task> matchingTasks = manager.findTasks(keyword);

        if (matchingTasks.isEmpty()) {
            System.out.println("No matching tasks found for: " + keyword);
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println((i + 1) + "." + matchingTasks.get(i).getDisplayText());
            }
        }
    }

    @Override
    public String getCommandWord() {
        return "find";
    }
}
