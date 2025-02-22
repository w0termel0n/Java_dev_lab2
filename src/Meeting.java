import java.time.Duration;
import java.time.LocalDateTime;

public class Meeting extends Event implements Completable{

    private LocalDateTime endDateTime;
    private String location;
    private boolean complete;

    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location) {
        super(name, start);
        endDateTime = end;
        this.location = location;
        complete = false;
    }

    public void complete() {
        complete = true;
    }

    public boolean isComplete() {
        return complete;
    }

    public LocalDateTime getEndTime() {
        return endDateTime;
    }

    public Duration getDuration() {
        return Duration.between(getDateTime(), endDateTime);
    }

    public String getLocation() {
        return location;
    }

    public void setEndTime(LocalDateTime date) {
        endDateTime = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
