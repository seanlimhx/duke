public abstract class Command {
    protected boolean isExit = false;
    private String details;

    public Command(String details) {
        this.details = details;
    }

    public String getDetails() {
        return this.details;
    }

    

    public boolean isExit() {
        return this.isExit;
    }

    public abstract void execute(TaskList tasks, Storage storage);
}
