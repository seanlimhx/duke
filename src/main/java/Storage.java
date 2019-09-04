import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private File file;
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public Storage(String filePath) {
        this.file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();

            }
        } catch (IOException e) {
            System.out.println("creating file failed, contact admin");
        }
    }

    public ArrayList<Task> load() throws DukeException {
        try {
            Scanner sc = new Scanner(this.file);
            while (sc.hasNextLine()) {
                String task = sc.nextLine();
                System.out.println("scanned");
                if (task.indexOf("T") == 1) {
                    String description = task.substring(6);
                    boolean isDone = task.contains("✓");
                    Todo todo = new Todo(description, isDone);
                    this.tasks.add(todo);
                    System.out.println("added");
                } else if (task.indexOf("D") == 1) {
                    int descriptionEnd = task.indexOf("(");
                    String description = task.substring(6, descriptionEnd);
                    int byEnd = task.indexOf(")");
                    String by = task.substring(descriptionEnd + 5, byEnd);
                    String[] dateAndTime = by.split(", ", 2);
                    boolean isDone = task.contains("✓");
                    Deadline deadline = new Deadline(description, dateAndTime[0], dateAndTime[1], isDone);
                    this.tasks.add(deadline);
                } else if (task.indexOf("E") == 1) {
                    int descriptionEnd = task.indexOf("(");
                    String description = task.substring(6, descriptionEnd);
                    int atEnd = task.indexOf(")");
                    String at = task.substring(descriptionEnd + 5, atEnd);
                    String[] dateAndTime = at.split(", ", 2);
                    boolean isDone = task.contains("✓");
                    Event event = new Event(description, dateAndTime[0], dateAndTime[1], isDone);
                    this.tasks.add(event);
                } else {
                    throw new DukeException(task);
                }
                System.out.println("This is what was read: " + task);
            }
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }

        return this.tasks;
    }

    public void save(ArrayList<Task> tasks) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (Task task : tasks) {
                fileWriter.write(task.toString() + "\n");
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("write to file failed");
        }
        this.tasks = tasks;
    }
}
