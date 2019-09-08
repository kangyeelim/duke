package seedu.duke;

public class HelpCommand extends Command {

    public HelpCommand() {

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
     */
    public String execute(TaskList tasks, ExpenseList expenses, Ui ui, Storage taskStorage, Storage expenseStorage) {
        String instructions = /*"Let me teach you how to use me:\n" +
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
                "To delete expense from expense list: enter 'delete e[index in expense list]'\n";*/
        "help";


        return instructions;
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
