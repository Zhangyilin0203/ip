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
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String DELETE = "delete";
    public static final String DONE = "done";
    public static final String LIST = "list";
    public static final String BYE = "bye";
    public static final String FAIL = "fail";

    public static String getCommand(String inputLine) throws DukeException{
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
            }
            else {
                throw new DukeException();
            }
        } catch (DukeException e) {
            Ui.dealWithException(inputLine);
            return FAIL;
        }
    }

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
