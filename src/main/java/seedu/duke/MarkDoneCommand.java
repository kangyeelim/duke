package seedu.duke;

/**
 * Represents the command when user inputs 'done'. A <code>MarkDoneCommand</code> object
 * can <code>execute</code> the command with checks for exception.
 */
public class MarkDoneCommand extends Command {
    private String command;

    /**
     * Class constructor.
     *
     * @param command String command of 'done'.
     */
    public MarkDoneCommand(String command) {
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
     * @throws DukeException  If there is incorrect user input format.
     * @throws java.io.IOException If there is problems reading/writing or appending to file.
     * @throws Exception If there is problems with Parser reading in file line.
     */
    public String execute(TaskList tasks, ExpenseList expenses, Ui ui,
                          Storage taskStorage, Storage expenseStorage) throws Exception {
        Parser.checkMarkDoneError(command, tasks, ui);
        int curr = Parser.taskToMarkDone(command);
        tasks.get(curr - 1).markAsDone();
        assert curr > 0 : "task number invalid";
        taskStorage.writeFile(tasks);
        return ui.printMarkDoneMsg(tasks.get(curr - 1));
    }

    /**
     * Returns false to continue Duke.
     *
     * @return False
     */
    public boolean isExit() {
        return false;
    }

    @Override
    public String toString() {
        //for testing purposes
        return "MarkDoneCommand";
    }
}