package seedu.duke;

public class HelpCommand extends Command {
    private static final String LIST_TYPE = "any";

    public HelpCommand() {

    }

    public String execute(TaskList tasks, Ui ui, Storage storage) throws Exception {
        String instructions = "Let me teach you how to use me:\n" +
                "FOR TASK MANAGING:\n" +
                "To add a todo to your list: enter 'todo [one-word task description]'\n" +
                "To add a deadline to your list: enter 'deadline [one-word task description] /by " +
                "[date dd/MM/yyyy] [time in 24 hr (HHmm) or 12hr format (HH.mm AM/PM)]'\n" +
                "To add an event to your list: enter 'event [one-word task description /at " +
                "[date dd/MM/yyyy] [time in 24 hr (HHmm) or 12hr format (HH.mm AM/PM)]'\n" +
                "To see list of tasks: enter 'list'\n" +
                "To delete task from list: enter 'delete [index in list]'\n" +
                "To find task by a single keyword: enter 'find [keyword]'" +
                "FOR EXPENSE TRACKING:\n" +
                "To add expense to expense list: enter 'expense [one-word expense description] " +
                "[cost without currency]'\n" +
                "To see all expenses: enter 'elist'\n" +
                "To delete expense from expense list: enter 'delete e[index in expense list]'\n";
        return instructions;
    }

    public String execute(ExpenseList expenses, Ui ui, Storage storage) throws Exception {
        return null;
    }

    public boolean isExit() {
        return false;
    }

    public String getListType() {
        return LIST_TYPE;
    }
}
