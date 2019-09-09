import java.time.DateTimeException;

public class AddCommand extends Command{
    private String type;

    public AddCommand(String type, String details) {
        super(details);
        this.type = type;
    }

    public void execute(TaskList tasks, Storage storage) {
        try {
            switch (this.type) {
                case "todo":
                    Todo todo = new Todo(super.getDetails());
                    tasks.addTask(todo);
                    System.out.println("Got it. I've added this task:\n" + todo.toString() + "\nNow you have " + tasks.getNumOfTasks() + " tasks in the list.");
                    break;
                case "deadline":
                    String[] deadlineInfo = super.getDetails().split("/by ");
                    Deadline deadline = new Deadline(deadlineInfo[0], deadlineInfo[1]);
                    tasks.addTask(deadline);
                    System.out.println("Got it. I've added this task:\n" + deadline.toString() + "\nNow you have " + tasks.getNumOfTasks() + " tasks in the list.");
                    break;
                case "event":
                    String[] eventInfo = super.getDetails().split("/at ");
                    Event event = new Event(eventInfo[0], eventInfo[1]);
                    tasks.addTask(event);
                    System.out.println("Got it. I've added this task:\n" + event.toString() + "\nNow you have " + tasks.getNumOfTasks() + " tasks in the list.");
                    break;
            }
        } catch (DateTimeException e) {
            //System.out.println(e.getMessage());
            System.out.println("☹ OOPS!!! Please input a correct date and time! E.g. dd/mm/yyyy HHmm (time in 24hr format)");
        }

    }




}
