import java.util.ArrayList;
import java.util.List;
import  java.io.*;
import java.nio.file.*;

public class TaskManager {
    private List<String> tasks; // hint: will change in iteration 3
    private static final String FILE_NAME = "tasks.csv";

    public TaskManager() {
        this.tasks = new ArrayList<>();
        //initializeFile();
        loadTasksFromFile();
        createFileIfNotexists();
    }

    public void addTask(String task) {
    this.tasks.add(task);
    }
    public List<String> listTasks(){
    return  this.tasks;
    }

    public void deleteTask(String task){
//        leave for iteration 4
    }

    public void exit() {
        // leave for iteration 2
        saveTasksToFile();
        System.out.println("Saving tasks and exiting...");
    }

    private void createFileIfNotExists(){
        try {
            File file = new File(FILE_NAME);
            if(!file.exists()) {
                if(file.createNewFile()) {
                    System.out.println("File was not created successfully.");
                }
            }
        } catch (Exception e) {
            System.out.println("File could not be created.");
        }

    private void loadTasksFromFile() {
        try {
            Path path = Paths.get(FILE_NAME);
            if (!Files.exists(path)){
                tasks = Files.readAllLines(path);
            }

        }
        catch (IOException e) {
            System.out.println("File was not load successfully.");
        }
    }
    private void saveTasksToFile() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            for (String task : tasks){
                writer.write(task);
                writer.newLine();
            }
        }catch(IOException e){
            System.out.println("ERROR! Could not save tasks to file: " + e.getMessage());
        }
    }
}
}
//        } Callable<Object> callable = new Callable<Object>() {
//            public Object call() throws Exception {
//
//
//            }
//        };
//            Path path = (Paths.get(FILE_NAME);
//            if (!Files.exists(path))) {
//
//            }
////              tasks = Files.readAllLines(path));
//        } catch (IOException e) {
//            System.err.println("Error saving tasks to file: " + e.getMessage());
//        }
//