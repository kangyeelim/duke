package seedu.duke;

public class DeleteExpenseCommand extends Command {
    private String command;
    private static final String LIST_TYPE = "expense";

    /**
     * Class constructor.
     *
     * @param command String command of 'delete e'.
     */
    public DeleteExpenseCommand(String command) {
        this.command = command;
    }
    public String execute(TaskList tasks, Ui ui, Storage storage) throws Exception {
        return null;
    }

    public String execute(ExpenseList expenses, Ui ui, Storage storage) throws Exception {
        //Parser.checkErrorForDeleteExpenseCommand(command, expenses, ui);
        int curr = Parser.expenseToDelete(command);
        assert curr > 0 : "Task num is not valid";
        Expense deletedExpense = expenses.get(curr - 1);
        expenses.remove(curr - 1);
        storage.writeExpenseFile(expenses);
        return ui.printDeletedExpenseMsg(deletedExpense) + "\n" +
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

    /**
     * Returns a string that indicates this expense related command works on the expense list.
     *
     * @return list type of expense.
     */
    public String getListType() {
        return LIST_TYPE;
    }
}
