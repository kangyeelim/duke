package seedu.duke;

public class ExpenseCommand extends Command{
    protected String command;
    private static final String LIST_TYPE = "expense";

    public ExpenseCommand(String command) {
        this.command = command;
    }


    public String execute(ExpenseList expenses, Ui ui, Storage storage) throws Exception {
        Parser.checkErrorForExpenseCommand(command, ui, storage);
        expenses.add(Parser.createExpense(command));
        assert expenses.size() > 0 : "tasks size invalid";
        if (expenses.size() > 1) {
            storage.appendExpenseFile(expenses);
        } else {
            storage.writeExpenseFile(expenses);
        }
        return ui.printAddedExpense(expenses.get(expenses.size() - 1)) +"\n" +
                ui.printNoOfExpenseInList(expenses);
    }

    public String execute(TaskList tasks, Ui ui, Storage storage) throws Exception {
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
     * Returns a string that indicates this expense related command works on the expense list.
     *
     * @return list type of expense.
     */
    public String getListType() {
        return LIST_TYPE;
    }
}
