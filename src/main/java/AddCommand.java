public class AddCommand extends Command{
    private String type;

    public AddCommand(String type, String details) {
        super(details);
        this.type = type;
    }

    public void execute(TaskList tasks) {
        if (this.type.equals("todo")) {
            Todo todo = new Todo(super.getDetails());
            tasks.addTask(todo);
            System.out.println("Got it. I've added this task:\n" + todo.toString() + "\nNow you have " + tasks.getNumOfTasks() + " tasks in the list.");
        } else if (this.type.equals("deadline")) {
            String[] deadlineInfo = super.getDetails().split("/by ");
            Deadline deadline = new Deadline(deadlineInfo[0], deadlineInfo[1]);
            tasks.addTask(deadline);
            System.out.println("Got it. I've added this task:\n" + deadline.toString() + "\nNow you have " + tasks.getNumOfTasks() + " tasks in the list.");
        } else if (this.type.equals("event")) {
            String[] eventInfo = super.getDetails().split("/at ");
            Event event = new Event(eventInfo[0], eventInfo[1]);
            tasks.addTask(event);
            System.out.println("Got it. I've added this task:\n" + event.toString() + "\nNow you have " + tasks.getNumOfTasks() + " tasks in the list.");
        }

    }




}
