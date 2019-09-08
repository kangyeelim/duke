package seedu.duke;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Represents the command when user inputs 'find'. A <code>FindCommand</code> object
 * can <code>execute</code> the command, with checks for exception, by finding matching tasks with a single keyword.
 */

public class FindCommand extends Command {
    protected String command;
    protected TaskList matchList;
    protected DateFormat outDateFormat = new SimpleDateFormat( "dd/MM/yyyy");
    protected DateFormat outTimeFormat = new SimpleDateFormat("H.mm aa");
    private static final String LIST_TYPE = "both";

    /**
     * Class constructor.
     *
     * @param command String command of 'find'.
     */
    public FindCommand(String command) {
        this.command = command;
        matchList = new TaskList();
    }

    /**
     * Executes the command after checking for exceptions.
     * Prints the information and number of tasks that match keyword from all tasks.
     *
     * @param tasks TaskList currently.
     * @param ui Ui initialized in <code>Duke</code> to interact with user.
     * @param storage Storage to append to data file after updating tasks.
     * @throws DukeException Exception for incorrect user input.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Parser.checkErrorForFindCommand(command, ui);
        String keyword = Parser.getKeyword(command);
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i) instanceof Event) {
                Event event = (Event) tasks.get(i);
                if (event.getDescription().contains(keyword)) {
                    matchList.add(event);
                } else if (outDateFormat.format(event.getDate()).contains(keyword)) {
                    matchList.add(event);
                } else if (outTimeFormat.format(event.getTime()).contains(keyword)) {
                    matchList.add(event);
                }
            } else if (tasks.get(i) instanceof Todo) {
                Todo td = (Todo) tasks.get(i);
                if (td.getDescription().contains(keyword)) {
                    matchList.add(td);
                }
            } else if (tasks.get(i) instanceof  Deadline){
                Deadline dl = (Deadline) tasks.get(i);
                if (dl.getDescription().contains(keyword)) {
                    matchList.add(dl);
                } else if (outDateFormat.format(dl.getDate()).contains(keyword)) {
                    matchList.add(dl);
                } else if (outTimeFormat.format(dl.getTime()).contains(keyword)) {
                    matchList.add(dl);
                }
            }
        }
        return ui.printAllMatchingTasks(matchList);
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
     * Returns tasklist of all tasks currently that match the keyword.
     *
     * @return TaskList of all tasks matching keyword
     */
    public TaskList getMatchList() {
        return this.matchList;
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
     * Returns a string that indicates this command works on both list.
     *
     * @return list type of both.
     */
    public String getListType() {
        return LIST_TYPE;
    }
}
