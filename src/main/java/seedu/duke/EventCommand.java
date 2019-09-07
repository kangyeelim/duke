package seedu.duke;

/**
 * Represents the command when user inputs 'event'. An <code>EventCommand</code> object
 * can <code>execute</code> the command with checks for exception by adding event to tasks.
 */
public class EventCommand extends Command {
    private String command;

    /**
     * Class constructor.
     *
     * @param command String command of 'event'.
     */
    public EventCommand(String command) {
        this.command = command;
    }

    /**
     * Executes the command after checking for exceptions.
     * Prints the message with the event information and number of tasks in list.
     *
     * @param tasks TaskList currently.
     * @param ui Ui initialized in <code>Duke</code> to interact with user.
     * @param storage Storage to append to data file after updating tasks.
     * @throws DukeException Exception for incorrect user input.
     * @throws java.text.ParseException Exception for incorrect date and time input.
     * @throws Exception Exception for being unable to append to data file.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws Exception {
        ui.checkErrorForEventCommand(command, tasks);
        tasks.add(Parser.createEvent(command));
        assert tasks.size() > 0 : "tasks size invalid";
        storage.appendFile(tasks);
        return ui.printAddedTask(tasks.get(tasks.size() - 1)) +"\n" +
            ui.printNoOfTaskInList(tasks);
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
     * Returns type of command.
     *
     * @return String of command type.
     */
    @Override
    public String toString() {
        //for testing purposes
        return "EventCommand";
    }
}