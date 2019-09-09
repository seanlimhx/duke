public class ListCommand extends Command {

    public ListCommand(String details) {
        super(details);
    }

    public void execute(TaskList tasks, Storage storage) {
        System.out.println("Here are the tasks in your list:");
        for (int x = 0; x < tasks.getNumOfTasks(); x++) {
            System.out.println(x + 1 + "." + tasks.getIndivTask(x).toString());
        }
    }
}
