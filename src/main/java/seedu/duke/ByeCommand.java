package seedu.duke;

/**
 * Represents the command when user inputs 'bye'. A <code>ByeCommand</code> object
 * can <code>execute</code> the command and end Duke.
 */
public class ByeCommand extends Command {
    private String command;
    private Ui ui;
    private static final String LIST_TYPE = "any";

    /**
     * Class constructor.
     *
     * @param command String command of "bye".
     */
    public ByeCommand(String command) {
        this.command = command;
    }

    /**
     * Executes the command.
     *
     * @param tasks TaskList currently.
     * @param ui Ui initialized in <code>Duke</code> to interact with user.
     * @param storage Storage to write/load/append to data file after updating tasks.
     * @return String of goodbye message.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        this.ui = ui;
        return ui.printGoodbyeMsg();
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
     * Returns true to end Duke.
     * Prints goodbye message before returning.
     *
     * @return True to end Duke
     */
    public boolean isExit() {
        return true;
    }

    /**
     * Returns a string that indicates this task related command works on the task list.
     *
     * @return list type of task.
     */
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
        return "ByeCommand";
    }
}
