package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;
import static java.util.stream.Collectors.toList;

public class TaskList {
    public static ArrayList<Task> tasksList;

    public TaskList(){
        this.tasksList = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasksList){
        this.tasksList = tasksList;
    }

    public void add(Task task){
        tasksList.add(task);
    }

    public Task remove(int index){
        Task removeTask = tasksList.remove(index);
        return removeTask;
    }

    public Task get(int index){
        Task getTask=tasksList.get(index);
        return getTask;
    }

    public ArrayList<Task> getTasksList(){
        return tasksList;
    }

    public static void printList() {
        int count = 1;
        for(Task task : tasksList){
            System.out.print(count + ". ");
            System.out.println(task);
            count++;
        }
    }

    public static void findTasks(String inputLine) {
        String findLine = inputLine.substring(5);
        ArrayList<Task> findTasks = (ArrayList<Task>) tasksList.stream()
                .filter((t) -> t.getDescription().contains(findLine))
                .collect(toList());
        System.out.println("Here are the matching tasks in your list:");
        int count = 1;
        for(Task task : findTasks){
            System.out.print(count + ". ");
            System.out.println(task);
            count++;
        }
        if(count==1){
            System.out.println("no matching result");
        }
    }

    public static void addTodoTask(String inputLine) throws DukeException{
        String todoDescription;
        todoDescription = inputLine.substring(5);
        Task task = new Todo(todoDescription);
        //tasks[countThings] = task;
        tasksList.add(task);
        Ui.printTask(task);

    }

    public static void addDeadlineTask(String inputLine) throws DukeException{
        String deadlineDescription;
        String deadlineByDate;
        int getIndex;
        getIndex = inputLine.indexOf("/");
        deadlineDescription = inputLine.substring(9,getIndex-1);
        deadlineByDate = inputLine.substring(getIndex+4);
        Task task = new Deadline(deadlineDescription, deadlineByDate);
        //tasks[countThings] = task;
        tasksList.add(task);
        Ui.printTask(task);

    }

    public static void addEventTask(String inputLine) throws DukeException{
        String eventDescription;
        String eventAtDate;
        int getIndex;
        getIndex = inputLine.indexOf("/");
        eventDescription = inputLine.substring(6,getIndex-1);
        eventAtDate = inputLine.substring(getIndex+4);
        Task task = new Event(eventDescription, eventAtDate);
        //tasks[countThings] = task;
        tasksList.add(task);
        Ui.printTask(task);
    }

    public static void deleteItem(String inputLine, int countTasks) throws DukeException {
        int index = Integer.parseInt(inputLine.substring(7));
        if(index > countTasks){
            throw new DukeException();
        }
        Task task = tasksList.remove(index - 1);
        countTasks--;
        System.out.println("Noted. I've removed this task: ");
        System.out.println(task);
        System.out.println("Now you have " + countTasks + " tasks in the list.");
    }

    public static void markAsDone(String inputLine, int countTasks) throws DukeException{
        int index = Integer.parseInt(inputLine.substring(5));
        if(index > countTasks){
            throw new DukeException();
        }
        tasksList.get(index-1).taskDone();
        System.out.println("Nice! I've marked this task as done:\n" + tasksList.get(index-1));
    }


}
