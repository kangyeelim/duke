package seedu.duke;

/**
 * Represents the command when user inputs 'done'. A <code>MarkDoneCommand</code> object
 * can <code>execute</code> the command with checks for exception.
 */
public class MarkDoneCommand extends Command {
    private String command;
    private static final String LIST_TYPE = "task";

    /**
     * Class constructor.
     *
     * @param command String command of 'done'.
     */
    public MarkDoneCommand(String command) {
        this.command = command;
    }

    /**
     * Executes the command after checking for exceptions.
     * Prints the message with the task information and number of tasks in list.
     * Tick is printed for the task.
     *
     * @param tasks TaskList currently.
     * @param ui Ui initialized in <code>Duke</code> to interact with user.
     * @param storage Storage to overwrite data file after updating task as done.
     * @throws DukeException If there is incorrect user input.
     * @throws Exception If unable to overwrite data file.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws Exception {
        Parser.checkMarkDoneError(command, tasks, ui);
        int curr = Parser.taskToMarkDone(command);
        tasks.get(curr - 1).markAsDone();
        assert curr > 0 : "task number invalid";
        storage.writeFile(tasks);
        return ui.printMarkDoneMsg(tasks.get(curr - 1));
    }

    /**
     * Acts as a dummy execute for child of a <code>Command</code>
     * This is used for a expense command.
     *
     * @param expenses TaskList currently.
     * @param ui Ui initialized in <code>Duke</code> to interact with user.
     * @param storage Storage to write/load/append to data file after updating tasks.
     * @return String of goodbye message.
     */
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

    /**
     * Returns a string that indicates this task related command works on the task list.
     *
     * @return list type of task.
     */
    public String getListType() {
        return LIST_TYPE;
    }

    @Override
    public String toString() {
        //for testing purposes
        return "MarkDoneCommand";
    }
}