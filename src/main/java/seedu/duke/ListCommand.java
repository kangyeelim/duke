package seedu.duke;

/**
 * Represents the command when user inputs 'list'. A <code>ListCommand</code> object
 * can <code>execute</code> the command by listing tasks.
 */
public class ListCommand extends Command {
    private String command;

    /**
     * Class constructor.
     *
     * @param command String command of 'list'.
     */
    public ListCommand(String command) {
        this.command = command;
    }

    /**
     * Executes the command by printing all tasks in list.
     *
     * @param tasks TaskList currently.
     * @param ui Ui initialized in <code>Duke</code> to interact with user.
     * @param storage Storage to append to data file after updating tasks.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return ui.printAllTasks(tasks);
    }

    /**
     * Returns false to continue Duke.
     *
     * @return False
     */
    public boolean isExit() {
        return false;
    }
}