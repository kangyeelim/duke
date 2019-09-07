package seedu.duke;

/**
 * Represents the exception specific to duke.
 */
public class DukeException extends Exception {
    private String errMsg;

    /**
     * Class constructor that takes in a string error message.
     *
     * @param errMsg String of exception message that Duke should let the user know.
     */
    public DukeException(String errMsg) {
        super(errMsg);
        assert errMsg.length() > 0 : "No err msg";
        this.errMsg = errMsg;
    }

    /**
     * Class constructor.
     */
    public DukeException() {
    }

    /**
     * Returns string representation of the duke exception.
     *
     * @return Error message of the duke exception.
     */
    @Override
    public String toString() {
        return this.errMsg;
    }

}
