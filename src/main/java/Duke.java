import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello I'm\n" + logo + "What can I do for you?");
        Scanner scanner = new Scanner(System. in);
        String input = scanner. nextLine();
        ArrayList<Task> tasks = new ArrayList();
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
                        }
                        else if (input.substring(0, 5).equals("todo ")){
                            String details = input.substring(5);
                            System.out.println(details);
                            Todo todo = new Todo(details);
                            tasks.add(todo);
                            System.out.println("Got it. I've added this task:\n" + todo.toString() + "\nNow you have " + tasks.size() + " tasks in the list.");
                        }
                        else if (input.substring(0, 6).equals("event ")) {
                            String details = input.substring(6);
                            int delimiter = details.indexOf("/");
                            String task = details.substring(0, delimiter);
                            String time = details.substring(delimiter + 4);
                            Event event = new Event(task, time);
                            tasks.add(event);
                            System.out.println("Got it. I've added this task:\n" + event.toString() + "\nNow you have " + tasks.size() + " tasks in the list.");
                        }
                        else if (input.substring(0, 9).equals("deadline ")) {
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
            } catch(Exception e) {
                String[] inputWords = input.split(" ");
                if (inputWords.length == 1) {
                    switch(inputWords[0]) {
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
                }
                else {
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    input = scanner.nextLine();
                }

            }
        }
        System.out.println("Bye. Hope to see you again soon!");
        return;
    }
}
