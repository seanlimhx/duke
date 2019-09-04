public class DeleteCommand extends Command {

    public DeleteCommand(String details) {
        super(details);
    }

    public void execute(TaskList tasks) {
        int index = Integer.parseInt(super.getDetails());
        System.out.println("Noted. I've removed this task: \n" + "     " +
            tasks.getIndivTask(index - 1) + "\n" +
            "Now you have " + (tasks.getNumOfTasks()) + " tasks in the list.");
        tasks.deleteTask(index - 1);
    }
}
