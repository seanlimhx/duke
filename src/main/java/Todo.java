public class Todo extends Task{
    public Todo(String name) {
        super(name);
    }

    public Todo(String name, boolean isDone) {
        super(name, isDone);
    }

    public String toString() {
        return "[T]" + super.toString();
    }
}