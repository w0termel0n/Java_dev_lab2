import java.time.LocalDateTime;

public abstract class Event implements Comparable<Event> {

    private String name;
    private LocalDateTime dateTime;

    public Event() {
        name = "[Unnamed event]";
        dateTime = LocalDateTime.now();
    }

    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Event e) {
        return dateTime.compareTo(e.dateTime);
    }
}
