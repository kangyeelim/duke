package seedu.duke;

/**
 * Represents the command when user inputs 'todo'. A <code>TodoCommand</code> object
 * can <code>execute</code> the command with checks for exception by adding todo to tasks.
 */
public class TodoCommand extends Command {
    private String command;
    private static final String LIST_TYPE = "task";
    /**
     * Class constructor.
     *
     * @param command String command of 'todo'.
     */
    public TodoCommand(String command) {
        this.command = command;
    }

    /**
     * Executes the command after checking for exceptions.
     * Prints the message with the todo information and number of tasks in list.
     *
     * @param tasks TaskList currently.
     * @param ui Ui initialized in <code>Duke</code> to interact with user.
     * @param storage Storage to append to data file after updating tasks.
     * @throws DukeException Exception for incorrect user input.
     * @throws java.text.ParseException Exception for incorrect date and time input.
     * @throws Exception Exception for being unable to append to data file.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws Exception {
        Parser.checkErrorForTodoCommand(command, tasks, ui);
        tasks.add(Parser.createTodo(command));
        assert tasks.size() > 0 : "tasks size invalid";
        if (tasks.size() > 1) {
            storage.appendFile(tasks);
        } else {
            storage.writeFile(tasks);
        }
        return ui.printAddedTask(tasks.get(tasks.size() - 1)) + "\n" +
            ui.printNoOfTaskInList(tasks);
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

    /**
     * Returns type of command.
     *
     * @return String of command type.
     */
    @Override
    public String toString() {
        //for testing purposes
        return "TodoCommand";
    }
}
