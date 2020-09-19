package duke.task;
import duke.Parser;

/**
 * A class for deadline tasks that is inherited from the <code>Task</code> class.
 * Requires user to input the description and deadline of the task.
 */
public class Deadline extends Task {

    protected String byDate;
    protected Parser parser;

    /**
     * A constructor that create a new deadline task from the description and deadline of the task.
     *
     * @param description The description of the deadline task.
     * @param byDate The date of the deadline.
     */
    public Deadline(String description, String byDate) {
        super(description);
        byDate= parser.getDateFormat(byDate);
        this.byDate=byDate;
    }

    /**
     * A type icon to tell that the task is a deadline task.
     *
     * @return The type icon of the deadline task.
     */
    public String getTypeIcon(){
        return "[D]";
    }

    /**
     * Return a formatted deadline description.
     *
     * @return The standard output form of the deadline task.
     */
    public String toString(){
        return this.getTypeIcon() + this.getStatusIcon() + description + " (by: " + byDate + ")";
    }

    /**
     * Return a formatted deadline task description that could be written into a file.
     *
     * @return The standard form for deadline task to write into local file.
     */
    public String printIntoFile(){
        return "D|" + isDone + "|" + description + "|" + this.byDate;
    }


}
