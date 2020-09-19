package duke;

import java.io.IOException;

public class Duke {
    private static Storage storage;
    private static TaskList tasks;
    private static Ui ui;
    private static final String FILE_PATH="duke.txt";
    public static int countThings = 0;

    public Duke(String filePath) throws IOException {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList();
    }

    public void run() throws DukeException {
        countThings = storage.readFromFile(tasks);
        ui.greeting();
        ui.getCount(countThings);
        ui.interact(tasks);
        ui.bye();
        storage.writeToFile(tasks);
    }

    public static void main(String[] args) throws DukeException, IOException {
        new Duke(FILE_PATH).run();
    }

}
