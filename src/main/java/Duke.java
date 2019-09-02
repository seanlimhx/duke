import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Duke {
    public static void main (String[] args) throws Exception{

        ArrayList<Task> tasks = new ArrayList<Task>();

        File file = new File("C:/Users/limhx/Desktop/CEG Y2S1/CS2113/duke/src/data/data.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();

            }
        } catch (IOException e) {
            System.out.println("creating file failed, contact admin");
        }

        try {
            Scanner sc = new Scanner(file);
            //System.out.println("haven't scan");
            while (sc.hasNextLine()) {
                String task = sc.nextLine();
                //System.out.println("scanned");
                if (task.indexOf("T") == 1){
                    String description = task.substring(6);
                    boolean isDone = task.contains("✓");
                    Todo todo = new Todo(description, isDone);
                    tasks.add(todo);
                }
                else if (task.indexOf("D") == 1){
                    int descriptionEnd = task.indexOf("(");
                    String description = task.substring(6, descriptionEnd);
                    int byEnd = task.indexOf(")");
                    String by = task.substring(descriptionEnd+5, byEnd);
                    boolean isDone = task.contains("✓");
                    Deadline deadline = new Deadline(description, by, isDone);
                    tasks.add(deadline);
                }
                else if (task.indexOf("E") == 1){
                    int descriptionEnd = task.indexOf("(");
                    String description = task.substring(6, descriptionEnd);
                    int atEnd = task.indexOf(")");
                    String at = task.substring(descriptionEnd+5, atEnd);
                    boolean isDone = task.contains("✓");
                    Event event = new Event(description, at, isDone);
                    tasks.add(event);
                }
              //  System.out.println("This is what was read: " + task);

            }
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello I'm\n" + logo + "What can I do for you?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("bye")) {
            try {
                switch (input) {
                    case "list":
                        System.out.println("Here are the tasks in your list:");
                        for (int x = 0; x < tasks.size(); x++) {
                            System.out.println(x + 1 + "." + tasks.get(x).toString());
                        }
                        break;
                    default:
                        if (input.substring(0, 5).equals("done ")) {
                            String number = input.substring(5);
                            int index = Integer.parseInt(number);
                            tasks.get(index - 1).markAsDone();
                            System.out.println("Nice! I've marked this task as done:\n" + tasks.get(index - 1).getStatusIcon() + tasks.get(index - 1).getName());
                        } else if (input.substring(0, 5).equals("todo ")) {
                            String details = input.substring(5);
                            System.out.println(details);
                            Todo todo = new Todo(details);
                            tasks.add(todo);
                            System.out.println("Got it. I've added this task:\n" + todo.toString() + "\nNow you have " + tasks.size() + " tasks in the list.");
                        } else if (input.substring(0, 6).equals("event ")) {
                            String details = input.substring(6);
                            int delimiter = details.indexOf("/");
                            String task = details.substring(0, delimiter);
                            String time = details.substring(delimiter + 4);
                            Event event = new Event(task, time);
                            tasks.add(event);
                            System.out.println("Got it. I've added this task:\n" + event.toString() + "\nNow you have " + tasks.size() + " tasks in the list.");
                        } else if (input.substring(0, 9).equals("deadline ")) {
                            String details = input.substring(9);
                            int delimiter = details.indexOf("/");
                            String task = details.substring(0, delimiter);
                            String time = details.substring(delimiter + 4);
                            Deadline deadline = new Deadline(task, time);
                            tasks.add(deadline);
                            System.out.println("Got it. I've added this task:\n" + deadline.toString() + "\nNow you have " + tasks.size() + " tasks in the list.");
                        }
                }
                input = scanner.nextLine();
            } catch (Exception e) {
                String[] inputWords = input.split(" ");
                if (inputWords.length == 1) {
                    switch (inputWords[0]) {
                        case "todo":
                            System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                            input = scanner.nextLine();
                            break;
                        case "deadline":
                            System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                            input = scanner.nextLine();
                            break;
                        case "event":
                            System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
                            input = scanner.nextLine();
                            break;
                        case "done":
                            System.out.println("☹ OOPS!!! Which task did you complete?");
                            input = scanner.nextLine();
                            break;
                        default:
                            System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                            input = scanner.nextLine();
                    }
                } else {
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    input = scanner.nextLine();
                }

            }
        }
        System.out.println("Bye. Hope to see you again soon!");
        


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


    }
}