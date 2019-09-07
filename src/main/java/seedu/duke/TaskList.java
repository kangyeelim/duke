package seedu.duke;

import java.util.ArrayList;

/**
 * Represents the list of tasks in Duke. <code>TaskList</code> allows tasks to be added,
 * removed and retrieved.
 * It can also return the size of the list of tasks.
 */
public class TaskList {
    protected ArrayList<Task> arr;

    /**
     * Class constructor that takes in an arraylist of tasks.
     *
     * @param arr Arraylist of tasks.
     */
    public TaskList(ArrayList<Task> arr) {
        this.arr = arr;
    }

    /**
     * Class constructor.
     */
    public TaskList() {
        this.arr = new ArrayList<>();
    }

    /**
     * Returns integer number of tasks in list.
     *
     * @return Integer size of the list of tasks.
     */
    public int size() {
        return arr.size();
    }

    /**
     * Returns task at a specific index in list.
     * The first task in the list starts with index 0.
     *
     * @param index Index of task to retrieve from list.
     * @return Task from list at index.
     */
    public Task get(int index) {
        return arr.get(index);
    }

    /**
     * Removes the task at a specific index in list.
     * The first task in the list starts with index 0.
     *
     * @param index Index of task to remove from list.
     */
    public void remove(int index) {
        assert index >= 0 : "Invalid task number";
        (this.arr).remove(index);
    }

    /**
     * Adds the task at the end of list.
     * The first task in the list starts with index 0.
     *
     * @param task Task to be added to the list.
     */
    public void add(Task task) {
        (this.arr).add(task);
    }
}
