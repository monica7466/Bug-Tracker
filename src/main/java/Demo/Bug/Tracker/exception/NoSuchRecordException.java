package Demo.Bug.Tracker.exception;

 

public class NoSuchRecordException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

 
    // If given record is not present in the list of record then NoSuchRecordException is accessed.
    public NoSuchRecordException(String message) {
        super(message);
    }
}