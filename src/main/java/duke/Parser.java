package duke;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Parser {
    private static final String TODO_COMMAND = "todo";
    private static final String DEADLINE_COMMAND = "deadline";
    private static final String EVENT_COMMAND = "event";
    private static final String DELETE_COMMAND = "delete";
    private static final String DONE_COMMAND = "done";
    private static final String LIST_COMMAND = "list";
    private static final String BYE_COMMAND = "bye";
    private static final String FIND_COMMAND = "find";
    private static final String FAIL = "fail";

    /**
     * Parse user input command and deal with incorrect input.
     *
     * @param inputLine User input command line.
     * @return The parsed command line.
     * @throws DukeException Throw invalid or incomplete exceptions.
     */
    public static String getCommand(String inputLine) throws DukeException {
        try{
            if (inputLine.equals(LIST_COMMAND)) {
                return LIST_COMMAND;
            } else if (inputLine.equals(BYE_COMMAND)) {
                return BYE_COMMAND;
            } else if ( inputLine.equals(TODO_COMMAND) || inputLine.equals(DEADLINE_COMMAND)
                    || inputLine.equals(EVENT_COMMAND) || inputLine.equals(DONE_COMMAND)
                    || inputLine.equals(DELETE_COMMAND)) {
                throw new DukeException();
            } else if (inputLine.contains(TODO_COMMAND)) {
                return TODO_COMMAND;
            } else if (inputLine.contains(EVENT_COMMAND)) {
                return EVENT_COMMAND;
            } else if (inputLine.contains(DEADLINE_COMMAND)) {
                return DEADLINE_COMMAND;
            } else if (inputLine.contains(DELETE_COMMAND)) {
                return DELETE_COMMAND;
            } else if (inputLine.contains(DONE_COMMAND)) {
                return DONE_COMMAND;
            } else if (inputLine.contains(FIND_COMMAND)) {
                return FIND_COMMAND;
            }
            else {
                throw new DukeException();
            }
        } catch (DukeException e) {
            Ui.dealWithException(inputLine);
            return FAIL;
        }
    }

    /**
     * Function to parse date.
     * If it is not a recognizable date, it will not convert it to standard output datetime.
     *
     * @param datetime User input date.
     * @return A string contains the parsed datetime.
     */
    public static String getDateFormat(String datetime) {
        LocalDate date;
        String dateForm;
        try {
            date = LocalDate.parse(datetime);
            dateForm = date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        } catch (Exception e) {
            dateForm=datetime;
        }
        return dateForm;
    }
}
