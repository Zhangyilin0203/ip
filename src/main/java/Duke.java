import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String initialGreet= "____________________________________________________________\n" +
                " Hello! I'm Duke\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n";

        System.out.println(initialGreet);
        echoCommand();
    }
    public static void echoCommand(){
        String line;
        Scanner in=new Scanner(System.in);
        line=in.nextLine();
        while(!line.equals("bye")){
            System.out.print("____________________________________________________________\n" +line+
                    "\n____________________________________________________________\n");
            line=in.nextLine();
        }
        System.out.println("____________________________________________________________\n" +"Bye. Hope to see you again soon"+
                "\n____________________________________________________________\n");
    }
}
