package Demo.Bug.Tracker.exception;

 

public class InvalidFieldException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

 
    //If filled wrong field then InvalidFieldException is accessed.
    public InvalidFieldException(String message) {
        super(message);
    }
}