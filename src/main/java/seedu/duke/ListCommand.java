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
     * Executes the command by checking exceptions,
     * and printing out what has been done
     *
     * @param tasks  TaskList of all tasks currently.
     * @param expenses ExpenseList of all expenses currently.
     * @param ui Ui that interacts with user by checking for exceptions and printing out
     *           executed tasks.
     * @param taskStorage Storage that load/write or append to data file after updating tasks.
     * @param expenseStorage Storage that load/write or append to data file after updating expenses.
     */
    public String execute(TaskList tasks, ExpenseList expenses, Ui ui, Storage taskStorage, Storage expenseStorage) {
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