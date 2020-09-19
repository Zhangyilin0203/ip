package duke;

import java.io.IOException;

/**
 * Main class of the application.
 * A task storage system which can store events, deadlines as well as todos.
 * It supports features like add and remove tasks, search for keywords as well as mark tasks as done.
 * It can also list all the tasks you have.
 */
public class Duke {
    private static Storage storage;
    private static TaskList tasks;
    private static Ui ui;
    private static final String FILE_PATH="duke.txt";
    public static int countThings = 0;

    /**
     * Constructor for the main program.
     * Initialize the UI, Storage and taskList.
     *
     * @param filePath the path that you are going to store the data.
     * @throws IOException If an input or output exception occurred.
     */
    public Duke(String filePath) throws IOException {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList();
    }

    /**
     * Start the Duke program.
     *
     * @throws DukeException Throw the dukeException.
     */
    public void run() throws DukeException {
        countThings = storage.readFromFile(tasks);
        ui.greeting();
        ui.getCount(countThings);
        ui.interact(tasks);
        ui.bye();
        storage.writeToFile(tasks);
    }

    /**
     * initialize Duke and run.
     *
     * @param args
     * @throws DukeException throw the exception.
     * @throws IOException throw the input or output exception.
     */
    public static void main(String[] args) throws DukeException, IOException {
        new Duke(FILE_PATH).run();
    }

}
