package Demo.Bug.Tracker.exception;

public class MessageNotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

 
    //If filled wrong field then InvalidFieldException is accessed.
    public MessageNotFoundException(String message) {
        super(message);
    }
    }
