package seedu.duke;

import java.io.*;
import java.util.ArrayList;

/**
 * Does the execution of loading tasks from the file and saving tasks in the file.
 * Able to load from existing file or create new file, overwrite existing file or append to existing file.
 */
public class Storage {
    protected String filepath;

    /**
     * Constructor of ByeCommand.
     *
     * @param filepath String of filepath for file to be worked with.
     */
    public Storage(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Loads the information in the existing data file into the <code>Tasklist</code>.
     * Else, creates data file if it does not exist.
     *
     * @return ArrayList of tasks that is loaded from data file
     * @throws Exception Exception if file cannot be loaded or created thrown by <code>BufferedReader</code> or <code>File</code>.
     * In addition, if the format of the tasks in the data file is incorrect.
     */
    public ArrayList<Task> load() throws Exception {
        //return array after reading from file
        ArrayList<Task> tasks = new ArrayList<>();
        File f = new File(filepath);
        f.getParentFile().mkdirs();
        f.createNewFile();
        BufferedReader bfr = new BufferedReader(new FileReader(f));
        String line = null;
        while ((line = bfr.readLine()) != null) {
            Task t = Parser.readInFileLine(line);
            tasks.add(t);
        }
        return tasks;
    }

    /**
     * Writes the information of the task into existing data file.
     * Writes it in format according to <code>toWriteIntoFile</code> in <code>Deadline</code>,
     * <code>Event</code> or <code>Todo</code>.
     *
     * @return ArrayList of tasks that is loaded from data file
     * @throws IOException Exception if file cannot be written into thrown by <code>FileWriter</code>.
     */
    public void writeFile(TaskList tasks) throws IOException {
        FileWriter fw = new FileWriter(this.filepath);
        String textFileMsg = "";
        for (int i = 0; i < tasks.size(); i++) {
            if (i == 0) {
                textFileMsg = textFileMsg + tasks.get(i).toWriteIntoFile();
            } else {
                textFileMsg = textFileMsg + System.lineSeparator() + tasks.get(i).toWriteIntoFile();
            }
        }
        fw.write(textFileMsg);
        fw.close();
    }

    /**
     * Appends the information of the task into existing data file.
     * Appends it in format according to <code>toWriteIntoFile</code> in <code>Deadline</code>,
     * <code>Event</code> or <code>Todo</code>.
     *
     * @return ArrayList of tasks that is loaded from data file
     * @throws IOException Exception if file cannot be appended to thrown by <code>FileWriter</code>.
     */
    public void appendFile(TaskList tasks) throws IOException {
        String textFileMsg = System.lineSeparator() + tasks.get(tasks.size() - 1).toWriteIntoFile();
        FileWriter fw = new FileWriter(filepath, true);
        fw.write(textFileMsg);
        fw.close();
    }
}
