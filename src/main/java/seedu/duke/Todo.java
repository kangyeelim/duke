package seedu.duke;

/**
 * Represents the todo task which extends <code>Task</code>. A <code>Todo</code> object
 * can take in a description.
 */
public class Todo extends Task {

    /**
     * Constructor of Todo.
     *
     * @param description String description of the todo task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * String representation of the todo task with its description.
     *
     * @return String with the type of [task] [tick or cross] description.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * String representation of the todo task with its description
     * to write into the data file.
     *
     * @return String with the type of task | boolean of whether done | description.
     */
    @Override
    public String toWriteIntoFile() {
        return "T" + super.toWriteIntoFile();
    }
}
