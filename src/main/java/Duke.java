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
        String ending = "bye";
        ArrayList tasks = new ArrayList();
        while (!input.equals(ending)) {
            switch(input) {
                case "list":
                    for (int x = 0; x < tasks.size(); x++) {
                        System.out.println(x+1 + ". " + tasks.get(x));
                    }
                    break;
                default:
                    tasks.add(input);
                    System.out.println("added: " + input);
            }
            input = scanner.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
        return;
    }
}
