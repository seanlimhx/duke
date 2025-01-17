import java.time.DateTimeException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            if (e.getMessage().isEmpty()) {
                tasks = new TaskList();
            } else {
                ui.showLoadingError();
                System.out.println(e.getMessage());
                System.out.println("This is the task that went wrong: '" + e.getMessage() + "'.");
                tasks = new TaskList();
            }
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            String fullCommand = ui.readCommand();
            //System.out.println("--reading command");
            ui.showLine();
            try {
                Command c = Parser.parse(fullCommand);
                //System.out.println("--getting details");
                //System.out.println(c.getDetails());
                //System.out.println("--created Command object");
                //System.out.println("--executing Command");
                c.execute(tasks, storage);
//                System.out.println("--executed Command");
                isExit = c.isExit();
            } catch (DukeException | ArrayIndexOutOfBoundsException e) {
                //System.out.println(e.getMessage());
                ui.showError(fullCommand);
            } finally {
                ui.showLine();
            }
        }
    }
    public static void main(String[] args) {
        new Duke("C:/Users/limhx/Desktop/CEG/CEGY2S1/CS2113/duke/src/data/data.txt").run();
    }

/*
    public static void main (String[] args) throws Exception{

        ArrayList<Task> tasks = new ArrayList<Task>();

        File file = new File("C:/Users/limhx/Desktop/CEG/CEG Y2S1/CS2113/duke/src/data/data.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();

            }
        } catch (IOException e) {
            System.out.println("creating file failed, contact admin");
        }

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String task = sc.nextLine();
                //System.out.println("scanned");
                if (task.indexOf("T") == 1){
                    String description = task.substring(6);
                    boolean isDone = task.contains("✓");
                    Todo todo = new Todo(description, isDone);
                    tasks.add(todo);
                    //System.out.println("added");
                }
                else if (task.indexOf("D") == 1){
                    int descriptionEnd = task.indexOf("(");
                    String description = task.substring(6, descriptionEnd);
                    int byEnd = task.indexOf(")");
                    String by = task.substring(descriptionEnd+5, byEnd);
                    String[] dateAndTime = by.split(", ", 2);
                    boolean isDone = task.contains("✓");
                    Deadline deadline = new Deadline(description, dateAndTime[0], dateAndTime[1], isDone);
                    tasks.add(deadline);
                }
                else if (task.indexOf("E") == 1){
                    int descriptionEnd = task.indexOf("(");
                    String description = task.substring(6, descriptionEnd);
                    int atEnd = task.indexOf(")");
                    String at = task.substring(descriptionEnd+5, atEnd);
                    String[] dateAndTime = at.split(", ", 2);
                    boolean isDone = task.contains("✓");
                    Event event = new Event(description, dateAndTime[0], dateAndTime[1], isDone);
                    tasks.add(event);
                }
                //System.out.println("This is what was read: " + task);

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
                String[] details = input.split(" ", 2);
                switch (details[0]) {
                    case "list":
                        System.out.println("Here are the tasks in your list:");
                        for (int x = 0; x < tasks.size(); x++) {
                            System.out.println(x + 1 + "." + tasks.get(x).toString());
                        }
                        break;
                    case "done":
                        int index = Integer.parseInt(details[1]);
                        tasks.get(index - 1).markAsDone();
                        System.out.println("Nice! I've marked this task as done:\n" + tasks.get(index - 1).getStatusIcon() + tasks.get(index - 1).getName());
                        break;
                    case "delete":
                        index = Integer.parseInt(details[1]);
                        System.out.println("Noted. I've removed this task: \n" + "     " +
                                tasks.get(index - 1) + "\n" +
                                "Now you have " + (tasks.size()-1) + " tasks in the list.");
                        tasks.remove(index - 1);
                        break;
                    case "find":
                        System.out.println("Here are the matching tasks in your list:");
                        for (int x = 0; x < tasks.size(); x++) {
                            if (tasks.get(x).getName().contains(details[1])) {
                                System.out.println((x+1) + ". " + tasks.get(x).toString());
                            }
                        }
                        break;
                    case "todo":
                        Todo todo = new Todo(details[1]);
                        tasks.add(todo);
                        System.out.println("Got it. I've added this task:\n" + todo.toString() + "\nNow you have " + tasks.size() + " tasks in the list.");
                        break;
                    case "deadline":
                        String[] deadlineInfo = details[1].split("/by ");
                        Deadline deadline = new Deadline(deadlineInfo[0], deadlineInfo[1]);
                        tasks.add(deadline);
                        System.out.println("Got it. I've added this task:\n" + deadline.toString() + "\nNow you have " + tasks.size() + " tasks in the list.");
                        break;
                    case "event":
                        String[] eventInfo = details[1].split("/at ");
                        Event event = new Event(eventInfo[0], eventInfo[1]);
                        tasks.add(event);
                        System.out.println("Got it. I've added this task:\n" + event.toString() + "\nNow you have " + tasks.size() + " tasks in the list.");
                        break;
                    default:
                        //System.out.println("dukeexception triggered");
                        throw new DukeException();
                }
                input = scanner.nextLine();
            } catch (DukeException e) {
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

            } catch (DateTimeException e) {
                System.out.println("☹ OOPS!!! Please input a correct date and time! E.g. dd/mm/yyyy HHmm (time in 24hr format)");
                input = scanner.nextLine();
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


    }*/
}