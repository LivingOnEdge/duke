package task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private String by;
    protected LocalDate date;
    protected LocalTime time;

    /**
     * Constructor class for Deadline object.
     *
     * @param description Description of the Deadline.
     * @param date Due date of Deadline in the format dd/MM/yyyy.
     * @param time Time format of deadline in the format HHmm.
     * @throws DateTimeParseException Exception in the event that format of date or time is incorrect.
     */
    public Deadline(String description, String date, String time) throws DateTimeParseException {
        super(description);
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.time = LocalTime.parse(time, DateTimeFormatter.ofPattern("HHmm"));
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: "
                + date.format(DateTimeFormatter.ofPattern("d MMM yyyy"))
                + ", " + time.format(DateTimeFormatter.ofPattern("h:mm a")) + ")";
    }

    @Override
    public String fileFormat() {
        return String.format("D | %s | %s | %s %s", isDoneString(), getDescription(),
                date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                time.format(DateTimeFormatter.ofPattern("HHmm")));
    }
}
