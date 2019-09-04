public class FindCommand extends Command {

    public FindCommand(String details) {
        super(details);
    }

    public void execute(TaskList tasks){
        System.out.println("Here are the matching tasks in your list:");
        for (int x = 0; x < tasks.getNumOfTasks(); x++) {
            if (tasks.getIndivTask(x).getName().contains(super.getDetails())) {
                System.out.println((x+1) + ". " + tasks.getIndivTask(x).toString());
            }
        }
    }
}
