package Demo.Bug.Tracker.exception;

public class ReportNotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

 
    // If given project is not present in the list of project then ReportNotFoundException is accessed.
    public ReportNotFoundException(String message) {
        super(message); 
    }

}
