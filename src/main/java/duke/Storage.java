package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Loading the tasks from file and saving the tasks to file.
 */
public class Storage {
    private static ArrayList<Task> taskArrayList;
    private static File f;
    private static String filePath;
    public static int countFileTasks = 0;

    /**
     * Constructor of the Storage class.
     * Initialize file f and file path, if f does not exists, creat a new file f.
     *
     * @param filePath the path that is the destination of the file.
     * @throws IOException
     */
    public Storage(String filePath) throws IOException {
        f = new File(filePath);
        f.createNewFile();
        this.filePath=filePath;
    }

    /**
     * Write the data from taskList into file.
     *
     * @param tasks the taskList that the data is stored during running the program.
     */
    public static void writeToFile(TaskList tasks){
        try {
            FileWriter fw = new FileWriter(filePath);
            taskArrayList = tasks.getTasksList();
            for(Task task: taskArrayList) {
                fw.write(task.printIntoFile() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    /**
     * Read data from file and store the data into the taskList.
     *
     * @param tasks A taskList that store the data read from file.
     */
    public static int readFromFile(TaskList tasks){
        try {
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
                countFileTasks++;
                if(taskInFile[1].equals("true")){
                    task.taskDone();
                }
                tasks.add(task);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
        }
        return countFileTasks;
    }
}
