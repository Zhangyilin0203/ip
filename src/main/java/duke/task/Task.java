package duke.task;

/**
 * A class for task objects.
 * The parent class of the event, deadline and todo class.
 */
public class Task {
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
        return (isDone ? "[\u2713]" : "[\u2718]"); //return tick or X symbols
    }

    public void taskDone(){
        this.isDone=true;
    }

    public String toString(){
        return this.getStatusIcon() + description;
    }

    public String printIntoFile(){
        return "Task|" + isDone + "|" + description + "|";
    }
}
