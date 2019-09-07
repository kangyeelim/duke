package seedu.duke;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Executes methods that help to understand user input and data file input.
 * It identifies the intended user command, processes the information inputted
 * and calls the command to be executed.
 */
public class Parser {
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    protected static SimpleDateFormat timeFormat = new SimpleDateFormat("HHmm");
    protected static SimpleDateFormat dashDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    protected static SimpleDateFormat twelveHrTimeFormat = new SimpleDateFormat("K.mmaa");
    /**
     * Class constructor.
     */
    public Parser() {

    }

    /**
     * Creates a date object, taking in the format of dd/MM/yyyy for the string date input..
     *
     * @param s String of the date input.
     * @return Date of the task which is a <code>Date</code> object.
     * @throws ParseException If there is incorrect date user input format.
     */
    public static Date toDate(String s) throws ParseException {
        Date date = dateFormat.parse(s);
        return date;
    }

    /**
     * Creates a date object, taking in format of HHmm (24hr) for the string time input.
     *
     * @param s String of the time input.
     * @return Time of the task which is a <code>Date</code> object.
     * @throws ParseException If there is incorrect time user input format.
     */
    public static Date toTime(String s) throws ParseException {
        Date time = timeFormat.parse(s);
        return time;
    }

    /**
     * Creates a <code>Task</code> object by reading in a line of input in data file format.
     *
     * @param line String of a line of input in the data file format.
     * @return <code>Deadline</code> , <code>Event</code> or <code>Todo</code >object created from the input in data file format.
     * @throws ParseException If there is incorrect input format, different from standard data file format.
     */
    public static Task readInFileLine(String line) throws ParseException {
        String[] stringArr = line.split(" [|] ", 0);
        assert line.length() > 0 : "file path invalid";
        if (stringArr[0].equals("E")) {
            String[] dateTimeArr = (stringArr[3]).split(" ", 2);
            Date date = toDate(dateTimeArr[0]);
            Date time = toTime(dateTimeArr[1]);
            Event event = new Event(stringArr[2], date, time);
            if (stringArr[1].equals("1")) {
                event.markAsDone();
            }
            return event;
        } else if (stringArr[0].equals("T")) {
            Todo td = new Todo(stringArr[2]);
            if (stringArr[1].equals("1")) {
                td.markAsDone();
            }
            return td;
        } else {
            String[] dateTimeArr = (stringArr[3]).split(" ", 2);
            Date date = toDate(dateTimeArr[0]);
            Date time = toTime(dateTimeArr[1]);
            Deadline dl = new Deadline(stringArr[2], date, time);
            if (stringArr[1] .equals("1")) {
                dl.markAsDone();
            }
            return dl;
        }
    }

    /**
     * Identifies if the command intended to be a delete command to delete task.
     *
     * @param command String of the command user input.
     * @return Boolean if the command is intended to be a delete command.
     */
    public static boolean isDeleteCommand(String command) {
        return (command.length() >= 6 && command.substring(0, 6).equals("delete"));
    }


    /**
     * Identifies the index of task to be deleted from the user command input.
     *
     * @param command String of the command user input.
     * @return Integer index of the task to be a deleted.
     */
    public static int taskToDelete(String command) {
        return Integer.parseInt(command.substring(7));
    }

    /**
     * Identifies if the command intended to be a todo command to create a todo task.
     *
     * @param command String of the command user input.
     * @return Boolean if the command is intended to be a todo command.
     */
    public static boolean isTodo(String command) {
        return (command.length() >= 4 && command.substring(0, 4).equals("todo"));
    }

    /**
     * Creates a new todo task according to the user input command.
     *
     * @param command String of the command user input.
     * @return <code>Todo</code> object created from user input command.
     */
    public static Todo createTodo(String command) {
        return new Todo(command.substring(5));
    }

    /**
     * Identifies if the command intended to be a event command to create a event task.
     *
     * @param command String of the command user input.
     * @return Boolean if the command is intended to be a event command.
     */
    public static boolean isEvent(String command) {
        return (command.length() >= 5 && command.substring(0, 5).equals("event"));
    }

    /**
     * Creates a new event task according to the user input command.
     *
     * @param command String of the command user input.
     * @return <code>Event</code> object created from user input command.
     * @throws ParseException If the date or time input of the user is incorrect.
     */
    public static Event createEvent(String command) throws ParseException {
        assert command.contains("/at") : "event command invalid";
        String[] arr = command.split(" /at ", 2);
        String[] dateTimeArr = (arr[1]).split(" ", 2);
        Date date, time;
        try {
             date = dateFormat.parse(dateTimeArr[0]);
        } catch (ParseException e) {
            date = dashDateFormat.parse(dateTimeArr[0]);
        }
        try {
            time = timeFormat.parse(dateTimeArr[1]);
        } catch (ParseException e) {
            time = twelveHrTimeFormat.parse(dateTimeArr[1]);
        }
        return new Event(arr[0].substring(6), date, time);

    }

    /**
     * Identifies if the command intended to be a deadline command to create a deadline task.
     *
     * @param command String of the command user input.
     * @returrn Boolean if the command is intended to be a deadline command.
     */
    public static boolean isDeadline(String command) {
        return (command.length() >= 8 && command.substring(0, 8).equals("deadline"));
    }

    /**
     * Creates a new deadline task according to the user input command.
     *
     * @param command String of the command user input.
     * @returrn <code>Deadline</code> object created from user input command.
     * @throws ParseException If the date or time input of the user is incorrect.
     */
    public static Deadline createDeadline(String command) throws ParseException {
        assert command.contains("/by") : "deadline command invalid";
        String[] arr = command.split(" /by ", 2);
        String[] dateTimeArr = (arr[1]).split(" ", 2);
        //throw error if user never input time or date
        Date date, time;
        try {
            date = dateFormat.parse(dateTimeArr[0]);
        } catch (ParseException e) {
            date = dashDateFormat.parse(dateTimeArr[0]);
        }
        try {
            time = timeFormat.parse(dateTimeArr[1]);
        } catch (ParseException e) {
            time = twelveHrTimeFormat.parse(dateTimeArr[1]);
        }
        return new Deadline(arr[0].substring(9), date, time);
    }

    /**
     * Identifies if the command intended to be a mark as done command to mark a task as done.
     *
     * @param command String of the command user input.
     * @return Boolean if the command is intended to be a mark as done command.
     */
    public static boolean isMarkDone(String command) {
        return (command.length() >= 4 && command.substring(0, 4).equals("done"));
    }

    /**
     * Identifies the index of task to be marked as done from the user command input.
     *
     * @param command String of the command user input.
     * @return Integer index of the task to be marked as done.
     */
    public static int taskToMarkDone(String command) {
        assert command.substring(0, 4).equals("done") : "done command invalid";
        int curr = Integer.parseInt(command.substring(5));
        return curr;
    }

    /**
     * Identifies if the command intended to be a list command to list out all tasks.
     *
     * @param command String of the command user input.
     * @return Boolean if the command is intended to be a list command.
     */
    public static boolean isListCommand(String command) {
        return (command.length() == 4 && command.equals("list"));
    }

    /**
     * Parses the user input command to call the correct intended command.
     * Commands include delete, list, deadline, event, todo, bye.
     *
     * @param command String of the command user input.
     * @param ui Ui initialized in duke.
     * @return Command according to the command from user.
     * @throws DukeException If the command is incorrect and not understood by Duke.
     */
    public static Command parse(String command, Ui ui) throws DukeException {
        if (command.equals("bye")) {
            return new ByeCommand(command);
        } else if (Parser.isDeleteCommand(command)) {
            return new DeleteCommand(command);
        } else if (Parser.isMarkDone(command)) {
            return new MarkDoneCommand(command);
        } else if (Parser.isListCommand(command)) {
            return new ListCommand(command);
        } else if (Parser.isFindCommand(command)) {
            return new FindCommand(command);
        } else if (Parser.isTodo(command)) {
            return new TodoCommand(command);
        } else if (Parser.isEvent(command)) {
            return new EventCommand(command);
        } else if (Parser.isDeadline(command)) {
            return new DeadlineCommand(command);
        } else {
            throw new DukeException(ui.noSuchCommand());
        }
    }

    /**
     * Identifies if the command intended to be a find command to find a task.
     *
     * @param command String of the command user input.
     * @return Boolean if the command is intended to be a find command.
     */
    public static boolean isFindCommand(String command) {
        return (command.length() >= 4 && command.substring(0, 4).equals("find"));
    }

    /**
     * Returns the keyword found in the command to find a task in the task list.
     *
     * @param command String of the command user input.
     * @return String of the keyword.
     */
    public static String getKeyword(String command) {
        return command.substring(5);
    }
}
