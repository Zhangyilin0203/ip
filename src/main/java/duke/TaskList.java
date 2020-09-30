package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;
import static java.util.stream.Collectors.toList;

/**
 * Provide a list that all the data can be stored into.
 * Support functions including add, delete, print tasks and find keywords of a task.
 */
public class TaskList {
    private static final int DONE_COMMAND_LENGTH = 4;
    private static final int TODO_COMMAND_LENGTH = 4;
    private static final int DEADLINE_COMMAND_LENGTH = 8;
    private static final int EVENT_COMMAND_LENGTH = 5;
    private static final int BY_COMMAND_LENGTH = 4;
    private static final int AT_COMMAND_LENGTH = 4;
    private static final int FIND_COMMAND_LENGTH = 4;
    private static final int DELETE_COMMAND_LENGTH = 6;
    private static ArrayList<Task> tasksList;

    /**
     * A constructor that initialize the taskList when there is no existing taskList.
     */
    public TaskList(){
        this.tasksList = new ArrayList<>();
    }

    /**
     * A constructor that initialize the taskList when there is an existing taskList.
     *
     * @param tasksList the existing taskList that we want our tasksList to be equal to.
     */
    public TaskList(ArrayList<Task> tasksList){
        this.tasksList = tasksList;
    }

    /**
     * Add a task to the taskList.
     *
     * @param task the task to be added.
     */
    public void add(Task task){
        tasksList.add(task);
    }

    /**
     * remove the task from the taskList.
     *
     * @param index the index of the removed task.
     * @return the removed task.
     */
    public Task remove(int index) {
        Task removeTask = tasksList.remove(index);
        return removeTask;
    }

    /**
     * get the task with this index.
     *
     * @param index the index of the needed task.
     * @return the task with this index.
     */
    public Task get(int index) {
        Task getTask=tasksList.get(index);
        return getTask;
    }

    /**
     * get the whole taskList.
     *
     * @return the corresponding taskList.
     */
    public ArrayList<Task> getTasksList(){
        return tasksList;
    }

    /**
     * Print everything in the taskList.
     */
    public static void printList() {
        int count = 1;
        for(Task task : tasksList){
            System.out.print(count + ". ");
            System.out.println(task);
            count++;
        }
    }

    /**
     * To find corresponding tasks which include the required keyword.
     *
     * @param inputLine user input command to show the required keyword.
     */
    public static void findTasks(String inputLine) {
        String findLine = inputLine.substring(FIND_COMMAND_LENGTH+1);
        ArrayList<Task> findTasks = (ArrayList<Task>) tasksList.stream()
                .filter((t) -> t.getDescription().contains(findLine))
                .collect(toList());
        System.out.println("Here are the matching tasks in your list:");
        int count = 1;
        for (Task task : findTasks) {
            System.out.print(count + ". ");
            System.out.println(task);
            count++;
        }
        if (count == 1) {
            System.out.println("no matching result");
        }
    }

    /**
     * To add a todo task into the taskList.
     *
     * @param inputLine User input command showing the description of the todo task.
     * @throws DukeException Throw the DukeException.
     */
    public static void addTodoTask(String inputLine) throws DukeException {
        String todoDescription;
        todoDescription = inputLine.substring(TODO_COMMAND_LENGTH + 1);
        Task task = new Todo(todoDescription);
        tasksList.add(task);
        Ui.printTask(task);

    }

    /**
     * To add a deadline task into the taskList.
     *
     * @param inputLine User input command showing the description and deadline of the task.
     * @throws DukeException Throw the DukeException.
     */
    public static void addDeadlineTask(String inputLine) throws DukeException {
        String deadlineDescription;
        String deadlineByDate;
        int getIndex;
        getIndex = inputLine.indexOf("/");
        deadlineDescription = inputLine.substring(DEADLINE_COMMAND_LENGTH + 1, getIndex - 1);
        deadlineByDate = inputLine.substring(getIndex+ BY_COMMAND_LENGTH);
        Task task = new Deadline(deadlineDescription, deadlineByDate);
        tasksList.add(task);
        Ui.printTask(task);

    }

    /**
     * To add an event to the taskList.
     *
     * @param inputLine User input command showing the description and time of the event.
     * @throws DukeException Throw the DukeException.
     */
    public static void addEventTask(String inputLine) throws DukeException {
        String eventDescription;
        String eventAtDate;
        int getIndex;
        getIndex = inputLine.indexOf("/");
        eventDescription = inputLine.substring(EVENT_COMMAND_LENGTH + 1, getIndex - 1);
        eventAtDate = inputLine.substring(getIndex + AT_COMMAND_LENGTH);
        Task task = new Event(eventDescription, eventAtDate);
        tasksList.add(task);
        Ui.printTask(task);
    }

    /**
     * To delete an item in the taskList.
     *
     * @param inputLine User input command showing the index of the deleted task.
     * @param countTasks The number of the tasks in the taskList, to decide whether the index is out of bound.
     * @throws DukeException Throw exception when the index is out of bound.
     */
    public static void deleteItem(String inputLine, int countTasks) throws DukeException {
        int countTasksLocal = countTasks;
        int index = Integer.parseInt(inputLine.substring(DELETE_COMMAND_LENGTH + 1));
        if(index > countTasksLocal){
            throw new DukeException();
        }
        Task task = tasksList.remove(index - 1);
        countTasksLocal--;
        System.out.println("Noted. I've removed this task: ");
        System.out.println(task);
        System.out.println("Now you have " + countTasksLocal + " tasks in the list.");
    }

    /**
     * To mark task as done when you finish the task.
     *
     * @param inputLine User input command showing the index of the done task.
     * @param countTasks The number of the tasks in the taskList, to decide whether the index is out of bound.
     * @throws DukeException Throw exception when the index is out of bound.
     */
    public static void markAsDone(String inputLine, int countTasks) throws DukeException{
        int index = Integer.parseInt(inputLine.substring(DONE_COMMAND_LENGTH+1));
        if (index > countTasks) {
            throw new DukeException();
        }
        tasksList.get(index-1).taskDone();
        System.out.println("Nice! I've marked this task as done:\n" + tasksList.get(index-1));
    }


}
