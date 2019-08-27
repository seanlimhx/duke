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
                    for (int x = 0; x < tasks.size(); x++) {
                        System.out.println(x + 1 + "." + tasks.get(x).getStatusIcon() + tasks.get(x).getName());
                    }
                    break;
                default:
                    if (input.length() >= 6 && input.substring(0, 5).equals("done ")) {
                        String number = input.substring(5);
                        int index = Integer.parseInt(number);
                        tasks.get(index-1).markAsDone();
                        System.out.println("Nice! I've marked this task as done:\n" + tasks.get(index-1).getStatusIcon() + tasks.get(index-1).getName());
                    } else {
                        Task task = new Task(input);
                        tasks.add(task);
                        System.out.println("added: " + input);
                    }
            }
            input = scanner.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
        return;
    }
}
