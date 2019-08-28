import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;



public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello I'm\n" + logo + "What can I do for you?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayList<Task> tasks = new ArrayList();
        while (!input.equals("bye")) {
            try {
                switch (input) {
                    case "list":
                        System.out.println("Here are the tasks in your list:");
                        for (int x = 0; x < tasks.size(); x++) {
                            System.out.println(x + 1 + "." + tasks.get(x).toString());
                            System.out.println(tasks.get(x).toText()); //TESTING PLS DELETE
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
                        case "deadline": //WRONG
                            System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                            input = scanner.nextLine();
                            break;
                        case "event": //WRONG
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

        String filePath = "C:/Users/limhx/Desktop/CEG Y2S1/CS2113/duke/src/data/data.txt";
        File inputFile = new File(filePath);
        if (inputFile.exists()) {
            System.out.println(inputFile.getName() + " exists");
            System.out.println("The file is " + inputFile.length() + " bytes long");
            if (inputFile.canRead())
                System.out.println(" ok to read");
            else
                System.out.println(" not ok to read");
            if (inputFile.canWrite())
                System.out.println(" ok to write");
            else
                System.out.println(" not ok to write");
            System.out.println("path: " + inputFile.getAbsolutePath());
            System.out.println("File Name: " + inputFile.getName());
            System.out.println("File Size: " + inputFile.length() + " bytes");
        } else {
            System.out.println("File does not exist");
            try {
                inputFile.createNewFile();
            }
            catch(IOException e) {
                System.out.println("file not found and error creating new file");
            }
        }
        //use filewriter to write line by line to the file ( like system.out.print like that)
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for (int i = 0; i < tasks.size(); i++) {
                fileWriter.write(tasks.get(i).toText() + "\n");
                System.out.println(tasks.get(i).toText() + "\n");
                System.out.println("task " + (i+1) + " written" );
            }
            System.out.println("filewriter succeeded");
        }
        catch(Exception e) {
            System.out.println("filewriter failed");
        }

        //use Scanner = new Scanner(file) to read from file can use hasNextLine as per normal

        return;
    }
}
