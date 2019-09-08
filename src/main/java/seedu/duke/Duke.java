package seedu.duke;

import java.text.ParseException;

/**
 * Runs as a chat bot that helps to manage tasks.
 * Loads task information from data file in hard drive when initialized
 * or creates file in hard drive if it does not exist.
 */
public class Duke {
    private Storage storage;
    private Storage expenseStorage;
    private TaskList tasks;
    private Ui ui;
    private ExpenseList expenses;

    /**
     * Class constructor.
     */
    public Duke() {}

    /**
     * Returns a message response to user input.
     *
     * @return String of message.
     */
    public String getResponse(String input) {
        return run(input);
    }


    /**
     * Runs Duke which will load tasks from data file, take in user commands to create tasks,
     * delete tasks, mark task as done, list out task while updating data file when the tasks in
     * the list is updated.
     *
     * @param input User input.
     */
    public String run(String input) {
        try {
            Command c = Parser.parse(input, ui);
            return c.execute(tasks, expenses, ui, storage, expenseStorage);
        } catch (DukeException e) {
            return e.toString();
        } catch (ParseException e) {
            return ui.showParseError();
        } catch (ArrayIndexOutOfBoundsException e) {
            return ui.showParseError();
        } catch (Exception e) {
            return ui.showExceptionMsg(e);
        }
    }

    /**
     * Loads data file into task list in Duke.
     */
    public void load() {
        ui = new Ui();
        storage = new Storage("data/duke.txt");
        expenseStorage = new Storage("data/expenses.txt");
        try {
            tasks = new TaskList(storage.loadTaskFile());
            expenses = new ExpenseList(expenseStorage.loadExpenseFile());
        } catch (Exception e) {
            ui.showLoadingError();
            tasks = new TaskList();
            expenses = new ExpenseList();
        }
    }
}
