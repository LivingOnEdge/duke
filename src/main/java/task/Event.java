package task;

public class Event extends Task {
    //3.[E][✗] project meeting (at: Aug 6th 2-4pm)
    private String at;

    /**
     * Event constructor.
     *
     * @param description Description of Event.
     * @param at Venue of Event.
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    @Override
    public String fileFormat() {
        return String.format("E | %s | %s | %s", isDoneString(), getDescription(), this.at);
    }
}