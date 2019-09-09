public class ByeCommand extends Command{
    public ByeCommand(String details, boolean isExit) {
        super(details);
        super.isExit = isExit;
    }

    @Override
    public void execute(TaskList tasks, Storage storage) {
        System.out.println("Bye. Hope to see you again soon!");
        storage.save(tasks.getArrayListTasks());
    }
}
