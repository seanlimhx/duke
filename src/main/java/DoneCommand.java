public class DoneCommand extends Command {

    public DoneCommand(String details) {
        super(details);
    }

    public void execute(TaskList tasks, Storage storage) {
        System.out.println("entered DoneCommand.execute()");
        int index = Integer.parseInt(super.getDetails());
        System.out.println(index);
        tasks.markAsDone(index - 1);
        System.out.println("Nice! I've marked this task as done:\n" + tasks.getIndivTask(index - 1).getStatusIcon() + tasks.getIndivTask(index - 1).getName());
    }

}
