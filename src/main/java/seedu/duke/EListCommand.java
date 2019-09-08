package seedu.duke;

public class EListCommand extends Command {
    private String command;
    private static final String LIST_TYPE = "expense";

    public EListCommand(String command) {
        this.command = command;
    }

    public String execute(TaskList tasks, Ui ui, Storage storage) throws Exception {
        return null;
    }

    public String execute(ExpenseList expenses, Ui ui, Storage storage) throws Exception {
        return ui.printAllExpenses(expenses);
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
