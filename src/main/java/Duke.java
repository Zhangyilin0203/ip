import java.util.Scanner;
import java.util.Arrays;
public class Duke {
    static String [] thingsToDo=new String[100];
    static int countThings=0;

    public static void storeTextAndList(){
        String line;
        Scanner in=new Scanner(System.in);
        line=in.nextLine();
        while(!line.equals("bye")){
            if(line.equals("list")){
                printLine();
                int count=0;
                for(count=0;count<countThings;count++){
                    System.out.print(String.format("%d. ",count+1));
                    System.out.println(thingsToDo[count]);
                }
                printLine();
            }
            else{
                printLine();
                System.out.println("added: "+line);
                printLine();
                thingsToDo[countThings]=line;
                countThings++;
            }
            line=in.nextLine();
        }
        bye();
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
