package seedu.duke;

import java.util.ArrayList;

public class ExpenseList {
    protected ArrayList<Expense> arr;

    /**
     * Class constructor that takes in an arraylist of expenses.
     *
     * @param arr Arraylist of tasks.
     */
    public ExpenseList(ArrayList<Expense> arr) {
        this.arr = arr;
    }

    /**
     * Class constructor.
     */
    public ExpenseList() {
        this.arr = new ArrayList<>();
    }

    /**
     * Returns integer number of expenses in list.
     *
     * @return Integer size of the list of expenses.
     */
    public int size() {
        return arr.size();
    }

    /**
     * Returns expense at a specific index in list.
     * The first expense in the list starts with index 0.
     *
     * @param index Index of expense to retrieve from list.
     * @return Expense from list at index.
     */
    public Expense get(int index) {
        return arr.get(index);
    }

    /**
     * Removes the expense at a specific index in list.
     * The first expense in the list starts with index 0.
     *
     * @param index Index of expense to remove from list.
     */
    public void remove(int index) {
        assert index >= 0 : "Invalid task number";
        (this.arr).remove(index);
    }

    /**
     * Adds the expense at the end of list.
     * The first expense in the list starts with index 0.
     *
     * @param expense Expense to be added to the list.
     */
    public void add(Expense expense) {
        (this.arr).add(expense);
    }
}
