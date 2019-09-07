package seedu.duke;

/**
 * Represents the command when user inputs 'deadline'. A <code>DeadlineCommand</code> object
 * can <code>execute</code> the command with checks for exception by adding deadline to tasks.
 */
public class DeadlineCommand extends Command {
    private String command;
    private static final String LIST_TYPE = "task";

    /**
     * Class constructor.
     *
     * @param command String command of 'deadline'.
     */
    public DeadlineCommand(String command) {
        this.command = command;
    }

    /**
     * Executes the command after checking for exceptions.
     * Prints the message with the deadline information and number of tasks in list.
     *
     * @param tasks TaskList currently.
     * @param ui Ui initialized in <code>Duke</code> to interact with user.
     * @param storage Storage to append to data file after updating tasks.
     * @throws DukeException Exception for incorrect user input.
     * @throws java.text.ParseException If there is incorrect date and time input.
     * @throws Exception If unable to append to data file.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws Exception {
        Parser.checkErrorForDeadlineCommand(command, tasks, ui);
        tasks.add(Parser.createDeadline(command));
        if (tasks.size() > 1) {
            storage.appendFile(tasks);
        } else {
            storage.writeFile(tasks);
        }

        assert tasks.size() >= 1 : "Task size invalid";
        return ui.printAddedTask(tasks.get(tasks.size() - 1)) + "\n" +
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
        return "DeadlineCommand";
    }
}