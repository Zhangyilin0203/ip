package duke.task;

import duke.Parser;

/**
 * A class for event that is inherited from the <code>Task</code> class.
 * Requires user to input the description and time of the event.
 */
public class Event extends Task {
    private static final String EVENT_TYPE = "[E]";
    private static final String EVENT_FILE_TYPE = "E|";
    private static final String SEPARATOR = "|";
    protected String atDate;
    protected Parser parser;

    /**
     * A constructor that create a new event from the description and time of the event.
     *
     * @param description The description of the event.
     * @param atDate The date that the event will happen.
     */
    public Event(String description, String atDate) {
        super(description);
        atDate= parser.getDateFormat(atDate);
        this.atDate=atDate;
    }

    /**
     * A type icon to tell that the task is an event.
     *
     * @return The type icon of the event.
     */
    public String getTypeIcon(){
        return EVENT_TYPE;
    }

    /**
     * Return a formatted event description.
     *
     * @return The standard output form of the event.
     */
    public String toString() {
        return this.getTypeIcon() + this.getStatusIcon() + description + " (at: " + atDate + ")";
    }

    /**
     * Return a formatted event description that could be written into a file.
     *
     * @return The standard form for event to write into local file.
     */
    public String printIntoFile(){
        return EVENT_FILE_TYPE + isDone + SEPARATOR + description + SEPARATOR + this.atDate;
    }
}
