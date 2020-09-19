package duke;

import duke.task.Task;

import java.util.ArrayList;

public class Parser {
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String DELETE = "delete";
    public static final String DONE = "done";
    public static final String LIST = "list";
    public static final String BYE = "bye";
    public static final String FAIL = "fail";
    public static final String FIND = "find";

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
}
