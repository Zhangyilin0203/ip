import java.util.Scanner;
import java.util.Arrays;
public class Duke {
    static int countThings=0;
    static Task [] tasks = new Task[100];

    public static void storeTextAndList(){
        String inputLine;
        Scanner in = new Scanner(System.in);
        inputLine = in.nextLine();
        while(!inputLine.equals("bye")){
            printLine();
            if(inputLine.equals("list")){
                int count;
                for(count=0;count<countThings;count++){
                    System.out.print(count+1 + ". ");
                    System.out.println(tasks[count]);
                }
            } else if(inputLine.contains("done")){
                int index = Integer.parseInt(inputLine.substring(5));
                doneTask(index);
            } else{
                if(inputLine.contains("todo")){
                    addTodoTask(inputLine);
                }else if(inputLine.contains("deadline")){
                    addDeadlineTask(inputLine);;
                }else{
                    addEventTask(inputLine);
                }
            }
            printLine();
            inputLine = in.nextLine();
        }
        bye();
    }

    public static void addTodoTask(String inputLine){
        String todoDescription;
        todoDescription = inputLine.substring(5);
        Task task = new Todo(todoDescription);
        tasks[countThings] = task;
        countThings++;
        printTask(task);
    }

    public static void addDeadlineTask(String inputLine){
        String deadlineDescription;
        String deadlineByDate;
        int getIndex;
        getIndex = inputLine.indexOf("/");
        deadlineDescription = inputLine.substring(9,getIndex-1);
        deadlineByDate = inputLine.substring(getIndex+4);
        Task task = new Deadline(deadlineDescription, deadlineByDate);
        tasks[countThings] = task;
        countThings++;
        printTask(task);
    }

    public static void addEventTask(String inputLine){
        String eventDescription;
        String eventAtDate;
        int getIndex;
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


    public static void main(String[] args) {
        String initialGreet = "____________________________________________________________\n" +
                " Hello! I'm Duke\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n";

        System.out.println(initialGreet);
        storeTextAndList();
    }


}
