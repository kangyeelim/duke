package seedu.duke;

import java.util.ArrayList;

public class StorageStub extends Storage {
    public StorageStub(String fp) {
        super(fp);
    }

    @Override
    public ArrayList<Task> loadTaskFile() {
        ArrayList<Task> arr = new ArrayList<>();
        arr.add(new Todo("abc"));
        arr.add(new Todo("def"));
        return arr;
    }
}
