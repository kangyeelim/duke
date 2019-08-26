package seedu.duke;

/**
 * Represents the command when user inputs 'bye'. A <code>ByeCommand</code> object
 * can <code>execute</code> the command and end Duke.
 */
public class ByeCommand extends Command {
    private String command;
    private Ui ui;

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
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        this.ui = ui;
    }

    /**
     * Returns true to end Duke.
     * Prints goodbye message before returning.
     *
     * @return True to end Duke
     */
    public boolean isExit() {
        ui.printGoodbyeMsg();
        return true;
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
