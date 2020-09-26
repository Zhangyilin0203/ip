package duke.task;

/**
 * A class for todotasks that is inherited from the <code>Task</code> class.
 * Requires user to input the description and time of the todotask.
 */
public class Todo extends Task{

    public static final String TODO_SYMBOL = "[T]";
    public static final String TODO_FILE_SYMBOL = "T|";
    public static final String SEPARATOR = "|";

    /**
     * A constructor that create a new todotask from the description of the task.
     *
     * @param description The description of the todotask.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * A type icon to tell that the task is a todotask.
     *
     * @return The type icon of the todotask.
     */
    public String getTypeIcon(){
        return TODO_SYMBOL;
    }

    /**
     * Return a formatted todotask description.
     *
     * @return The standard output form of the todotask.
     */
    public String toString(){
        return this.getTypeIcon() + this.getStatusIcon() + description;
    }

    /**
     * Return a formatted todotask description that could be written into a file.
     *
     * @return The standard form for todotask to write into local file.
     */
    public String printIntoFile(){
        return TODO_FILE_SYMBOL + isDone + SEPARATOR + description;
    }
}
