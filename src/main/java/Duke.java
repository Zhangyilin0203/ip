import java.util.Scanner;
import java.util.Arrays;
public class Duke {
    static String [] thingsToDo=new String[100];
    static int countThings=0;
    static Task [] tasks=new Task[100];

    public static void storeTextAndList(){
        String line;
        Scanner in=new Scanner(System.in);
        line=in.nextLine();
        while(!line.equals("bye")){
            printLine();
            if(line.equals("list")){
                int count=0;
                for(count=0;count<countThings;count++){
                    System.out.print(String.format("%d. ",count+1));
                    System.out.println(tasks[count].getStatusIcon()+thingsToDo[count]);
                }
            }
            else if(line.contains("done")){
                int index=Integer.parseInt(line.substring(5));
                doneTask(index);
            }
            else{
                System.out.println("added: "+line);
                thingsToDo[countThings]=line;
                Task task= new Task(line);
                tasks[countThings]=task;
                countThings++;
            }
            printLine();
            line=in.nextLine();
        }
        bye();
    }

    public static void doneTask(int index){
        tasks[index].taskDone();
        System.out.println("Nice! I've marked this task as done:\n" +tasks[index].getStatusIcon()+thingsToDo[index]);
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
        String initialGreet= "____________________________________________________________\n" +
                " Hello! I'm Duke\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n";

        System.out.println(initialGreet);
        storeTextAndList();
    }


}
