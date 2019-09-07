package seedu.duke;

public class ExpenseCommand extends Command{
    protected String command;
    private static final String LIST_TYPE = "EXPENSE";

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

    @Override
    public boolean isExit() {
        return false;
    }

    public String getListType() {
        return LIST_TYPE;
    }
}
