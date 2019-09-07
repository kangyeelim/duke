package seedu.duke;

/**
 * Represents the command when user inputs 'delete'. A <code>DeleteCommand</code> object
 * can <code>execute</code> the command with checks for exception by deleting task from list.
 */
public class DeleteCommand extends Command {
    private String command;
    private static final String LIST_TYPE = "task";

    /**
     * Class constructor.
     *
     * @param command String command of 'delete'.
     */
    public DeleteCommand(String command) {
        this.command = command;
    }

    /**
     * Executes the command after checking for exceptions.
     * Prints the message all the tasks in list with task information.
     *
     * @param tasks TaskList currently.
     * @param ui Ui initialized in <code>Duke</code> to interact with user.
     * @param storage Storage to append to data file after updating tasks.
     * @throws DukeException If there is incorrect user input.
     * @throws Exception If unable to overwrite data file
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws Exception {
        Parser.checkErrorForDeleteCommand(command, tasks, ui);
        int curr = Parser.taskToDelete(command);
        assert curr > 0 : "Task num is not valid";
        Task deletedTask = tasks.get(curr - 1);
        tasks.remove(curr - 1);
        storage.writeFile(tasks);
        return ui.printDeletedTaskMsg(deletedTask) + "\n" +
            ui.printNoOfTaskInList(tasks);
    }

    public String execute(ExpenseList expenses, Ui ui, Storage storage) throws Exception {
        return null;
    }

    /**
     * Returns false to continue Duke.
     *
     * @return False
     */
    public boolean isExit() {
        return false;
    }

    public String getListType() {
        return LIST_TYPE;
    }

    /**
     * Returns type of command.
     *
     * @return String of command type.
     */
    @Override
    public String toString() {
        //for testing purposes
        return "DeleteCommand";
    }
}
