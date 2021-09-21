package Demo.Bug.Tracker.exception;

public class BugNotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

 
  //If admin is not able to found the bug then BugNotFoundException is accessed.
    public BugNotFoundException (String message) {
        super(message);
}
    }
