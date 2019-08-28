public class Event extends Task {
    private String at;

    public Event(String name, String at) {
        super(name);
        this.at = at;
    }

    public String toString() {
        return "[E]" + super.toString() + "(at: " + at + ")";
    }

    public String toText() {
        return "E | " + this.getStatusIcon() + " | " + super.getName() + "| " + at;
    }
}
