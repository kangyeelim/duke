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

    public boolean isExit() {
        return false;
    }

    public String getListType() {
        return LIST_TYPE;
    }
}
