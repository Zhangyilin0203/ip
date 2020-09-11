package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.Scanner;
import java.util.ArrayList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Duke {
    static int countThings=0;
    //public static final int MAXIMUM_TASK_NUMBER = 100;
    //static Task[] tasks = new Task[MAXIMUM_TASK_NUMBER];
    public static ArrayList<Task> taskArray = new ArrayList<>();
    public static final String FILE_PATH = "duke.txt";

    public static void writeToFile(String FILE_PATH){
        try {
            File f = new File(FILE_PATH);
            FileWriter fw = new FileWriter(FILE_PATH);
            for(Task task: taskArray){
                fw.write(task.printIntoFile() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public static void readFromFile(String FILE_PATH){
        try {
            File f = new File(FILE_PATH);
            Scanner sc = new Scanner(f);
            Task task;
            while(sc.hasNext()){
                String[] taskInFile = sc.nextLine().split("\\|");
                if(taskInFile[0].equals("T")){
                    task = new Todo(taskInFile[2]);
                }else if(taskInFile[0].equals("D")){
                    task = new Deadline(taskInFile[2],taskInFile[3]);
                }else{
                    task = new Event(taskInFile[2], taskInFile[3]);
                }
                countThings++;
                if(taskInFile[1].equals("true")){
                    task.taskDone();
                }
                taskArray.add(task);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
        }
    }

    public static void storeTextAndList() throws DukeException{
        String inputLine;
        Scanner in = new Scanner(System.in);
        inputLine = in.nextLine();
        while(!inputLine.equals("bye")){
            printLine();
            try{
                if(inputLine.equals("list")){
                    printList();
                } else if(inputLine.contains("done")){
                    int index = Integer.parseInt(inputLine.substring(5));
                    if(index > countThings){
                        throw new DukeException();
                    }
                    markAsDone(index);
                }else if (inputLine.contains("todo")) {
                    addTodoTask(inputLine);
                } else if (inputLine.contains("deadline")) {
                    addDeadlineTask(inputLine);
                } else if (inputLine.contains("event")) {
                    addEventTask(inputLine);
                } else if (inputLine.contains("delete")){
                    int index = Integer.parseInt(inputLine.substring(7));
                    if(index > countThings){
                        throw new DukeException();
                    }
                    deleteItem(index);
                } else {
                    throw new DukeException();
                }
            }catch (DukeException e){
                dealWithException(inputLine);
            }
            printLine();
            inputLine = in.nextLine();
        }
        bye();
    }



    private static void printList() {
        int count = 1;
        for(Task task : taskArray){
            System.out.print(count + ". ");
            System.out.println(task);
            count++;
        }
    }

    public static void dealWithException(String inputLine){
        if(inputLine.equals("todo")){
            System.out.println("OOPS!!! The description of a todo cannot be empty.");
        }else if(inputLine.equals("deadline")){
            System.out.println("OOPS!!! The description of a deadline cannot be empty.");
        }else if(inputLine.equals("event")) {
            System.out.println("OOPS!!! The description of a event cannot be empty.");
        }else if(inputLine.contains("done")) {
            System.out.println("OOPS!!! The done index is out of bound.");
        }else if(inputLine.contains("delete")) {
            System.out.println("OOPS!!! The delete index is out of bound.");
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
        //tasks[countThings] = task;
        countThings++;
        taskArray.add(task);
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
        //tasks[countThings] = task;
        countThings++;
        taskArray.add(task);
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
        //tasks[countThings] = task;
        countThings++;
        taskArray.add(task);
        printTask(task);

    }

    public static void printTask(Task task){
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + countThings + " tasks in the list.");
    }

    public static void markAsDone(int index){
        taskArray.get(index-1).taskDone();
        System.out.println("Nice! I've marked this task as done:\n" +taskArray.get(index-1));
    }

    private static void deleteItem(int index) {
        Task task = taskArray.remove(index - 1);
        System.out.println("Noted. I've removed this task: ");
        System.out.println(task);
        countThings--;
        System.out.println("Now you have " + countThings + " tasks in the list.");
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
        readFromFile(FILE_PATH);
        String initialGreet = "____________________________________________________________\n" +
                " Hello! I'm Duke\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n";

        System.out.println(initialGreet);
        storeTextAndList();
        writeToFile(FILE_PATH);
    }


}
