import java.time.LocalDateTime;

public class Deadline extends Event implements Completable {

    private boolean complete;

    public Deadline(String name, LocalDateTime deadline) {
        super(name, deadline);
        complete = false;
    }

    public void complete() {
        complete = true;
    }

    public boolean isComplete() {
        return complete;
    }
}
