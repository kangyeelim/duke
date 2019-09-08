package seedu.duke;

public class ExpenseCommand extends Command{
    protected String command;

    /**
     * Class constructor.
     *
     * @param command String command.
     */
    public ExpenseCommand(String command) {
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
        Parser.checkErrorForExpenseCommand(command, ui, expenseStorage);
        expenses.add(Parser.createExpense(command));
        assert expenses.size() > 0 : "tasks size invalid";
        if (expenses.size() > 1) {
            expenseStorage.appendExpenseFile(expenses);
        } else {
            expenseStorage.writeExpenseFile(expenses);
        }
        return ui.printAddedExpense(expenses.get(expenses.size() - 1)) +"\n" +
                ui.printNoOfExpenseInList(expenses);
    }

    /**
     * Returns false to continue Duke.
     *
     * @return False
     */
    public boolean isExit() {
        return false;
    }
}
