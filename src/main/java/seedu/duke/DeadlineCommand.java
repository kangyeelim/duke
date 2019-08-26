package seedu.duke;

/**
 * Represents the command when user inputs 'deadline'. A <code>DeadlineCommand</code> object
 * can <code>execute</code> the command with checks for exception by adding deadline to tasks.
 */
public class DeadlineCommand extends Command {
    private String command;

    /**
     * Constructor of DeadlineCommand.
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
     * @throws java.text.ParseException Exception for incorrect date and time input.
     * @throws Exception Exception for being unable to append to data file.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) throws Exception {
        ui.checkErrorForDeadlineCommand(command, tasks);
        tasks.add(Parser.createDeadline(command));
        ui.printAddedTask(tasks.get(tasks.size() - 1));
        ui.printNoOfTaskInList(tasks);
        storage.appendFile(tasks);
    }

    /**
     * Returns false to continue Duke.
     *
     * @return false
     */
    public boolean isExit() {
        return false;
    }

    @Override
    public String toString() {
        //for testing purposes
        return "DeadlineCommand";
    }
}