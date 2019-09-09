package seedu.duke;

public class HelpCommand extends Command {

    /**
     * Class constructor.
     */
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
        String instructions = "Let me teach you how to use me:\n\n" +
                "FOR TASK MANAGING:\n" +
                "1. To add a todo to your list: enter 'todo [description]'\n" +
                "2. To add a deadline to your list: enter 'deadline [description] /by " +
                "[date] [time]'\n" +
                "3. To add an event to your list: enter 'event [description] /at " +
                "[date] [time]'\n" +
                "4. To see list of tasks: enter 'list'\n" +
                "5. To delete task from list: enter 'delete [index]'\n" +
                "6. To find task by a single keyword: enter 'find [keyword]'\n\n" +
                "FOR EXPENSE TRACKING:\n" +
                "1. To add expense to expense list: enter 'expense [description] " +
                "[cost]'\n" +
                "2. To see all expenses: enter 'elist'\n" +
                "3. To delete expense from expense list: enter 'delete e[index]'\n";
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
