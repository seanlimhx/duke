public class Task {
    private String name;
    private boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String getName() {
        return name;
    }

    public String getStatusIcon() {
        return (this.isDone) ? "[✓]" : "[✗]";
    }
}
