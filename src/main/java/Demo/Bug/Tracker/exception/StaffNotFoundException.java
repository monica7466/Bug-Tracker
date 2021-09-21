package Demo.Bug.Tracker.exception;

 

public class StaffNotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

 
    // If given project is not present in the list of project then StaffNotFoundException is accessed.
    public StaffNotFoundException(String message) {
        super(message);
    }
}