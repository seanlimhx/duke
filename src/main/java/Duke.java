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
            switch(input) {
                case "list":
                    System.out.println("Here are the tasks in your list:");
                    for (int x = 0; x < tasks.size(); x++) {
                        System.out.println(x + 1 + "." + tasks.get(x).toString());
                    }
                    break;
                default:
                    if (input.length() >= 6 && input.substring(0, 5).equals("done ")) {
                        String number = input.substring(5);
                        int index = Integer.parseInt(number);
                        tasks.get(index-1).markAsDone();
                        System.out.println("Nice! I've marked this task as done:\n" + tasks.get(index-1).getStatusIcon() + tasks.get(index-1).getName());
                    }
                    else if (input.length() >= 10 && input.substring(0, 9).equals("deadline ")){
                        String details = input.substring(9);
                        int delimiter = details.indexOf("/");
                        String task = details.substring(0, delimiter);
                        String time = details.substring(delimiter+4);
                        Deadline deadline = new Deadline(task, time);
                        tasks.add(deadline);
                        System.out.println("Got it. I've added this task:\n" + deadline.toString() + "\nNow you have " + tasks.size() + " tasks in the list.");
                    }
                    else if (input.length() >= 7 && input.substring(0, 6).equals("event ")) {
                        String details = input.substring(6);
                        int delimiter = details.indexOf("/");
                        String task = details.substring(0, delimiter);
                        String time = details.substring(delimiter+4);
                        Event event = new Event(task, time);
                        tasks.add(event);
                        System.out.println("Got it. I've added this task:\n" + event.toString() + "\nNow you have " + tasks.size() + " tasks in the list.");
                    }
                    else {
                        String details = input.substring(5);
                        Todo todo = new Todo(details);
                        tasks.add(todo);
                        System.out.println("Got it. I've added this task:\n" + todo.toString() + "\nNow you have " + tasks.size() + " tasks in the list.");
                    }
            }
            input = scanner.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
        return;
    }
}
