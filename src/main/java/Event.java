import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    //private String at;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public Event(String name, String at) {
        super(name);
        String[] dateTime = at.split(" ", 2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        if (!dateTime[0].contains("-")) {
            this.startDate = LocalDate.parse(dateTime[0], formatter);
        }
        else {
            String[] startEndDates = dateTime[0].split("-");
            this.startDate = LocalDate.parse(startEndDates[0], formatter);
            this.endDate = LocalDate.parse(startEndDates[1], formatter);
        }

        String[] time = dateTime[1].split("-");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HHmm");
        this.startTime = LocalTime.parse(time[0], formatter2);
        this.endTime = LocalTime.parse(time[1], formatter2);
        //this.at = at;
    }

    public Event(String name, String at, boolean isDone) { //for user input using program
        super(name);
        String[] dateTime = at.split(" ", 2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        if (!dateTime[0].contains("-")) {
            this.startDate = LocalDate.parse(dateTime[0], formatter);
        }
        else {
            String[] startEndDates = dateTime[0].split("-");
            this.startDate = LocalDate.parse(startEndDates[0], formatter);
            this.endDate = LocalDate.parse(startEndDates[1], formatter);
        }

        String[] startEndTime = dateTime[1].split("-");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HHmm");
        this.startTime = LocalTime.parse(startEndTime[0], formatter2);
        this.endTime = LocalTime.parse(startEndTime[1], formatter2);
    }

    public Event(String name, String date, String time, boolean isDone) { //for reading txt file storage
        super(name);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy EEEE");
        if (!date.contains(" to ")) {
            this.startDate = LocalDate.parse(date, formatter);
        }
        else {
            String[] startEndDates = date.split(" to ");
            this.startDate = LocalDate.parse(startEndDates[0], formatter);
            this.endDate = LocalDate.parse(startEndDates[1], formatter);
        }

        String[] startEndTime = time.split(" to ");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("h:mm a");
        this.startTime = LocalTime.parse(startEndTime[0], formatter2);
        this.endTime = LocalTime.parse(startEndTime[1], formatter2);
    }


    public String getDate() {
        return (this.endDate == null) ? this.startDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy EEEE")) :
                this.startDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy EEEE")) + " to " + this.endDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy EEEE"));
    }
    public String getStartTime() {
        return this.startTime.format(DateTimeFormatter.ofPattern("h:mm a"));
    }
    public String getEndTime() {
        return this.endTime.format(DateTimeFormatter.ofPattern("h:mm a"));
    }

    public String toString() {
        return "[E]" + super.toString() + "(at: " + getDate() + ", " + getStartTime() + " to " + getEndTime()  + ")";
    }
}