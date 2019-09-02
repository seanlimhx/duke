import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Deadline extends Task {
    //private String by;
    private LocalDate date;
    private LocalTime time;

    public Deadline(String name, String by) {
        super(name);
        String[] dateTime = by.split(" ", 2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        date = LocalDate.parse(dateTime[0], formatter);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HHmm");
        time = LocalTime.parse(dateTime[1], formatter2);
        //this.by = by;
    }

    public Deadline(String name, String by, boolean isDone) {
        super(name, isDone);
        String[] dateTime = by.split(" ", 2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        date = LocalDate.parse(dateTime[0], formatter);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HHmm");
        time = LocalTime.parse(dateTime[1], formatter2);
        //this.by = by;

    }

    public String getDate() {
        return this.date.format(DateTimeFormatter.ofPattern("d MMMM yyyy, EEEE"));
    }

    public String getTime() {
        return this.time.format(DateTimeFormatter.ofPattern("h:mm a"));
    }

    public String toString() {
        return "[D]" + super.toString() + "(by: " + getDate() /*date.toString()*/ + " " + /*time.toString()*/ getTime() + ")";
    }
}