import java.time.DateTimeException;
import java.util.Scanner;

public class Ui {
    public Ui() {

    }

    public void showLoadingError() {
        System.out.println("Loading error");
    }

    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello I'm\n" + logo + "What can I do for you?");
    }

    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    public void showError(String error) {
        String[] inputWords = error.split(" ");
        if (inputWords.length == 1) {
            switch (inputWords[0]) {
                case "todo":
                    System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                    break;
                case "deadline":
                    System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                    break;
                case "event":
                    System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
                    break;
                case "done":
                    System.out.println("☹ OOPS!!! Which task did you complete?");
                    break;
                default:
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        } else {
            System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    public String readCommand() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
