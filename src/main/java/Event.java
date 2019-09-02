import java.time.LocalDate;

public class Event extends Task {
    private String at;
    private LocalDate date;

    public Event(String name, String at) {
        super(name);
        this.at = at;
    }

    public Event(String name, String at, boolean isDone) {
        super(name, isDone);
        this.at = at;
    }

    public String toString() {
        return "[E]" + super.toString() + "(at: " + at + ")";
    }
}