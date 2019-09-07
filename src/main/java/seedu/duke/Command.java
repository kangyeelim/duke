package seedu.duke;

/**
 * Executes command and is the parent class of all duke commands.
 * Abstract class with no method implementations.
 */
public abstract class Command {
    /**
     * Class constructor.
     */
    public Command() {
    }

    /**
     * Executes the command by checking exceptions,
     * and printing out what has been done
     *
     * @param tasks  TaskList of all tasks currently.
     * @param ui Ui that interacts with user by checking for exceptions and printing out
     *           executed tasks.
     * @param storage Storage that load/write or append to data file after updating tasks.
     * @throws DukeException  If there is incorrect user input format.
     * @throws java.io.IOException If there is problems reading/writing or appending to file.
     * @throws Exception If there is problems with Parser reading in file line.
     */
    public abstract String execute(TaskList tasks, Ui ui, Storage storage) throws Exception;

    public abstract String execute(ExpenseList expenses, Ui ui, Storage storage) throws Exception;

    /**
     * Returns if duke should end.
     *
     * @return Boolean if duke should end.
     */
    public abstract boolean isExit();

    public abstract String getListType();
}
