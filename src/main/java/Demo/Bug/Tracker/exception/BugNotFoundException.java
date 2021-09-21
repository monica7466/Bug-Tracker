package Demo.Bug.Tracker.exception;

public class BugNotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

 

    public BugNotFoundException (String message) {
        super(message);
}
    }
