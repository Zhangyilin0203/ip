package duke;

import duke.task.Task;

import java.util.Scanner;

public class Ui {
    public static TaskList tasks = new TaskList();
    public static int countTasks = 0;
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String DELETE = "delete";
    public static final String DONE = "done";
    public static final String LIST = "list";
    public static final String BYE = "bye";
    public Parser parser;

    public void getCount(int countThings){
        this.countTasks =countThings;
    }

    public void interact(TaskList tasks) throws DukeException{
        String inputLine;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            inputLine = in.nextLine();
            Ui.printLine();
            String command = parser.getCommand(inputLine);
            switch (command) {
                case LIST:
                    tasks.printList();
                    break;
                case DONE:
                    tasks.markAsDone(inputLine,countTasks);
                    break;
                case TODO:
                    countTasks++;
                    tasks.addTodoTask(inputLine);
                    break;
                case DEADLINE:
                    countTasks++;
                    tasks.addDeadlineTask(inputLine);
                    break;
                case EVENT:
                    countTasks++;
                    tasks.addEventTask(inputLine);
                    break;
                case DELETE:
                    tasks.deleteItem(inputLine,countTasks);
                    break;
                case BYE:
                    return;
            }
            Ui.printLine();
        }
    }

    public static void printTask(Task task){
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + countTasks + " tasks in the list.");
    }

    public static void dealWithException(String inputLine){
        if(inputLine.equals(TODO)){
            System.out.println("OOPS!!! The description of a todo cannot be empty.");
        }else if(inputLine.equals(DEADLINE)){
            System.out.println("OOPS!!! The description of a deadline cannot be empty.");
        }else if(inputLine.equals(EVENT)) {
            System.out.println("OOPS!!! The description of a event cannot be empty.");
        }else if(inputLine.contains(DONE)) {
            System.out.println("OOPS!!! The done index is out of bound.");
        }else if(inputLine.contains(DELETE)) {
            System.out.println("OOPS!!! The delete index is out of bound.");
        }else{
            System.out.println(("OOPS!!! I'm sorry, but I don't know what that means :-("));
        }
    }

    public static void bye(){
        System.out.println("Bye. Hope to see you again soon");
        printLine();
    }

    public static void printLine(){
        System.out.println("____________________________________________________________");
    }

    public static void greeting(){
        String initialGreet = "____________________________________________________________\n" +
                " Hello! I'm Duke\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n";

        System.out.println(initialGreet);
    }
}
