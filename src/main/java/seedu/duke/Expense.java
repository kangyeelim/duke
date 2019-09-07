package seedu.duke;

public class Expense {
    protected String description;
    protected double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDate() {
        return this.description;
    }

    public double getAmount() {
        return this.amount;
    }

    public String toString() {
        return this.description + ": " + this.amount;
    }

    public String toWriteIntoFile() {
        return this.description + ": " + this.amount;
    }
}
