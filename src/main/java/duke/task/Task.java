package duke.task;

/**
 * A class for task objects.
 * The parent class of the event, deadline and todo class.
 */
public class Task {
    public static final String TICK_SYMBOL = "[\u2713]";
    public static final String X_SYMBOL = "[\u2718]";
    private static final String TASK_FILE_SYMBOL = "Task|";
    private static final String SEPARATOR = "|";
    protected String description;
    protected boolean isDone;

    /**
     * Constructor of the task object.
     * Create a new task object from the given description.
     *
     * @param description The description of the task given by user.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public String getStatusIcon() {
        return (isDone ? TICK_SYMBOL : X_SYMBOL); //return tick or X symbols
    }

    public void taskDone(){
        this.isDone=true;
    }

    public String toString(){
        return this.getStatusIcon() + description;
    }

    public String printIntoFile(){
        return TASK_FILE_SYMBOL + isDone + SEPARATOR + description + SEPARATOR;
    }
}
