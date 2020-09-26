package duke;

import duke.task.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;

public class Parser {
    private static final String TODO = "todo";
    private static final String DEADLINE = "deadline";
    private static final String EVENT = "event";
    private static final String DELETE = "delete";
    private static final String DONE = "done";
    private static final String LIST = "list";
    private static final String BYE = "bye";
    private static final String FIND = "find";
    public static final String FAIL = "fail";

    /**
     * Parse user input command and deal with incorrect input.
     *
     * @param inputLine User input command line.
     * @return The parsed command line.
     * @throws DukeException Throw invalid or incomplete exceptions.
     */
    public static String getCommand(String inputLine) throws DukeException {
        try{
            if (inputLine.equals(LIST)) {
                return LIST;
            } else if (inputLine.equals(BYE)) {
                return BYE;
            } else if ( inputLine.equals(TODO) || inputLine.equals(DEADLINE)
                    || inputLine.equals(EVENT) || inputLine.equals(DONE)
                    || inputLine.equals(DELETE)) {
                throw new DukeException();
            } else if (inputLine.contains(TODO)) {
                return TODO;
            } else if (inputLine.contains(EVENT)) {
                return EVENT;
            } else if (inputLine.contains(DEADLINE)) {
                return DEADLINE;
            } else if (inputLine.contains(DELETE)) {
                return DELETE;
            } else if (inputLine.contains(DONE)) {
                return DONE;
            } else if (inputLine.contains(FIND)) {
                return FIND;
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
