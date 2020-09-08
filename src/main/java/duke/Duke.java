package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.Scanner;

public class Duke {
    static int countThings=0;
    static Task[] tasks = new Task[100];

    public static void storeTextAndList() throws DukeException{
        String inputLine;
        Scanner in = new Scanner(System.in);
        inputLine = in.nextLine();
        while(!inputLine.equals("bye")){
            printLine();
            try{
                if(inputLine.equals("list")){
                    int count;
                    for(count=0;count<countThings;count++){
                        System.out.print(count+1 + ". ");
                        System.out.println(tasks[count]);
                    }
                } else if(inputLine.contains("done")){
                    int index = Integer.parseInt(inputLine.substring(5));
                    doneTask(index);
                } else {
                    if (inputLine.contains("todo")) {
                        addTodoTask(inputLine);
                    } else if (inputLine.contains("deadline")) {
                        addDeadlineTask(inputLine);
                        ;
                    } else if (inputLine.contains("event")) {
                        addEventTask(inputLine);
                    } else {
                        throw new DukeException();
                    }
                }
            }catch (DukeException e){
                dealWithException(inputLine);
            }
            printLine();
            inputLine = in.nextLine();
        }
        bye();
    }

    public static void dealWithException(String inputLine){
        if(inputLine.equals("todo")){
            System.out.println("OOPS!!! The description of a todo cannot be empty.");
        }else if(inputLine.equals("deadline")){
            System.out.println("OOPS!!! The description of a deadline cannot be empty.");
        }else if(inputLine.equals("event")){
            System.out.println("OOPS!!! The description of a event cannot be empty.");
        }else{
            System.out.println(("OOPS!!! I'm sorry, but I don't know what that means :-("));
        }
    }

    public static void addTodoTask(String inputLine) throws DukeException{
        String todoDescription;
        if(inputLine.equals("todo")){
            throw new DukeException();
        }
        todoDescription = inputLine.substring(5);
        Task task = new Todo(todoDescription);
        tasks[countThings] = task;
        countThings++;
        printTask(task);
    }

    public static void addDeadlineTask(String inputLine) throws DukeException{
        String deadlineDescription;
        String deadlineByDate;
        int getIndex;
        if(inputLine.equals("deadline")){
            throw new DukeException();
        }
        getIndex = inputLine.indexOf("/");
        deadlineDescription = inputLine.substring(9,getIndex-1);
        deadlineByDate = inputLine.substring(getIndex+4);
        Task task = new Deadline(deadlineDescription, deadlineByDate);
        tasks[countThings] = task;
        countThings++;
        printTask(task);
    }

    public static void addEventTask(String inputLine) throws DukeException{
        String eventDescription;
        String eventAtDate;
        int getIndex;
        if(inputLine.equals("event")){
            throw new DukeException();
        }
        getIndex = inputLine.indexOf("/");
        eventDescription = inputLine.substring(6,getIndex-1);
        eventAtDate = inputLine.substring(getIndex+4);
        Task task = new Event(eventDescription, eventAtDate);
        tasks[countThings] = task;
        countThings++;
        printTask(task);
    }

    public static void printTask(Task task){
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + countThings + " tasks in the list.");
    }

    public static void doneTask(int index){
        tasks[index-1].taskDone();
        System.out.println("Nice! I've marked this task as done:\n" +tasks[index-1]);
    }

    public static void printLine(){
        System.out.println("____________________________________________________________");
    }

    public static void bye(){
        printLine();
        System.out.println("Bye. Hope to see you again soon");
        printLine();
    }


    public static void main(String[] args) throws DukeException{
        String initialGreet = "____________________________________________________________\n" +
                " Hello! I'm Duke.Duke\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n";

        System.out.println(initialGreet);
        storeTextAndList();
    }


}
