public class DoneCommand extends Command {

    public DoneCommand(String details) {
        super(details);
    }

    public void execute(TaskList tasks) {
        int index = Integer.parseInt(super.getDetails());
        tasks.markAsDone(index - 1);
        System.out.println("Nice! I've marked this task as done:\n" + tasks.getIndivTask(index - 1).getStatusIcon() + tasks.getIndivTask(index - 1).getName());
    }

}
