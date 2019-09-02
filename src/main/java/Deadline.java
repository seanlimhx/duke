import java.time.LocalDate;

public class Deadline extends Task {
    private String by;
    private LocalDate date;

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    public Deadline(String name, String by, boolean isDone) {
        super(name, isDone);
        this.by = by;
    }

    public String toString() {
        return "[D]" + super.toString() + "(by: " + by + ")";
    }
}