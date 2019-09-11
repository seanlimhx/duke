/**
 * A Command abstract class that gives the basic properties and methods of a command
 *
 * @author Sean
 *
 */

public abstract class Command {
    protected boolean isExit = false;
    private String details;

    /**
     * Default Command constructor
     * @param details
     */
    public Command(String details) {
        this.details = details;
    }

    /**
     * Return details of a Command
     * @return
     */
    public String getDetails() {
        return this.details;
    }


    /**
     * Return a boolean of whether the program should exit
     * @return
     */
    public boolean isExit() {
        return this.isExit;
    }

    /**
     * Carry out the respective function of the command
     * @param tasks
     * @param storage
     */
    public abstract void execute(TaskList tasks, Storage storage);
}
