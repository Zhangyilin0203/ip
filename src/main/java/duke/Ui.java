package duke;

import duke.task.Task;

import java.util.Scanner;

public class Ui {
    public static int countTasks = 0;
    private static TaskList tasks = new TaskList();
    private Parser parser;

    private static final String TODO = "todo";
    private static final String DEADLINE = "deadline";
    private static final String EVENT = "event";
    private static final String DELETE = "delete";
    private static final String DONE = "done";
    private static final String LIST = "list";
    private static final String BYE = "bye";
    private static final String FIND = "find";


    /**
     * Get the total number of tasks after the data is read from a file.
     *
     * @param countThings The total number of tasks in the taskList.
     */
    public void getCount(int countThings) {
        this.countTasks = countThings;
    }

    /**
     * Get user input commands and handle the user input commands.
     *
     * @param tasks The taskList that contains all the information of tasks.
     * @throws DukeException Throw exception when there is incorrect or incomplete input commands.
     */
    public void interact(TaskList tasks) throws DukeException {
        String inputLine;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            inputLine = in.nextLine();
            Ui.printLine();
            String command = parser.getCommand(inputLine);
            switch (command) {
            case LIST:
                tasks.printList();
                break;
            case DONE:
                tasks.markAsDone(inputLine, countTasks);
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
                tasks.deleteItem(inputLine, countTasks);
                countTasks--;
                break;
            case FIND:
                tasks.findTasks(inputLine);
                break;
            case BYE:
                return;
            }
            Ui.printLine();
        }
    }

    /**
     * Print out the information of the task every time when a new task is being added.
     *
     * @param task The taskList that contains all the information of tasks.
     */
    public static void printTask(Task task) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + countTasks + " tasks in the list.");
    }

    /**
     * Deal with all the incorrect and incomplete user input command.
     *
     * @param inputLine User input command.
     */
    public static void dealWithException(String inputLine) {
        if (inputLine.equals(TODO)) {
            System.out.println("OOPS!!! The description of a todo cannot be empty.");
        } else if (inputLine.equals(DEADLINE)) {
            System.out.println("OOPS!!! The description of a deadline cannot be empty.");
        } else if (inputLine.equals(EVENT)) {
            System.out.println("OOPS!!! The description of a event cannot be empty.");
        } else if (inputLine.contains(DONE)) {
            System.out.println("OOPS!!! The done index is out of bound.");
        } else if (inputLine.contains(DELETE)) {
            System.out.println("OOPS!!! The delete index is out of bound.");
        } else {
            System.out.println(("OOPS!!! I'm sorry, but I don't know what that means :-("));
        }
    }

    /**
     * Print out bye when Duke is about to end.
     */
    public static void bye() {
        System.out.println("Bye. Hope to see you again soon");
        printLine();
    }

    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Greet the user everytime they open Duke.
     */
    public static void greeting() {
        String initialGreet = "____________________________________________________________\n" +
                " Hello! I'm Duke\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n";

        System.out.println(initialGreet);
    }
}
